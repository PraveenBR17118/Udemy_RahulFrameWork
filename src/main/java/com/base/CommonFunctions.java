package com.base;

import com.driver.DriverFactory;

public class CommonFunctions 
{
	
	
	public void switchToHomeTab(String title) 
	{
		DriverFactory.getInstance().getDriver().switchTo().window(title);
	}
	
	
	public void closeTab() 
	{
		DriverFactory.getInstance().getDriver().close();
	}
	
	
}
