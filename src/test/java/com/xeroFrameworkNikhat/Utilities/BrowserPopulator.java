package com.xeroFrameworkNikhat.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserPopulator {

	
	// This Method reads data from Config .properties file and select browser and opens URL 
	public static WebDriver openURL(WebDriver driver, String browserName, String uRL) throws Exception {
		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else if (browserName.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		else {
			System.out.println("Browser is not Supported");
			throw new Exception("Browser is not Supported");
		}

		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(uRL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	//This method Kills the Browser operation
	public static void quitURL(WebDriver driver) {
		driver.quit();
	}

}
