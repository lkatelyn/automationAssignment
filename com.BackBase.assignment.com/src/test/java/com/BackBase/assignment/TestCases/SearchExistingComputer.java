package com.BackBase.assignment.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.BackBase.assignment.PageClasses.ComputerDBHomePage;
import com.BackBase.assignment.WrapperClasses.BackBaseWrappers;

public class SearchExistingComputer extends BackBaseWrappers{
	
	
	@Parameters({"browsers"})
	@BeforeClass
	public void startTestCase() {
		dataSheetName="SearchComputerTestData";
		testCaseName="Search Existing Computer Details";
		testDescription= "This Test Case is to Search and Read Existing Computer Details";
	}	
	@Test(dataProvider="fetchdata")
	public void SearchExistingComputerTest(String uRL, String pageTitle, String computerName,
			String clkFilterByName, String clkComputerName, String editPageHeader) 
			throws Throwable{
	openbrowser(uRL);
	new ComputerDBHomePage()
	.verifytitlePage(pageTitle)
	.enterComputerName(computerName)
	.clickFilterByComp(clkFilterByName)
	.clickComputerName(clkComputerName)	
	.verifyEditComputerPage(editPageHeader);
	}
}
