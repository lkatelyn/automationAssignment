package com.BackBase.assignment.WrapperClasses;


public interface WrappersInterface {	
	
	public void invokeApp(String browser);

	public void loadObjects();

	public void loadTestdata();

	public void unloadObjects();
	
	public boolean enterById(String idValue,String data) throws Throwable;

	public boolean enterByName(String nameValue,String data) throws Throwable;

	public boolean VerifyTitle(String title) throws Throwable;

	public boolean VerifyWindowTitleById(String idValue, String WinTitle) throws Throwable;
	
	public boolean VerifyWindowTitleByXpath(String xpathValue, String WinTitle) throws Throwable;
	
	public boolean VerifyTextById(String idValue,String data) throws Throwable;

	public boolean VerifyTextByXpath(String xpathValue,String data) throws Throwable;
	
	public boolean clickById(String idValue) throws Throwable;

	public boolean clickButtonById(String idValue, String data) throws Throwable;
	
	public boolean clickButtonByXpath(String xpathValue, String data) throws Throwable;
	
	public boolean openbrowser(String URL) throws Throwable;
	
	public void quitBrowser() throws Throwable;
	
	public boolean actionClickByXpath(String xpathValue, String dataValue) throws Throwable;
	
	}
