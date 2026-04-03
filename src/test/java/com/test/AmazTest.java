package com.test;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.AmazonPage;
import com.properties.TestDataLoader;


public class AmazTest extends BaseTest
{
	@Test(priority = 1)
	public void serch_For_Mobiles() 
	{

		
		AmazonPage amz = new AmazonPage();
		amz.enterSearchName(TestDataLoader.getInstance().getUserName());
		amz.returnName(TestDataLoader.getInstance().getMobileName());
		
	}
	
	@Test(priority = 2, dependsOnMethods = "serch_For_Mobiles")
	public void clickOnMobile()
	{
		AmazonPage amz = new AmazonPage();
		amz.clickOnMobile(TestDataLoader.getInstance().getMobileName());
	}
	
	
	@Test(priority = 3, dependsOnMethods = "clickOnMobile")
	public void vrifyCart()
	{
		AmazonPage amz = new AmazonPage();
		amz.verifyCart();
		
	}
	
	
	@Test(priority = 4, dependsOnMethods = "vrifyCart")
	public void verifyTotalAmount()
	{
		AmazonPage amz = new AmazonPage();
		amz.clickOnCartIcon();
		amz.closeTab();
	}
	
	@Test( priority = 5, enabled = false)
	public void skipTest() 
	{
		 boolean isEnvironmentUp = false;

	        if (!isEnvironmentUp)
	        {
	            // This is the trigger for TestNG
	            throw new SkipException("Skipping test: Environment is down.");
	        }
	        
	        System.out.println("This line will never be reached.");
		
	}
	
	@Test(priority = 6, enabled = false)
	public void failTest() 
	{
		 assert false : "This test is designed to fail.";
	}
	
	

}



