package com.BackBase.assignment.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.BackBase.assignment.PageClasses.ComputerDBHomePage;
import com.BackBase.assignment.WrapperClasses.BackBaseWrappers;

public class DeleteExistingComputer extends BackBaseWrappers{
	
	
	@Parameters({"browsers"})
	@BeforeClass
	public void startTestCase() {
		dataSheetName="DeleteComputerTestData";
		testCaseName="Delete Existing Computer Details";
		testDescription= "This Test Case is to Delete Existing Computer Details";
	}	
	@Test(dataProvider="fetchdata")
	public void DeleteExistingComputerTest(String uRL, String pageTitle, String computerName,
			String clkFilterByName, String clkComputerName, String editPageHeader, String clickDeleteButton, 
			String successMassage) 
			throws Throwable{
	openbrowser(uRL);
	new ComputerDBHomePage()
	.verifytitlePage(pageTitle)
	.enterComputerName(computerName)
	.clickFilterByComp(clkFilterByName)
	.clickComputerName(clkComputerName)	
	.verifyEditComputerPage(editPageHeader)
	.clickDeleteComputerBtn(clickDeleteButton)
	.verifySuccessMsg(successMassage);
	}
}
