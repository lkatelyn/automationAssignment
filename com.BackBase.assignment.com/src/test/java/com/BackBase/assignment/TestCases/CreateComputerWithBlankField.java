package com.BackBase.assignment.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.BackBase.assignment.PageClasses.ComputerDBHomePage;
import com.BackBase.assignment.WrapperClasses.BackBaseWrappers;

public class CreateComputerWithBlankField extends BackBaseWrappers{
	
	
	@Parameters({"browsers"})
	@BeforeClass
	public void startTestCase() {
		dataSheetName="EmptyFieldSubmition";
		testCaseName="Create Computer with Empty Fields";
		testDescription= "This Test Case is to Verify to get Error Message";
	}	
	@Test(dataProvider="fetchdata")
	public void CreateComputerwithBlankFieldTest(String uRL, String pageTitle, String aDdNEWbtn,
			String createNEWpageHeader, String createNewButton, String requiredMassage) 
			throws Throwable{
	openbrowser(uRL);
	new ComputerDBHomePage()
	.verifytitlePage(pageTitle)
	.ClickCreateNEWcomputerBtn(aDdNEWbtn)
	.verifyCreateNewPage(createNEWpageHeader)
	.clickCreateNewCoputerBtn(createNewButton)
	.verifyRequiredErrorMsg(requiredMassage);
	}
}
