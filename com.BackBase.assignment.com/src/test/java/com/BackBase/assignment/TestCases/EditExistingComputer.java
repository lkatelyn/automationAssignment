package com.BackBase.assignment.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.BackBase.assignment.PageClasses.ComputerDBHomePage;
import com.BackBase.assignment.WrapperClasses.BackBaseWrappers;

public class EditExistingComputer extends BackBaseWrappers{
	
	
	@Parameters({"browsers"})
	@BeforeClass
	public void startTestCase() {
		dataSheetName="EditComputerTestData";
		testCaseName="Edit / Update Existing Computer Details";
		testDescription= "This Test Case is to Update Existing Computer Details";
	}	
	@Test(dataProvider="fetchdata")
	public void EditExistingComputerTest(String uRL, String pageTitle, String computerName,
			String clkFilterByName, String clkComputerName, String editPageHeader, String editintroducedDate,
			String clickSaveButton, String successMassage) 
			throws Throwable{
	openbrowser(uRL);
	new ComputerDBHomePage()
	.verifytitlePage(pageTitle)
	.enterComputerName(computerName)
	.clickFilterByComp(clkFilterByName)
	.clickComputerName(clkComputerName)	
	.verifyEditComputerPage(editPageHeader)
	.editIntroductionDate(editintroducedDate)
	.clickSaveComputerBtn(clickSaveButton)
	.verifySuccessMsg(successMassage);
	}
}
