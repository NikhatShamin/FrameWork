package com.xeroFrameworkNikhat.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.xeroFrameworkNikhat.Utilities.ConfigReader;
import com.xeroFrameworkNikhat.pages.AccountPage;
import com.xeroFrameworkNikhat.pages.AddBankAccountPage;
import com.xeroFrameworkNikhat.pages.AuthenticationPage;
import com.xeroFrameworkNikhat.pages.HomePage;
import com.xeroFrameworkNikhat.pages.LoginPage;
import com.xeroFrameworkNikhat.pages.SecurityQuestionPage;

public class LogintoXeroValidAccount extends BaseTest {

	ConfigReader userConfig = new ConfigReader("./Configuration/ConfigUsernamePassword.properties");

	@Test
	public void loginToAccount() throws Exception {

		logger = report.createTest("Login to Account"); // report start of test for extent report

		HomePage homepage = PageFactory.initElements(driver, HomePage.class); // initialize WebElements from HomePage
		homepage.userLogIn();
		System.out.println(driver.getTitle());

		logger.info("Loging in to Xero Account");

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);// initialize WebElements from LoginPage
		loginpage.logintoXero(userConfig.getDataFromConfig("Username"), userConfig.getDataFromConfig("Password"));// reads
																													// data
																													// .properties
																													// file

		AuthenticationPage authenticate = PageFactory.initElements(driver, AuthenticationPage.class);// initialize
																										// WebElements
																										// from
																										// AuthenticationPage
		authenticate.authenticationMethod();

		SecurityQuestionPage secure = PageFactory.initElements(driver, SecurityQuestionPage.class);// initialize
																									// WebElements from
																									// SecurityQuestionPage
		secure.answerSecurityQuestions();

		logger.pass("Logged in Sucessfully");

		logger.info("Add Bank Account");

		AccountPage accountPage = PageFactory.initElements(driver, AccountPage.class);// initialize WebElements from
																						// AccountPage
		accountPage.clickMenu("Accounting", "Bank accounts", driver);

		AddBankAccountPage addBank = PageFactory.initElements(driver, AddBankAccountPage.class);// initialize
																								// WebElements from
																								// AddBankAccountPage
		addBank.addAccountButton();
		addBank.selectBank("ANZ (NZ)");

		// generate random string for filling Bank account details
		new RandomStringUtils();
		new RandomStringUtils();
		addBank.enterAccountDetails(RandomStringUtils.random(5, true, false), "Everyday (day-to-day)",
				RandomStringUtils.random(5, false, true));

		logger.pass("Bank Account Added Sucessfully"); // report end of test for extent report

	}
}
