package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    /**
     * This method will find and click on the menu whatever name is passed as parameter.
     */

    public void selectMenu(String menu){
        driver.findElement(By.linkText(menu)).click();
    }
    @Before
    public void setUp(){
        openBrowser("https://demo.nopcommerce.com/");
    }
    @Test
    public void verifyPageNavigation(){
        selectMenu("Computers");//Find and click on Computers
        // Verify is user navigate to Computers page or not?
        Assert.assertEquals("User is not navigate to page","https://demo.nopcommerce.com/computers",driver.getCurrentUrl());
        // Verify is user navigate to Electronics page or not?
        selectMenu("Electronics");// Find and click on Electronics
        Assert.assertEquals("User is not navigate to page","https://demo.nopcommerce.com/electronics",driver.getCurrentUrl());
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
