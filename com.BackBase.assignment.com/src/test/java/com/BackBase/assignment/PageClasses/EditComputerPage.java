package com.BackBase.assignment.PageClasses;

import com.BackBase.assignment.WrapperClasses.BackBaseWrappers;

public class EditComputerPage extends BackBaseWrappers{
	
	
	public EditComputerPage verifyEditComputerPage(String editPageHeader) throws Throwable{		
		VerifyTextByXpath(prop.getProperty("ComputerDBEditComputer.VerifyEditComputerPage.xpath"), editPageHeader);
		return this;		
	}
	public EditComputerPage editIntroductionDate(String editintroducedDate) throws Throwable{
		enterById(prop.getProperty("ComputerDBCreateNEWPage.EnterIntroducedDate.Id"), editintroducedDate);
		return this;		
	}
	public ComputerDBHomePage clickSaveComputerBtn(String clickSaveButton) throws Throwable{
		actionClickByXpath(prop.getProperty("ComputerDBEditComputer.ClickSavethisComputerBtn.xpath"), clickSaveButton);
		return new ComputerDBHomePage();		
	}
	public ComputerDBHomePage clickDeleteComputerBtn(String clickDeleteButton) throws Throwable{
		actionClickByXpath(prop.getProperty("ComputerDBEditComputer.ClickDeletethisComputerBtn.xpath"), clickDeleteButton);
		return new ComputerDBHomePage();		
	}

}
