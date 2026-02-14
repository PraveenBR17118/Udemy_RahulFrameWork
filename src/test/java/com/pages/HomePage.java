package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.driver.DriverFactory;


public class HomePage extends BasePage
{
	
	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminlink;
	
	@FindBy(xpath = "//img[@alt='profile picture']")
	//@FindBy(xpath = "//img[@alt='profile picture']qq")
	WebElement profilePicture;
	
	@FindBy(linkText = "Logout")
	WebElement logoutLink;
	
	public HomePage() 
	{
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	//Logger log = LogManager.getLogger(HomePage.class);
	public void clickOnAdminLInk() 
	{
		
		
		super.click(adminlink, "admin");
		
		/*
		 * adminlink.click();
		BaseTest.log.info("Admin link clicked");
		ExtentReportUtils.addStep("Admin link clicked","No");
		*/
		
	}
	
	
	public void logoutFromApplication() 
	{
		
		try 
		{
			Thread.sleep(6000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.click(profilePicture, "Profile");
		
		super.click(logoutLink, "Logout");
		
		/*
		profilePicture.click();
		BaseTest.log.info("Profile picture clicked");
		ExtentReportUtils.addStep("Profile picture clicked", "yes");
		logoutLink.click();
		BaseTest.log.info("Logout button clicked");
		ExtentReportUtils.addStep("Logout button clicked" ,"No");
		*/
	}

}
