package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver createBrowserInstance(String browserName) {

		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("Chrome")) 
		{

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new"); // This runs the browser in the background
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");

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
