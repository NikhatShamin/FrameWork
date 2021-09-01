package com.xeroFrameworkNikhat.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.xeroFrameworkNikhat.pages.HomePage;

public class HomePageXero extends BaseTest {

	// Class to open Homepage
	@Test
	public void logIn() throws Exception

	{
		logger = report.createTest("Open HomePage"); // logs start of the Class

		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.userLogIn();
		System.out.println(driver.getTitle());

		logger.pass("HomePage opened Sucessfully"); // logs end of the Class

	}

}
