package com.obsqura.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {

	
	WebDriver driver;
	public static Properties prop = null;
	public static void loadConfig() {
        try {
        	//Below line creates an object of Properties called 'prop'
            prop = new Properties();
          //Below line creates an object of FileInputStream called 'ip'. 
          //Give the path of the properties file which you have created
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources"
                    + "/config.properties");
//Below line of code will load the property file
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) 
		{
		
		loadConfig();	
		String browser1=prop.getProperty("browser");
		if(browser1.equalsIgnoreCase("chrome")) { 
			System.setProperty("webdriver.chrome.driver","F:\\selenium-drivers\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
	
			
		}
		
		else if(browser1.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "F:\\selenium-drivers\\geckodriver-v0.31.0\\geckodriver.exe");
			    driver = new FirefoxDriver();
			}
			
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}
			@AfterMethod
	    public void tearDown(ITestResult iTestResult) throws IOException {
	        if (iTestResult.FAILURE == iTestResult.getStatus()) {
	            takeScreenshot(iTestResult.getName());
	        }
	    }
			public String takeScreenshot(String name) throws IOException {
		    	
		    	
		    	/*Step 1) Convert web driver object to TakesScreenshot
		          Step 2) Call getScreenshotAs method to create image file
		          Step 3) Copy file to Desired Location*/
		    	
		        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		      //Take the screenshot
		        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String destination =  System.getProperty("user.dir") + "\\target\\" + name + dateName
		                + ".png";
		       
		        File finalDestination = new File(destination);
		     
		        FileUtils.copyFile(source, finalDestination);//or FileUtils.copyFile import org.apache.commons.io.FileUtils;
		        return destination;   
		    }

	

}
