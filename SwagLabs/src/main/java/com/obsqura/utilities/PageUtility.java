package com.obsqura.utilities;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {
	
	public WebElement waitForElementTobeVisible(WebDriver driver, WebElement elementToBeLoaded, Duration Time) {
        WebDriverWait wait = new WebDriverWait(driver, Time);//new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
        return element;
    }
	public WebElement waitForElementTobeClickable(WebDriver driver, WebElement elementToBeClickable, Duration Time) {
        WebDriverWait wait = new WebDriverWait(driver, Time);//new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementToBeClickable));
        return element;
    }
	
	public void doubleClick(WebDriver driver, WebElement element) {
        //Retrieve WebElemnt  to perform mouse hover
    	Actions actions = new Actions(driver);
    	actions.doubleClick(element);
    	actions.build().perform();
    }
	public void contxtClick(WebDriver driver, WebElement element) {
        //Retrieve WebElemnt  to perform mouse hover
    	Actions actions = new Actions(driver);
    	actions.contextClick(element);
    	actions.build().perform();
    }


}
