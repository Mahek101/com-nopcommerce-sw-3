package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    /**
     * This method will get text from element and check whether it is displayed or not.
     */
    public boolean isTextDisplayed(By by, String expectedText){
        boolean actualText = (driver.findElement(by).getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : "Text is not found" + expectedText;
        return true;
    }
    /**
     * This method will get number from element and check
     * whether it is displayed or not.
     */
    public boolean getNumberFromElement(By by,int expectedNumber){
        int actualNumber = driver.findElements(by).size();
        assert actualNumber == expectedNumber : "Expected Number is not found" + expectedNumber;
        return true;
    }
    /*
    This method will mouse hover over any element
     */
    public void mouseHoverToElement(By by1,By by2) {
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by1);
        WebElement text2 = driver.findElement(by2);
        actions.moveToElement(text1).moveToElement(text2).click().build().perform();
    }
    /*
    This method will get text from any popup alert
     */
    public String getTextFromAlert(By by) {
        return driver.switchTo().alert().getText();
    }
    /*
   This method will get text from element.
    */
    public String getTextFromElement(By by) {
        //find the element to get text from
        WebElement element = driver.findElement(by);
        //return the text from the element as String
        return element.getText();
    }
    /*
   This method will select dropdown option using text displayed
    */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
}
