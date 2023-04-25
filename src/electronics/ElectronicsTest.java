package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    @Before
    public void setUp(){
        openBrowser("https://demo.nopcommerce.com/");
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully()throws InterruptedException{
        //Mouse Hover on “Electronics” Tab, Mouse Hover on “Cell phones” and click
        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        WebElement cellPhones = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellPhones).click().build().perform();
        //Verify the text “Cell phones”
        isTextDisplayed(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
    }
    @Test
    public void  verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()throws InterruptedException{

        //Mouse Hover on “Electronics” Tab
        // Mouse Hover on “Cell phones” and click
        WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        WebElement cellPhones = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).moveToElement(cellPhones).click().build().perform();
        //Verify the text “Cell phones”
        isTextDisplayed(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
        //Click on List View Tab
        clickOnElement(By.xpath("//a[@title='List']"));
        //Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        //Verify the text “Nokia Lumia 1020”
        isTextDisplayed(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"),"Nokia Lumia 1020");
        //Verify the price “$349.00"
        isTextDisplayed(By.id("price-value-20"),"$349.00");
        //Change quantity to 2
        Actions actions1 = new Actions(driver);
        WebElement element = driver.findElement(By.id("product_enteredQuantity_20"));
        actions1.doubleClick(element).sendKeys("2").build().perform();
        //Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        isTextDisplayed(By.xpath("//p[@class='content']"),"The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button
        clickOnElement(By.xpath("//span[@title='Close']"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"),By.xpath("//button[normalize-space()='Go to cart']"));
        //Verify the message "Shopping cart"
        isTextDisplayed(By.xpath("//h1[normalize-space()='Shopping cart']"),"Shopping cart");
        //Verify the quantity is 2
        isTextDisplayed(By.id("itemquantity11278"),"2");
        //Verify the Total $698.00
        isTextDisplayed(By.xpath("//span[@class='product-subtotal']"),"$698.00");
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //Verify the Text “Welcome, Please Sign In!”
        isTextDisplayed(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"),"Welcome, Please Sign In!");
        //Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        //Verify the text “Register”
        isTextDisplayed(By.xpath("//h1[normalize-space()='Register']"),"Register");
        //Fill the mandatory fields
        sendTextToElement(By.id("FirstName"),"Sneha");// Enter First name
        sendTextToElement(By.id("LastName"),"Shah");// Enter Last name
        sendTextToElement(By.id("Email"),"Shah123@gmail.com");// Enter Email
        sendTextToElement(By.id("Password"),"123456");// Enter Password
        sendTextToElement(By.id("ConfirmPassword"),"123456");// Enter Confirm Password
        // Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
        //Verify the message “Your registration completed”
        isTextDisplayed(By.xpath("//div[@class='result']"),"Your registration completed");
        //Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        //Verify the text “Shopping card”
        isTextDisplayed(By.xpath("//h1[normalize-space()='Shopping cart']"),"Shopping cart");
        //2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        Thread.sleep(1000);
        //clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Texas");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Houston");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "1234 Raleigh St.");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "75821");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "39578924");
        //2.28 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        //continue
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Sneha Shah");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1234567855554444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "03");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //define expected
        String expectedCard = "Credit Card";
        //get actual text
        String actualCard = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        //2.35 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("Not credit card", expectedCard, actualCard);
        //define expected
        String expectedShippingMethod = "2nd Day Air";
        //get actual
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals("not 2nd day air", expectedShippingMethod, actualShippingMethod);
        //define expected
        String expectedTotalPrice = "$698.00";
        //get actual
        String actualTotalPrice = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        //2.37 Verify Total is “$698.00”
        Assert.assertEquals("Price not $698.00", expectedTotalPrice, actualTotalPrice);
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”
        String expectedMessage14 = "Thank you";
        //Actual Message
        String actualMessage14 = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage14,actualMessage14);
        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMessage15 = "Your order has been successfully processed!";
        //Actual Message
        String actualMessage15 = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage15,actualMessage15);
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.42 Verify the text “Welcome to our store”
        String expectedMessage16 = "Welcome to our store";
        //Actual Message
        String actualMessage16 = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage16,actualMessage16);
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedMessage17 = "https://demo.nopcommerce.com/";
        //Actual Message
        String actualMessage17 = driver.getCurrentUrl();
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage17,actualMessage17);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
