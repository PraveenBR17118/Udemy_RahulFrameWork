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

			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("--headless=new"); // This runs the browser in the
			 * background options.addArguments("--no-sandbox");
			 * options.addArguments("--disable-dev-shm-usage");
			 */
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--window-size=1920,1080");

			//WebDriver driver = new ChromeDriver(options);
			driver = new ChromeDriver(options);
			//driver = new ChromeDriver();
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
