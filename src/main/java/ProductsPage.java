import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    @BeforeClass
    public void Close(){
        closeAdd.click();
    }
    @FindBy(id = "btn-close")
    private WebElement closeAdd;

    @FindBy(xpath = ".//*[@id='main_products_container']/ul/li/div[3]/p[1]/a")
    private List<WebElement> productList;

    @FindBy(xpath = ".//*[@id='main_products_container']/ul/li/div[2]/div[2]/div[2]")
    private List<WebElement> priceList;

    private WebDriver webDriver;
    public ProductsPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }
    public DetailedProduct goToPage(String productName){
        for(WebElement productElement:productList){
            if(productElement.getText().equals(productName)) {
                Assert.assertEquals("1.442 RON",priceList.get(productList.indexOf(productElement)).getText());
                System.out.println("Pretul este: "+priceList.get(productList.indexOf(productElement)).getText());
                productElement.click();
                break;
            }

        }
        return PageFactory.initElements(webDriver,DetailedProduct.class);
    }
}
