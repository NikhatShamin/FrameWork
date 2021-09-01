package com.xeroFrameworkNikhat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// This class helps Login to Xero Account
public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(name = "Username")
	WebElement userName;

	@FindBy(name = "Password")
	WebElement passWord;

	@FindBy(id = "xl-form-submit")
	WebElement submitButton;

	public void logintoXero(String uName, String pass) {

		userName.sendKeys(uName);
		passWord.sendKeys(pass);
		submitButton.click();
	}

}
