package com.alert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.driver.DriverFactory;
import com.report.ExtentFactory;

@SuppressWarnings("static-access")
public class AlertActions {

	private Logger logger = LogManager.getLogger(AlertActions.class);

	private Alert alert;

	public void switchToAlert()
	{

		try 
		{
			alert = DriverFactory.getInstance().getDriver().switchTo().alert();
			logger.info("Swicthed to alert.");
			ExtentFactory.getInstance().passTest("Swicthed to Alert");
		} catch (NoAlertPresentException e) {
			logger.error("Exception occured while swicthing to alert.");
			ExtentFactory.getInstance().falTest("Exception occured while swicthing to alert.");
		}

	}

	public void acceptAlert() 
	{

		try 
		{
			this.alert.accept();
			logger.info("Clicked on OK button");
			ExtentFactory.getInstance().passTest("Clicked on OK button");
		} 
		catch (Exception e) 
		{
			logger.error("Exception occured while clicking On OK button.");
			ExtentFactory.getInstance().falTest("Exception occured while clicking On OK button.");

		}
	}

	public void cancelAlert() 
	{

		try 
		{
			this.alert.dismiss();
			logger.info("Clicked on cancel button");
			ExtentFactory.getInstance().passTest("Clicked on cancel button");
		} catch (Exception e) 
		{
			logger.error("Exception occured while clicking On cancel button.");
			ExtentFactory.getInstance().falTest("Exception occured while clicking On cancel button.");
		}
	}

}
