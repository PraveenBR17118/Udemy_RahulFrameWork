package com.test;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.AmazonPage;
import com.properties.TestDataLoader;


public class AmazTest extends BaseTest
{
	@Test
	public void loginWithValidUserNameAndValidPassword() 
	{

		
		AmazonPage amz = new AmazonPage();
		amz.enterSearchName(TestDataLoader.getInstance().getUserName());
		amz.returnName();
		
		

	}

}



