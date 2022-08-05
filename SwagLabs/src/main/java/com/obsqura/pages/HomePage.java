package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	

	WebDriver driver;
	@FindBy(xpath="//span[@class='title']")
	private WebElement heading;
	
	public HomePage(WebDriver driver)
	{	
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public String getPageTitle() 
		{
			return driver.getTitle();
						
			}
		public String getHeading() 
			{
				return heading.getText();
			}

}
