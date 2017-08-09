import org.junit.Test;

public class TestClass extends  BasicTest{

    @Test
    public void firstTest(){

        ResultsPage resultsPage = homePage.searchProduct("iphone");

        ProductsPage productsPage=resultsPage.goToPage("Telefoane mobile");

        DetailedProduct detailedProduct =productsPage.goToPage("Telefon mobil Apple iPhone SE 16GB, iOS");
        detailedProduct.printNumber();
        detailedProduct.printMinimumPrice();
        detailedProduct.printMaximumPrice();

    }
}
