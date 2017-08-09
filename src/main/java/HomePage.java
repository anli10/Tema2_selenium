import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy (id = "autocomplete_prod")
    private WebElement searchField;

    @FindBy(xpath = ".//*[@id='main_search']/div/span[2]/button")
    private WebElement searchButton;

    private WebDriver webDriver;

    public HomePage(WebDriver driver){
        this.webDriver=driver;
    }

    public  ResultsPage searchProduct(String productName){

        searchField.sendKeys(productName);
        searchButton.click();

        return PageFactory.initElements(webDriver,ResultsPage.class);
    }
}
