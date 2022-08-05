package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class LoginPage {
	
	
	WebDriver driver;
	@FindBy(id="user-name")
    private WebElement username;
	@FindBy(id="password")
	private WebElement passWrd;
	@FindBy(id="login-button")
    private WebElement Login;
	@FindBy(tagName="h3")
	private WebElement errorMessage1;
	@FindBy(tagName="h3")
	private WebElement errorMessage2;
	@FindBy(tagName="h3")
	private WebElement errorMessage3;
	
	public LoginPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	/*Set user name in textbox*/
    public void setUserName(String strUserName){
    	username.clear();
    	username.sendKeys(strUserName);     
    }
    
    @DataProvider(password="pass")	
	public Object[][] dataproviderMethod()  
		{
			Object[][] data1=new Object[4][1];
			data1[3][1]= "secret_sauce";
			return data1;
						
		}
    public void test(String password) 
	{
		System.out.println( password);
	}


    /*Set password in password textbox*/
    public void setPassword(String strPassword){
    	passWrd.clear();
    	passWrd.sendKeys(strPassword);
    }
    
    public void clearPassword() 
    {	
    	passWrd.clear();
    }
    
    public void clearUsername() 
    {	
    	username.clear();
    }    
    //Click on login button
    public void clickLogin(){
    	Login.click();
    }
    
    public String errorMessage1() 
    	{
    	
			return errorMessage1.getText();
    	}
    public String errorMessage2() 
	{
		
		return errorMessage2.getText();
	}
    
    public String errorMessage3() 
   	{
   		
		return errorMessage3.getText();
   	}
	

}
