package com.xeroFrameworkNikhat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.xeroFrameworkNikhat.testcases.BaseTest;

//This class opens HomePage and clicks on Login button
public class HomePage extends BaseTest {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.LINK_TEXT, using = "Log in")
	WebElement clickLogin;

	public void userLogIn() {

		clickLogin.click();
	}

}
