package com.BackBase.assignment.PageClasses;

import com.BackBase.assignment.WrapperClasses.BackBaseWrappers;

public class CreateNEWComputerPage extends BackBaseWrappers{
	
	
	public CreateNEWComputerPage verifyCreateNewPage(String createNEWpageHeader) throws Throwable{
		VerifyTextByXpath(prop.getProperty("ComputerDBCreateNEWPage.VerifyPageHeader.xpath"), createNEWpageHeader);
		return this;		
	}
	public CreateNEWComputerPage enterComputerName(String computerName) throws Throwable{
		enterById(prop.getProperty("ComputerDBCreateNEWPage.EnterComputerName.Id"), computerName);
		return this;		
	}
	public CreateNEWComputerPage enterIntroducedDate(String introducedDate) throws Throwable{
		enterById(prop.getProperty("ComputerDBCreateNEWPage.EnterIntroducedDate.Id"), introducedDate);
		return this;		
	}
	public CreateNEWComputerPage enterDiscontinuedDate(String discontinuedDate) throws Throwable{
		enterById(prop.getProperty("ComputerDBCreateNEWPage.EnterDiscontinuedDate.Id"), discontinuedDate);
		return this;		
	}
	public CreateNEWComputerPage selectCompanyName(String optionValue) throws Throwable{
		selectByOption(prop.getProperty("ComputerDBCreateNEWPage.ClickDropDown.xpath"), prop.getProperty("ComputerDBCreateNEWPage.SelectCompanyOption.xpath").replace("value", optionValue), optionValue);
		return this;		
	}
	
	public ComputerDBHomePage clickCreateNewCoputerBtn(String createNewButton) throws Throwable{
		actionClickByXpath(prop.getProperty("ComputerDBCreateNEWPage.ClickCreateNEWComputerBtn.xpath"), createNewButton);
		return new ComputerDBHomePage();		
	}

}
