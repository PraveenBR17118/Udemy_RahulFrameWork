package com.test;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.AmazonPage;
import com.properties.TestDataLoader;


public class AmazTest extends BaseTest
{
	@Test(priority = 1)
	public void loginWithValidUserNameAndValidPassword() 
	{

		
		AmazonPage amz = new AmazonPage();
		amz.enterSearchName(TestDataLoader.getInstance().getUserName());
		amz.returnName();
		
		

	}
	
	@Test(priority = 2, dependsOnMethods = "loginWithValidUserNameAndValidPassword")
	public void clickOnMobile()
	{
		AmazonPage amz = new AmazonPage();
		amz.clickOnMobile();
	}
	
	
	@Test(priority = 3, dependsOnMethods = "clickOnMobile")
	public void vrifyCart()
	{
		AmazonPage amz = new AmazonPage();
		amz.verifyCart();
		amz.closeTab();
	}
	
	

}



