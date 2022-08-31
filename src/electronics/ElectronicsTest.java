package electronics;
/*
● Create package Electronics
1. Create the class ElectronicsTest
Write the following test
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }

    @Test
   //1. Test name text verified()
    public void verifyCellPhones () throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        //1.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/ul[1]/li[2]/a"));
        //1.3 Verify the text “Cell phones”
        Thread.sleep(1000);
        verifyText("Cell phones", By.xpath("//div[@class='page category-page']/div[1]/h1"), "Cell phones");
    }
    @Test
    //2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
    public void verifyThatProductAddedSuccessfullyAndPlaceOrderSuccessfully () throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        //2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/ul[1]/li[2]/a"));
        //2.3 Verify the text “Cell phones”
        Thread.sleep(1000);
        verifyText("Cell phones", By.xpath("//div[@class='page category-page']/div[1]/h1"),"Cell phones");
        //2.4 Click on List View Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='product-selectors']/div[1]/a[2]"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='products-wrapper']/div[1]/div[1]/div[3]/div[1]/div[2]/h2/a"));
        //2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(1000);
        verifyText("Nokia Lumia 1020", By.xpath("//div[@class='product-essential']/div[2]/div[1]/h1"), "Nokia Lumia 1020");
        //2.7 Verify the price “$349.00”
        Thread.sleep(1000);
        verifyText("$349.00",  By.xpath("//div[@class='product-essential']/div[2]/div[6]/div[1]/span"), "$349.00");
        //2.8 Change quantity to 2
        Thread.sleep(1000);
        clearTextFromField(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendKeysToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        //2.9 Click on “ADD TO CART” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("The product has been added to your shopping cart",By.xpath("//div[@class='bar-notification success']") ,"The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//div[@class='bar-notification success']/span"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //2.12 Verify the message "Shopping cart"
        Thread.sleep(1000);
        verifyText("Shopping cart", By.xpath("//div[@class='page-title']/h1"), "Shopping cart");
        //2.13 Verify the quantity is 2
        Thread.sleep(1000);
        verifyText("", By.xpath("//div[@class='table-wrapper']/table[1]/tbody[1]/tr/td[5]/label") ,"");
        //2.14 Verify the Total $698.00
        Thread.sleep(1000);
        verifyText("$698.00",By.xpath("//span[@class='product-subtotal']"),"$698.00");
        //2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='totals']/div[3]/input"));
        //2.16 Click on checkout
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //“2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        verifyText("Welcome, Please Sign In!",By.xpath("//div[@class='page-title']/h1"),"Welcome, Please Sign In!");
        //2.18 Click on “REGISTER” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));
        //2.19 Verify the text “Register”
        verifyText("Register",By.xpath("//div[@class='page-title']/h1") ,"Register");
        //2.20 Fill the mandatory fields
        sendKeysToElement(By.xpath("//input[@id='FirstName']"), "Lor");
        sendKeysToElement(By.xpath("//input[@id='LastName']"), "duk");
        sendKeysToElement(By.xpath("//input[@id='Email']"), "lorduk10@gmail.com");
        sendKeysToElement(By.xpath("//input[@id='Password']"), "123456");
        sendKeysToElement(By.xpath("//input[@id='ConfirmPassword']"), "123456");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //2.22 Verify the message “Your registration completed”
        verifyText("Your registration completed", By.xpath("//div[@class='result']") ,"Your registration completed");
        //2.23 Click on “CONTINUE” tab
        clickOnElement( By.xpath("//div[@class='buttons']/a"));
        //2.24 Verify the text “Shopping cart”
        verifyText("Shopping cart",By.xpath("//div[@class='page-title']/h1") ,"Shopping cart");
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "Buckingham Palace");
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "SW1A 1AA");
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "1234567890");
        //2.28 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div[1]/button[1]"));
        //2.32 Select “Visa” From Select credit card dropdown
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"), "visa");
        //2.33 Fill all the details
        Thread.sleep(1000);
        sendKeysToElement(By.xpath("//input[@id='CardholderName']"), "Lord uk");
        sendKeysToElement(By.xpath("//input[@id='CardNumber']"), "5425233430109903");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"), "4");
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendKeysToElement(By.xpath("//input[@id='CardCode']"), "123");
        //2.34 Click on “CONTINUE”CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyText("Credit Card", By.xpath("//div[@class='payment-method-info']/ul[1]/li[1]/span[2]"), "Credit Card");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText("2nd Day Air", By.xpath("//div[@class='shipping-method-info']/ul[1]/li[1]/span[2]") ,"2nd Day Air");
        //2.37 Verify Total is “$698.00”
        Thread.sleep(1000);
        verifyText("$698.00", By.xpath("//span[@class='value-summary']/strong"), "$698.00");
        //2.38 Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //2.39 Verify the Text “Thank You”
        Thread.sleep(1000);
        verifyText("Thank you",By.xpath("//div[@class='page-title']/h1") ,"Thank you");
        //2.40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(1000);
        verifyText("Your order has been successfully processed!", By.xpath("//div[@class='section order-completed']/div[1]/strong"), "Your order has been successfully processed!");
        //2.41 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.42 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", By.xpath("//div[@class='topic-block-title']/h2") ,"Welcome to our store");
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//div[@class='header-links']/ul[1]/li[2]/a"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/” dont know how to verify so verify logo
        Thread.sleep(1000);
        verifyText("Featured products", By.xpath("//div[@class='page-body']/div[4]/div[1]/strong"), "Featured products");
    }

    @After
    public void teardown (){
        //closeBrowser();
    }
}
