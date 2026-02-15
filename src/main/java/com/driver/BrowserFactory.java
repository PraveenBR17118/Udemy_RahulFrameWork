package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver createBrowserInstance(String browserName) 
	{

		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("Chrome"))
		{
			
			
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("--headless");
			 
			 
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}

		else if (browserName.equalsIgnoreCase("Firefox")) 
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		return driver;
	}

}
