package computer;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TestSuite extends TopMenuTest {

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder()throws InterruptedException{
        selectMenu("Computers");// Click on computer menu
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));// Click on Desktops
        //selectAnOption(By.id("products-orderby"),"Name: Z to A\"");
        WebElement dropdown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name: Z to A");
        // verify the products are arranged in descending order
        List<WebElement> productNames = driver.findElements(By.cssSelector("div.product-item div.details h2.product-title a"));
        List<String> productNameStrings = new ArrayList();

        for (WebElement productName : productNames) {
            productNameStrings.add(productName.getText());
        }
        List<String> sortedProductNames = new ArrayList(productNameStrings);
        Assert.assertEquals("Product is not displayed in descending order",productNameStrings, sortedProductNames);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully()throws InterruptedException{
        selectMenu("Computers");// Click on computer menu
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));// Click on Desktops
        WebElement dropdown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name: A to Z");
        // This code is not working in my system but it is working in my team member's system.
        //driver.findElement(RelativeLocator.with(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]")).below(By.xpath("//span[normalize-space()='$1,200.00']"))).click();
        isTextDisplayed(By.linkText("Build your own computer"),"Build your own computer");
        clickOnElement(By.id("product_attribute_1"));

        WebElement dropdown2 = driver.findElement(By.id("product_attribute_1"));
        Select select1 = new Select(dropdown2);
        select1.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        WebElement dropdown3 = driver.findElement(By.id("product_attribute_2"));
        Select select2 = new Select(dropdown3);
        select2.selectByVisibleText("8GB [+$60.00]");
        clickOnElement(By.id("product_attribute_3_7"));
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.id("product_attribute_5_12"));
        isTextDisplayed(By.xpath("//span[@id='price-value-1']"),"$1,475.00");
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        isTextDisplayed(By.xpath("//p[@class='content']"),"The product has been added to your shopping cart");
        clickOnElement(By.xpath("//span[@title='Close']"));
        //MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class='cart-label']"));
        WebElement goToCart = driver.findElement(By.xpath("//button[normalize-space()='Go to cart']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
        //Verify the message "Shopping cart"
        isTextDisplayed(By.xpath("//h1[normalize-space()='Shopping cart']"),"Shopping cart");
        //Change the Qty to "2" and Click on "Update shopping cart"
        Actions actions1 = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//input[@id='itemquantity11241"));
        actions1.doubleClick(element).sendKeys("2").build().perform();
        clickOnElement(By.id("updatecart"));
        //Verify the Total"$2,950.00"
        isTextDisplayed(By.xpath("//span[@class='product-subtotal']"),"$2,950.00");
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        // Verify the Text “Welcome, Please Sign In!”
        isTextDisplayed(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"),"Welcome, Please Sign In!");
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        //Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"),"Sneha");// Enter First name
        sendTextToElement(By.id("BillingNewAddress_LastName"),"Shah");// Enter Last name
        sendTextToElement(By.id("BillingNewAddress_Email"),"sneha123@gmail.com");// Enter Email address
        WebElement dropDown3 = driver.findElement(By.id("//select[@id='BillingNewAddress_CountryId']"));//Select Country
        Select select3 = new Select(dropDown3);
        select.selectByVisibleText("United States");// Select by visible text
        sendTextToElement(By.id("BillingNewAddress_City"),"New york");//Enter City
        sendTextToElement(By.id("BillingNewAddress_Address1"),"12 Garden Park");// Enter Address line 1
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"ab1 2cd"); // Enter Postal Code
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"0123456789");// Enter phone number
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //Click on Radio Button “Next Day Air($0.00)
        clickOnElement(By.id("shippingoption_1"));
        //Click on “CONTINUE”
        clickOnElement(By.cssSelector(".button-1.shipping-method-next-step-button"));
        //Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        //Click on continue
        clickOnElement(By.cssSelector(".button-1.payment-method-next-step-button"));
        //Select “Master card” From Select credit card dropdown
        WebElement dropDown4 = driver.findElement(By.id("CreditCardType"));
        Select select4 = new Select(dropDown4);
        select4.selectByVisibleText("Master card");
        //Fill all the details
        sendTextToElement(By.id("CardholderName"),"Sneha Shah");//Enter Cardholder Name
        sendTextToElement(By.id("CardNumber"),"123456789");// Enter Card Number
        WebElement dropDown5 = driver.findElement(By.id("ExpireMonth"));
        Select select5 = new Select(dropDown5);
        select5.selectByVisibleText("03");// Select Expiry month
        WebElement dropDown6 = driver.findElement(By.id("ExpireYear"));
        Select select6 = new Select(dropDown6);
        select5.selectByVisibleText("2024");// Select Expiry year
        sendTextToElement(By.id("CardCode"),"1234");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//li[@class='payment-method']/span[@class='value']"));
        Thread.sleep(1000);
        Assert.assertEquals("not credit card", expectedPaymentMethod, actualPaymentMethod);
        //Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        Thread.sleep(1000);
        Assert.assertEquals("not next day air", expectedShippingMethod, actualShippingMethod);
        //Verify Total is “$2,950.00”
        String expectedTotalAmount = "$2,950.00";
        String actualTotalAmount = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("Total amount does not match.", expectedTotalAmount, actualTotalAmount);
        //Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //define expected
        String expectedThankYou = "Thank you";
        //get actual
        Thread.sleep(1000);
        String actualThankYou = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        //Verify the Text “Thank You”
        Thread.sleep(1000);
        Assert.assertEquals("Thank you not displayed", expectedThankYou, actualThankYou);
        //define expected
        String expectedSuccessfullyProcessed = "Your order has been successfully processed!";
        //get actual
        String actualSuccessfullyProcessed = getTextFromElement(By.xpath("//div[@class='section order-completed']/div[@class='title']/strong"));
        //Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Not processed", expectedSuccessfullyProcessed, actualSuccessfullyProcessed);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //Verify the text “Welcome to our store”
        //define expected
        String expectedWelcomeMessage = "Welcome to our store";
        //get actual
        String actualWelcomeMessage = getTextFromElement(By.xpath("//div[@class='topic-block-title']/h2"));
        //Verify the message “Your order has been successfully processed!”
        Thread.sleep(1000);
        Assert.assertEquals("Not successfully processed", expectedWelcomeMessage, actualWelcomeMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
