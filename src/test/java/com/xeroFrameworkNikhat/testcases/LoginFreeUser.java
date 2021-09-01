package com.xeroFrameworkNikhat.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.xeroFrameworkNikhat.pages.FreeLoginPage;

public class LoginFreeUser extends BaseTest {

	
	
	
	//Login as a Free User to Xero
	@Test
	public void loginHomePage() {

		FreeLoginPage freeLogin = PageFactory.initElements(driver, FreeLoginPage.class); //initialize WebElements from FreeloginPage
		freeLogin.homePage("dfs", "gergerg", "ergerg", "446665");

	}

}
