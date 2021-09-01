package com.xeroFrameworkNikhat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FreeLoginPage {

	WebDriver driver;

	public FreeLoginPage(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(name = "FirstName")
	WebElement firstName;

	@FindBy(name = "LastName")
	WebElement lastName;

	@FindBy(name = "EmailAddress")
	WebElement eMail;

	@FindBy(name = "PhoneNumber")
	WebElement phoneNumber;

	@FindBy(linkText = "Next: Confirmation")
	WebElement confirmationNext;

// This Method is used to send data to LoginFreeUser class

	public void homePage(String Fname, String lname, String mail, String pNumber) {

		firstName.sendKeys(Fname);
		lastName.sendKeys(lname);
		eMail.sendKeys(mail);
		phoneNumber.sendKeys(pNumber);
		confirmationNext.click();
	}
}
