package com.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.constants.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager 
{

	public static ExtentReports setUpExtentReport() 
	{
		
		LocalDateTime now = LocalDateTime.now();
        //System.out.println("Before Formatting: " + now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 3. Format and print
        String formattedDate = now.format(formatter);
        //System.out.println("After Formatting: " + formattedDate);
		ExtentSparkReporter reporter = new ExtentSparkReporter(Constants.EXECUTION_REPORT_PATH+"Test"+formattedDate+"execution.html");

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);

		return extent;

	}

}
