package com.BackBase.assignment.WrapperClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;
import com.BackBase.assignment.Utils.Reporter;

public class GenericWrappers implements WrappersInterface{
	
	Logger log = Logger.getLogger("GenericWrappers.class");
	protected static RemoteWebDriver driver;
	public NgWebDriver ngdriver;
	protected static Properties prop;
	public String sUrl;
	protected static String browserName;
	
	public void invokeApp(String browser){
		try {
			if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
					driver = new ChromeDriver();
				}else if(browser.equalsIgnoreCase("firefox")){
					System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
					driver = new FirefoxDriver();
				}else if(browser.equalsIgnoreCase("internet explorer")){
					System.setProperty("webdriver.ie.driver", "./lib/IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://computer-database.herokuapp.com/computers");
			driver.getWindowHandle();

			try {
				Reporter.reportStep("The Browser  "+ browser +" launched Successfully.", "PASS");
			} catch (Exception e) {
				e.printStackTrace();
				log.error("Logger Error "+ e);


				Reporter.reportStep("The Browser  "+ browser +" could not be launched Successfully.", "FAIL");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			log.error("Logger Error "+ e);
		} catch (Throwable e) {
			e.printStackTrace();
			log.error("Logger Error "+ e);
		}
	}
	public void unloadObjects() {		
		prop = null;		
	}
	public void loadObjects() {
		prop =new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/test/resources/object.properties")));
		} catch (FileNotFoundException e) {
				e.printStackTrace();
				log.error("Logger Error "+ e);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Logger Error "+ e);
		}
	}
	public void loadTestdata() {
		prop =new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/test/resources/testdata.properties")));
		} catch (FileNotFoundException e) {
				e.printStackTrace();
				log.error("Logger Error "+ e);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Logger Error "+ e);
		}
	}
	public boolean enterById(String idValue,String data) throws Throwable{
		boolean bReturn = true;
		try{
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);
			log.info("The Value " + data + " entered Successfully");
			Reporter.reportStep("The data "+ data +" is successfully entered.", "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("The data "+ data +" couldn't be entered successfully.", "FAIL");
			log.error("Logger Error "+ e);
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
			log.error("Logger Error "+ e);
		}
		return bReturn;
	}
	public boolean enterByName(String nameValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);
			Reporter.reportStep("The data "+ data +" is entered successfully.", "PASS");
			log.info("The Value " + data + " is entered Successfully");
			bReturn = true;
		}  catch (NoSuchElementException e){
			Reporter.reportStep("The data "+ data +" couldn't be entered successfully.", "FAIL");
			log.error("Logger Error "+ e);
		}  catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not entered successfully.", "FAIL");
			log.error("Logger Error "+ e);
		}
		return bReturn;
	}
	public boolean VerifyTitle(String title) throws Throwable {
		boolean bReturn=false;
		if(driver.getTitle().trim().equalsIgnoreCase(title)){
			try {
				Reporter.reportStep("The title of the page "+ title+" is matching successfully.", "PASS");
				bReturn=true;

			} catch (Exception e) {
				Reporter.reportStep("The title of the page "+ title+" is not matching successfully.", "FAIL");
				log.info("The title " + title + "is not matching Successfully");
				log.error("Logger Error "+ e);
				bReturn=false;
			}
		}
		return bReturn;
	}
	public boolean VerifyWindowTitleById(String idValue, String WinTitle) throws Throwable {
		boolean bReturn=false;
		try{
		if(driver.findElement(By.id(idValue)).getText().equalsIgnoreCase(WinTitle)){
				Reporter.reportStep("The title of the Window "+ WinTitle+" is displayed successfully.", "PASS");
				log.info("The Value " + WinTitle + " Verified Successfully");
				bReturn=true;
			}
			} catch (NoSuchElementException e){
				Reporter.reportStep("The title of the Window "+ WinTitle+" is not available to check.", "FAIL");
				log.info("The Value " + WinTitle + " is not available to Check");
				log.error("Logger Error "+ e);
			}	catch (Exception e) {
				Reporter.reportStep("The title of the Window "+ WinTitle+" is not displayed successfully.", "FAIL");
				log.info("The Value " + WinTitle + " is not displayed Successfully");
				log.error("Logger Error "+ e);
			}
		return bReturn;
	}
	public boolean VerifyWindowTitleByXpath(String xpathValue, String WinTitle) throws Throwable {
		boolean bReturn=false;
		try{
		if(driver.findElement(By.xpath(xpathValue)).getText().equalsIgnoreCase(WinTitle)){
				Reporter.reportStep("The title of the Window "+ WinTitle+" is displayed successfully.", "PASS");
				bReturn=true;
			}
			} catch (NoSuchElementException e){
				Reporter.reportStep("The title of the Window "+ WinTitle+" is not available to check.", "FAIL");
				log.error("Logger Error "+ e);
			}	catch (Exception e) {
				Reporter.reportStep("The title of the Window "+ WinTitle+" is not displayed successfully.", "FAIL");
				log.error("Logger Error "+ e);
			}
		return bReturn;
	}
	public boolean VerifyTextById(String idValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			if(driver.findElement(By.id(idValue)).getText().equalsIgnoreCase(data)){
				Reporter.reportStep("The data "+ data +" is Read successfully.", "PASS");
				log.info("The data "+ data +" is Read successfully.");
				bReturn = true;
			}
		}  catch (NoSuchElementException e){
			Reporter.reportStep("The data "+ data +" is not available to verify.", "FAIL");
			log.error("Logger Error "+ e);
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not Read successfully.", "FAIL");
			log.error("Logger Error "+ e);
		}	
		return bReturn;
	}
	public boolean VerifyTextByXpath(String xpathValue,String data) throws Throwable{
		boolean bReturn = false;
		try {
			if(driver.findElement(By.xpath(xpathValue)).getText().trim().equalsIgnoreCase(data)){
				Reporter.reportStep("The data "+ data +" is Read successfully.", "PASS");
				log.info("The data "+ data +" is Read successfully.");
				bReturn = true;
			}
			else Reporter.reportStep("The data "+ data +" which is not matching correctly.", "FAIL");
			
		} catch (Exception e) {
			Reporter.reportStep("The data "+ data +" is not Read Successfully.", "FAIL");
			log.error("Logger Error "+ e);
		}	
		return bReturn;
	}
	public boolean clickById(String idValue) throws Throwable{
		boolean bReturn = false;
		try {
			Reporter.reportStep("The Button is clicked successfully", "PASS");
			driver.findElement(By.id(idValue)).click();
			
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The Button is not clicked successfully", "FAIL");
		}	
		return bReturn;
	}
	public boolean clickButtonById(String idValue, String data) throws Throwable{
		boolean bReturn = false;
		try {
			driver.findElement(By.id(idValue)).click();
			Reporter.reportStep("The Button "+ data +" is clicked successfully", "PASS");
			log.info("The Button "+ data +" is clicked successfully");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The Button "+ data +" is not clicked successfully", "FAIL");
		}	
		return bReturn;
	}
	public boolean clickButtonByXpath(String xpathValue, String data) throws Throwable{
		boolean bReturn = false;
		try {
			driver.findElement(By.id(xpathValue)).click();
			Reporter.reportStep("The Button "+ data +" is clicked successfully", "PASS");
			log.info("The data "+ data +" is Clicked successfully.");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The Button "+ data +" is not clicked successfully", "FAIL");
		}	
		return bReturn;
	}
	public boolean openbrowser(String URL) throws Throwable {
		boolean bReturn = true;
		try {
			driver.get(URL);
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep(URL+" : not launched successfully", "FAIL");
			log.error("Logger Error: "+ e);
		}
		return bReturn;
	}
	public void quitBrowser() throws Throwable{
		try {
			driver.quit();
		} catch (Throwable e) {
			Reporter.reportStep("The Browser" + driver.getCapabilities().getBrowserName()+ "could not be closed", "FAIL");
			e.printStackTrace();
			log.error("Logger Error: "+ e);
		}
	}
	public boolean selectByOption(String dropXpath, String optionXpath, String optionValue) throws Throwable{
		boolean bReturn = false;
		try {
			driver.findElement(By.xpath(dropXpath)).click();
			Reporter.reportStep("The Button "+ dropXpath +" is clicked successfully", "PASS");
			log.info("The data "+ dropXpath +" is Clicked successfully.");
			driver.findElement(By.xpath(optionXpath)).click();
			Reporter.reportStep("The Button "+ optionValue +" is clicked successfully", "PASS");
			log.info("The data "+ optionValue +" is Clicked successfully.");
			bReturn = true;
		} catch (Exception e) {
			Reporter.reportStep("The Button "+ dropXpath +" is not clicked successfully", "FAIL");
			Reporter.reportStep("The Button "+ optionValue +" is not clicked successfully", "FAIL");
		}	
		return bReturn;
	}
	public boolean actionClickByXpath(String xpathValue, String dataValue) throws Throwable{
		boolean bReturn = true;
		try{
			WebElement element = driver.findElementByXPath(xpathValue);
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
			log.info("The Value " + dataValue + " Clicked Successfully");
			Reporter.reportStep("The data "+ dataValue +" is successfully Clicked.", "PASS");
			bReturn = true;
		} catch (NoSuchElementException e) {
			Reporter.reportStep("The data "+ dataValue +" couldn't be Clicked successfully.", "FAIL");
			log.error("Logger Error "+ e);
		} catch (Exception e) {
			Reporter.reportStep("The data "+ dataValue +" is not Clicked successfully.", "FAIL");
			log.error("Logger Error "+ e);
		}
		return bReturn;
	}
}


