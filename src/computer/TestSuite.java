package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;
import org.openqa.selenium.By;
import utilities.Utility;

import java.awt.*;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }
    @Test
    public void verifytheProductDescendingOrder (){
     //   mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]")); // using mousehover
     //   clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/ul[1]/li[1]/a"));
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='item-grid']/div[1]/div[1]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByValueFromDropdown(By.xpath("//div[@class='product-selectors']/div[2]/select"), "6");
        //1.4 Verify the Product will arrange in Descending order.
        verifyText("Name: Z to A", By.xpath("//div[@class='product-selectors']/div[2]/select/option[3]") , "Name: Z to A" );
//        String actualmes = getTextFromElement(By.xpath("//div[@class='product-selectors']/div[2]/select/option[3]"));
//        System.out.println(actualmes);
//        String expectedmes = "Name: Z to A";
//        Assert.assertEquals(expectedmes, actualmes);
    }
    @Test
    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    public void verifyProductAddedToShoppingCartSuccessfully () throws InterruptedException {
    //    2.1 Click on Computer Menu.
       clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]"));
    //    2.2 Click on Desktop
       clickOnElement(By.xpath("//div[@class='item-grid']/div[1]/div[1]"));
    //  2.3 Select Sort By position "Name: A to Z"
       selectByValueFromDropdown(By.xpath("//div[@class='product-selectors']/div[2]/select"), "5");
    // 2.4 Click on "Add To Cart"
       Thread.sleep(1000);
       clickOnElement(By.xpath("//div[@class='products-container']/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
   //     clickOnElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']"));
    //2.5 Verify the Text "Build your own computer"
        verifyText("Build your own computer",By.xpath("//div[@class='product-essential']/div[2]/div[1]/h1"),"Build your own computer");
    //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
       Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='product_attribute_1']"), "1");
    //2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='product_attribute_2']"), "5");
    //2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        //[+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //2.11 Verify the price "$1,475.00"
        Thread.sleep(1000);
        verifyText("$1,475.00", By.xpath("//span[@id='price-value-1']"), "$1,475.00" );
        //2.12 Click on "ADD TO CARD" Button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(1000);
        verifyText("The product has been added to your shopping cart", By.xpath("//div[@class='bar-notification success']"), "The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='bar-notification success']/span"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //2.15 Verify the message "Shopping cart"
        Thread.sleep(1000);
        verifyText("Shopping cart", By.xpath("//div[@class='page-title']"),"Shopping cart");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1000);
        clearTextFromField(By.xpath("//div[@class='table-wrapper']/table[1]/tbody[1]/tr/td[5]/input"));
        sendKeysToElement(By.xpath("//div[@class='table-wrapper']/table[1]/tbody[1]/tr/td[5]/input"), "2");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        //2.17 Verify the Total"$2,950.00"
        Thread.sleep(1000);
        verifyText("$2,950.00", By.xpath("//span[@class='product-subtotal']"), "$2,950.00");
        //2.18 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.19 Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        verifyText("Welcome, Please Sign In!", By.xpath("//div[@class='page-title']"), "Welcome, Please Sign In!");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        //2.22 Fill the all mandatory field
        Thread.sleep(1000);
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Lord");
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "uk");
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "lorduk@gmail.com");
        selectByValueFromDropdown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Buckingham Palace");
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "SW1A 1AA");
        sendKeysToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "1234567890");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button[1]"));
        //2.27 Select “Master card” From Select credit card dropdown
        Thread.sleep(2000);
        selectByValueFromDropdown(By.xpath("//select[@id='CreditCardType']"), "MasterCard");
        //2.28 Fill all the details
        Thread.sleep(1000);
        sendKeysToElement(By.xpath("//input[@id='CardholderName']"), "Lord uk");
        sendKeysToElement(By.xpath("//input[@id='CardNumber']"), "5425233430109903");
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireMonth']"), "4");
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@id='ExpireYear']"), "2023");
        sendKeysToElement(By.xpath("//input[@id='CardCode']"), "123");
        //2.29 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText("Credit Card", By.xpath("//div[@class='payment-method-info']/ul[1]/li[1]/span[2]"),"Credit Card");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText("Next Day Air", By.xpath("//div[@class='shipping-method-info']/ul[1]/li[1]/span[2]"), "Next Day Air");
        //2.33 Verify Total is “$2,950.00”
        Thread.sleep(1000);
        verifyText("$2,950.00",By.xpath("//div[@class='total-info']/table[1]/tbody[1]/tr[4]/td[2]/span[1]") , "$2,950.00");
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));
        //2.35 Verify the Text “Thank You”
        Thread.sleep(1000);
        verifyText("Thank you", By.xpath("//div[@class='page checkout-page order-completed-page']/div[1]/h1") , "Thank you");
        //2.36 Verify the message “Your order has been successfully processed!”
        verifyText("Your order has been successfully processed!",By.xpath("//div[@class='page-body checkout-data']/div[1]/div[1]") , "Your order has been successfully processed!");
        //2.37 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.37 Verify the text “Welcome to our store”
        verifyText("Welcome to our store",  By.xpath("//div[@class='topic-block']/div[1]/h2") , "Welcome to our store");

    }

    @After
    public void teardown (){
       // closeBrowser();
    }
}
