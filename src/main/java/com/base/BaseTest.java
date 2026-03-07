package com.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.driver.BrowserFactory;
import com.driver.DriverFactory;
import com.properties.ConfigLoader;
import com.properties.TestDataLoader;

import java.util.ArrayList;
import java.util.List;

public class BaseTest 
{

	@BeforeSuite
	public void setUP()
	{

		moveFile();
		WebDriver driver = BrowserFactory.createBrowserInstance(ConfigLoader.getInstnace().getPropertyValue("browser"));

		DriverFactory.getInstance().setDriver(driver);
		
		DriverFactory.getInstance().getDriver().get(TestDataLoader.getInstance().getAppUrl());

	}

	@AfterSuite
	public void tearDown() 
	{
		DriverFactory.getInstance().getDriver().quit();
	}
	
	
	
	public void moveFile() 
	{
		//String reportsDirPath = System.getProperty("user.dir") + "/reports/extent-reports";
		Path targetDir = Paths.get(System.getProperty("user.dir"), "reports", "extentreports");
		System.out.println("Target directory path: " + targetDir.toAbsolutePath());
		/*
		 * String sourcePath = System.getProperty("user.dir") +
		 * "/reports/Test.*extentReport.html"; String destinationPath =
		 * System.getProperty("user.dir") + "/reports/extentreports/Test.*" +
		 * System.currentTimeMillis() + "*extentReport.html";
		 */
		
		
		List<String> filesToMove = new ArrayList<>();
		
		File[] files = new File(System.getProperty("user.dir") + "/reports/").listFiles();
		
		for(File file : files) 
		{
			filesToMove.add(file.getName());
			System.out.println("File to move: " + file.getName());
		}
		
		for(String fileName : filesToMove) 
		{
			String sourceFilePath = System.getProperty("user.dir") + "/reports/" + fileName;
			String destinationFilePath = System.getProperty("user.dir") + "/reports/extentreports/" + fileName;
		
			try {
					if (Files.notExists(targetDir))
					{
			            Files.createDirectories(targetDir);
			        }
				
					Path source = Paths.get(sourceFilePath);
					Path destination = Paths.get(destinationFilePath);
					Files.move(source, destination);
					System.out.println("File moved successfully from "+source+" to: " + destinationFilePath);
				
				/*
				 * File sourceFile = new File(sourceFilePath);
				 * System.out.println("Source file path: " + sourceFile.getAbsolutePath()); File
				 * destinationFile = new File(destinationFilePath);
				 * System.out.println("Destination file path: " +
				 * destinationFile.getAbsolutePath()); FileUtils.moveFile(sourceFile,
				 * destinationFile); System.out.println("File moved successfully to: " +
				 * destinationFilePath);
				 */
			}
			catch (IOException e)
			{
				System.err.println("Error creating target directory: " + e.getMessage());
				return;
			}
		}
		
		/*
		 * try { if (Files.notExists(targetDir)) { Files.createDirectories(targetDir); }
		 * File sourceFile = new File(sourcePath);
		 * System.out.println("Source file path: " + sourceFile.getAbsolutePath()); File
		 * destinationFile = new File(destinationPath);
		 * System.out.println("Destination file path: " +
		 * destinationFile.getAbsolutePath()); FileUtils.moveFile(sourceFile,
		 * destinationFile); System.out.println("File moved successfully to: " +
		 * destinationPath);
		 * 
		 * } catch (IOException e) {
		 * System.err.println("Error creating target directory: " + e.getMessage());
		 * return; }
		 */
	}

}
