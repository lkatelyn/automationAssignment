package com.BackBase.assignment.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.BackBase.assignment.PageClasses.ComputerDBHomePage;
import com.BackBase.assignment.WrapperClasses.BackBaseWrappers;

public class CreateNEWComputerTest extends BackBaseWrappers{
	
	
	@Parameters({"browsers"})
	@BeforeClass
	public void startTestCase() {
		dataSheetName="ComputerDataBaseTestData";
		testCaseName="Create NEW Computer Test";
		testDescription= "This Test Case is to Verify Create New Computer Functionality";
	}	
	@Test(dataProvider="fetchdata")
	public void CreateNewComputerTest(String uRL, String pageTitle, String aDdNEWbtn,
			String createNEWpageHeader, String computerName, String introducedDate,
			String discontinuedDate, String optionValue, String createNewButton,	
			String successMassage) 
			throws Throwable{
	openbrowser(uRL);
	new ComputerDBHomePage()
	.verifytitlePage(pageTitle)
	.ClickCreateNEWcomputerBtn(aDdNEWbtn)
	.verifyCreateNewPage(createNEWpageHeader)
	.enterComputerName(computerName)
	.enterIntroducedDate(introducedDate)
	.enterDiscontinuedDate(discontinuedDate)
	.selectCompanyName(optionValue)
	.clickCreateNewCoputerBtn(createNewButton)
	.verifySuccessMsg(successMassage);
	}
}
