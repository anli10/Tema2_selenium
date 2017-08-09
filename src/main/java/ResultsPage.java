import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultsPage {


    @BeforeClass
    public void Close(){
        closeAdd.click();
    }
    @FindBy(id = "btn-close")
    private WebElement closeAdd;


    @FindBy(xpath = ".//*[@id='main_col']/div/ul[1]/li/a")
    private List<WebElement> categoryList;

    private WebDriver webDriver;

    public ResultsPage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public ProductsPage goToPage(String category){
        for(WebElement categoryElement:categoryList){
            if(categoryElement.getText().equals(category)) {
                categoryElement.click();
                break;
            }
        }
        return PageFactory.initElements(webDriver,ProductsPage.class);
    }
    public void waitUntil(){
        WebDriverWait wait=new WebDriverWait(webDriver,5000);
        wait.until(ExpectedConditions.visibilityOfAllElements(categoryList));

    }
}
