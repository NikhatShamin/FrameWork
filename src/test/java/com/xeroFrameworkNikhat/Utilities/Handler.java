package com.xeroFrameworkNikhat.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Handler {

	// This method captures screenshot for the Report
	public static void captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			FileHandler.copy(src, new File("./Screenshots/Xero-" + nameGenerator() + ".png"));

		} catch (IOException e) {

			System.out.println("Failed to capture Screenshot " + e.getMessage());
		}

	}

	// This method Generates Random names for Report
	public static String nameGenerator() {
		DateFormat dateFormat = new SimpleDateFormat("MM_yyyy_HH_mm_ss");

		Date currentDate = new Date();
		return dateFormat.format(currentDate);
	}

}
