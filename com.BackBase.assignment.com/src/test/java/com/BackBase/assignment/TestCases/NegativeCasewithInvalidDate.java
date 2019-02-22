package com.BackBase.assignment.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.BackBase.assignment.PageClasses.ComputerDBHomePage;
import com.BackBase.assignment.WrapperClasses.BackBaseWrappers;

public class NegativeCasewithInvalidDate extends BackBaseWrappers{
	
	
	@Parameters({"browsers"})
	@BeforeClass
	public void startTestCase() {
		dataSheetName="InvalidDateFormat";
		testCaseName="Negative Test To verify Invalid Date";
		testDescription= "This Test Case is to verify the error message while sending Invalid date";
	}	
	@Test(dataProvider="fetchdata")
	public void NegativeTestToVerifyInvalidDate(String uRL, String pageTitle, String aDdNEWbtn,
			String createNEWpageHeader, String computerName, String invalidintroducedDate, 
			String createNewButton, String requiredMassage) 
			throws Throwable{
	openbrowser(uRL);
	new ComputerDBHomePage()
	.verifytitlePage(pageTitle)
	.ClickCreateNEWcomputerBtn(aDdNEWbtn)
	.verifyCreateNewPage(createNEWpageHeader)
	.enterComputerName(computerName)
	.enterIntroducedDate(invalidintroducedDate)
	.clickCreateNewCoputerBtn(createNewButton)
	.verifyDateFormatErrorMsg(requiredMassage);
	}
}
