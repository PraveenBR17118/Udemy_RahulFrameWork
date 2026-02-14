package com.test;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;

@Test
public class HomeTest extends BaseTest
{
	HomePage homePage;
	
	@Test
	public void clickOnAdmin() 
	{
		homePage = new HomePage();
		homePage.clickOnAdminLInk();
		
	}
	
	@Test
	public void logout() 
	{
		homePage = new HomePage();
		homePage.logoutFromApplication();
	} 

}
