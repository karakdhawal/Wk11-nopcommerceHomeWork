package homepage;
/*
BaseUrl:
https://demo.nopcommerce.com/
Requirement:
● Create the package homepage
1. create class "TopMenuTest"
1.1 create method with name "selectMenu" it has one parameter name "menu" of type
string
1.2 This method should click on the menu whatever name is passed as parameter.
1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
select the Menu and click on it and verify the page navigation.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    public void selectMenu (String menu){ // selectMenu method with one parameter
        List<WebElement> topMenuname = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']")); // use arraylist to fatch Topmenu

        for (WebElement name: topMenuname){ //for each loop to iterate each element of list
            if(name.getText().equalsIgnoreCase(menu)){ // pass if condition with get text
                name.click(); // click
                break;
            }
        }
    }

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyComputersNavigation (){
        selectMenu("Computers"); // pass parameter of computer in selectmenu method
        verifyText("Computers", By.xpath("//ul[@class='top-menu notmobile']/li[1]"), "Computers");
    } // verify using verifytext method of Utility
    @Test
    public void verifyElectronicsNavigation (){
        selectMenu("Electronics");
        verifyText("Electronics", By.xpath("//ul[@class='top-menu notmobile']/li[2]"), "Electronics");
    }
    @Test
    public void verifyApparelNavigation (){
        selectMenu("Apparel");
        verifyText("Apparel", By.xpath("//ul[@class='top-menu notmobile']/li[3]")  , "Apparel");
    }
    @Test
    public void verifyDigitalDownloadsNavigation () {
        selectMenu("Digital downloads");
        verifyText("Digital downloads",By.xpath("//ul[@class='top-menu notmobile']/li[4]") , "Digital downloads");
    }
    @Test
    public void verifyBooksNavigations () {
        selectMenu("Books");
        verifyText("Books", By.xpath("//ul[@class='top-menu notmobile']/li[5]") , "Books");
    }
    @Test
    public void verifyJewelryNavigation () {
        selectMenu("Jewelry");
        verifyText("Jewelry", By.xpath("//ul[@class='top-menu notmobile']/li[6]") , "Jewelry");
    }
    @Test
    public void verifyGiftCardsNavigation (){
        selectMenu("Gift Cards");
        verifyText("Gift Cards", By.xpath("//ul[@class='top-menu notmobile']/li[7]") , "Gift Cards");
    }

    @After
    public void tearDown (){
      //  closeBrowser();
    }
}
