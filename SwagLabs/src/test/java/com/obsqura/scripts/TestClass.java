package com.obsqura.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utilities.ExcelUtility;

import dataProvider.data;

public class TestClass extends TestBase {
	
	
	LoginPage log;
	HomePage hom;
	
	@Test(priority=3
			)
	public void verifyLogin() throws IOException	
		
		{
				log=new LoginPage(driver);
				driver.navigate().refresh();
				String username = ExcelUtility.getCellData(0, 0);
			    String password = ExcelUtility.getCellData(0, 1);
			    log.setUserName("standard_user");
				log.setPassword("secret_sauce");
				log.clickLogin();
				hom=new HomePage(driver);
			//String ExpectedTitle="Swag Labs";
			String expectedTitle =Constants.HOMEPAGETITLE;
			String actualTile=hom.getPageTitle();  //object.method name
			//String actualTitle=driver.getTitle();  -->used if String getPageTitle() is not given in Homepage
			Assert.assertEquals(expectedTitle, actualTile);
			String expectedHeading=Constants.HOMEPAGEHeading;			
			String actualHeading=hom.getHeading();
			Assert.assertEquals(expectedHeading, actualHeading);	
			
		}
	@Test(priority=2)
	public void InvalidLogin1() throws IOException 
		{
			log=new LoginPage(driver);
			driver.navigate().refresh();
			String username = ExcelUtility.getCellData(1, 0);
		    String password = ExcelUtility.getCellData(1, 1);
			log.setUserName("standard_user");
			log.setPassword("secret");
			log.clickLogin();
			log.clearUsername();
			log.clearPassword();
			String expectedErrorMessage="Epic sadface: Username and password do not match any user in this service";
			String actualErrorMessage=log.errorMessage1();
			Assert.assertEquals(expectedErrorMessage,actualErrorMessage);				
			
		}
	@Test(priority=1)
	
	public void InvalidLogin2() throws IOException 
		{
			log=new LoginPage(driver);
			driver.navigate().refresh();
			String username = ExcelUtility.getCellData(2, 0);
		    log.setUserName(username);
			log.clickLogin();
			log.clearUsername();
			String expectedErrorMessage="Epic sadface: Password is required1";
			String actualErrorMessage=log.errorMessage2();
			Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
			
		}
	
	@Test(dataProvider="pass")
	//@Test(priority=1)
	
	public void InvalidLogin3() throws IOException 
		{
					log=new LoginPage(driver);
					driver.navigate().refresh();
					//String password = ExcelUtility.getCellData(3, 1);
				   // log.setPassword(password);
					log.test(password);
					log.clickLogin();
					log.clearPassword();
					String expectedErrorMessage="Epic sadface: Username is required";
					String actualErrorMessage=log.errorMessage3();
					Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
					
			
		}
	


	

}

