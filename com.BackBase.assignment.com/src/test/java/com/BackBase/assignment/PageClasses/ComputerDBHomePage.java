package com.BackBase.assignment.PageClasses;

import org.openqa.selenium.WebElement;

import com.BackBase.assignment.Utils.Reporter;
import com.BackBase.assignment.WrapperClasses.BackBaseWrappers;

public class ComputerDBHomePage extends BackBaseWrappers{
	
	
	public ComputerDBHomePage verifytitlePage(String pageTitle) throws Throwable {
		VerifyTitle(pageTitle);
		return this;
	}
	public CreateNEWComputerPage ClickCreateNEWcomputerBtn(String aDdNEWbtn) throws Throwable {
		clickButtonById(prop.getProperty("ComputerDBHomePage.clickAddNEWComputerBtn.Id"), aDdNEWbtn);
		return new CreateNEWComputerPage();
	}
	public ComputerDBHomePage verifySuccessMsg(String successMassage) throws Throwable{
		VerifyTextByXpath(prop.getProperty("ComputerDBCreateNEWPage.VerifySuccessMassage.xpath"), successMassage);
		return this;		
	}
	public ComputerDBHomePage enterComputerName(String computerName) throws Throwable{
		enterById(prop.getProperty("ComputerDBHomePage.EnterComputerName.Id"), computerName);
		return this;		
	}
	public ComputerDBHomePage clickFilterByComp(String clkFilterByName) throws Throwable{
		actionClickByXpath(prop.getProperty("ComputerDBHomePage.ClickFilterByNameBtn.xpath"), clkFilterByName);
		return this;		
	}
	public ComputerDBHomePage verifyRequiredErrorMsg(String requiredMassage) throws Throwable{
		VerifyTextByXpath(prop.getProperty("ComputerDBEmptyField.VerifyRequiredError.xpath"), requiredMassage);
		return this;		
	}
	public ComputerDBHomePage verifyDateFormatErrorMsg(String requiredMassage) throws Throwable{
		VerifyTextByXpath(prop.getProperty("ComputerDBInvalidDate.VerifyDateFormatError.xpath"), requiredMassage);
		return this;		
	}
	public ComputerDBHomePage verifyEditComputerPage(String editPageHeader) throws Throwable{
		WebElement element = driver.findElementByXPath(prop.getProperty("ComputerDBEditComputer.VerifyWarningMsg.xpath"));
		String str = element.getText();
		
		if(element.isDisplayed()){
			Reporter.reportStep("Search for a Computer:   "+ str +" ", "PASS");
			driver.quit();
		}else{		
		VerifyTextByXpath(prop.getProperty("ComputerDBEditComputer.VerifyEditComputerPage.xpath"), editPageHeader);
		}
		return this;		
	}
	public EditComputerPage clickComputerName(String clkComputerName) throws Throwable{
		actionClickByXpath(prop.getProperty("ComputerDBHomePage.ClickComputerLink.xpath"), clkComputerName);
		return new EditComputerPage();		
	}	
}
