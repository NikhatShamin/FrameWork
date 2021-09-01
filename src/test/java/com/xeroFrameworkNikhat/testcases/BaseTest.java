package com.xeroFrameworkNikhat.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.xeroFrameworkNikhat.Utilities.BrowserPopulator;
import com.xeroFrameworkNikhat.Utilities.ConfigReader;
import com.xeroFrameworkNikhat.Utilities.Handler;

public class BaseTest {

	public WebDriver driver;

	public ConfigReader config;
	public ExtentReports report;
	public ExtentTest logger;

	// Class used for reading data from .properties file and generating reports
	@BeforeSuite
	public void setUp() {

		config = new ConfigReader("./Configuration/ConfigBrowserURL.properties");
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/XeroLogin+" + Handler.nameGenerator() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		

	}

	// Opens URL, by selecting Browser by reading from Config File
	@BeforeClass
	public void startApp() throws Exception {
		driver = BrowserPopulator.openURL(driver, config.getDataFromConfig("Browser"), config.getDataFromConfig("URL"));
	}

	// Quits the Browser
	@AfterClass
	public void QuitApp() {
		BrowserPopulator.quitURL(driver);
	}

	// Captures Screenshot when Test fails
	@AfterMethod
	public void QuitAppMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE)

		{
			Handler.captureScreenshot(driver);
		}
		report.flush();
	}

}
