import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DetailedProduct {
    @BeforeClass
    public void Close(){
        closeAdd.click();
    }
    @FindBy(id = "btn-close")
    private WebElement closeAdd;


    @FindBy(css= "div[itemprop='seller']>p>a[class='inline-block']")
    private List<WebElement> shopsList;

    @FindBy(xpath = ".//*[@id='product_offers_container']/ul/li/div[2]/div[3]/p[1]/a")
    private List<WebElement> priceList;

    private WebDriver webDriver;
    public DetailedProduct(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public int Number(){
        int number=0;
        for(WebElement shopElement:shopsList){
            number++;
        }
        return number;
    }
   public void printNumber(){
       System.out.println("Sunt disponibile "+Number()+" magazine");
   }

   public int getMinimum(){

        String minimum= priceList.get(0).getText();
        int index=0;
       for(WebElement priceElement:priceList){
           if (priceElement.getText().compareTo(minimum)<0) {
               minimum = priceElement.getText();
               index = priceList.indexOf(priceElement);
           }
       }
       return index;
   }
   public void printMinimumPrice() {

       System.out.println("Pretul minimim este " +priceList.get(getMinimum()).getText()+" la magazinul "+shopsList.get(priceList.indexOf(priceList.get(getMinimum()))).getAttribute("title"));
   }

    public int getMaximum(){

        String maximum= priceList.get(0).getText();
        int index=0;
        for(WebElement priceElement:priceList){
            if (priceElement.getText().compareTo(maximum)>0) {
                maximum= priceElement.getText();
                index = priceList.indexOf(priceElement);
            }
        }
        return index;
    }
    public void printMaximumPrice() {

        Assert.assertEquals("2.399,90 RON",priceList.get(getMaximum()).getText());
        System.out.println("Pretul maxim este este " +priceList.get(getMaximum()).getText()+" la magazinul "+shopsList.get(priceList.indexOf(priceList.get(getMaximum()))).getAttribute("title"));
    }
}
