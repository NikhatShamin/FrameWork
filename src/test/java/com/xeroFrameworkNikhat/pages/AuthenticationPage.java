package com.xeroFrameworkNikhat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// This class to selects Authentication security type
public class AuthenticationPage {

	WebDriver driver;

	public AuthenticationPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//button[@class='xui-button xui-margin-top xui-button-borderless-main xui-button-medium xui-button-fullwidth']")
	WebElement useAnotherAuthenticationMethod;

	@FindBy(how = How.XPATH, using = "//*[@data-automationid='auth-authwithsecurityquestionsbutton']")
	WebElement securityQuestions;

	public void authenticationMethod() {
		useAnotherAuthenticationMethod.click();
		securityQuestions.click();

	}
}
