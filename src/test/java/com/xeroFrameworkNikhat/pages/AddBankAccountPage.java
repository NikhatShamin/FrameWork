package com.xeroFrameworkNikhat.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddBankAccountPage extends BasePage {

	public AddBankAccountPage(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(how = How.XPATH, using = "//span[@data-automationid='Add Bank Account-button']")
	WebElement addBankAccountButton;

	@FindBy(how = How.XPATH, using = "//input[@name='accountname-1025-inputEl']")
	WebElement accountName;

	@FindBy(how = How.CSS, using = "div[id*='accounttype'][id*='trigger-picker']")
	WebElement accountType;

	@FindBy(how = How.XPATH, using = "//input[@id='accountnumber-1056-inputEl']")
	WebElement accountNumber;

	@FindBy(how = How.XPATH, using = "//a[@id='common-button-submit-1015']")
	WebElement continueButton;

	String bankPath = "a[class='xui-contentblockitem xui-contentblockitem-layout xui-contentblockitem-rowlink']";
	String accountTypePath = "div[class*='boundlist-floating'] li";

	// Clicks Add Bank account Button
	public void addAccountButton() {

		addBankAccountButton.click();

	}

	// Selects Bank
	public void selectBank(String bank) {
		selectElement(bank, bankPath);
	}

	// This method adds Bank account Details generated randomly
	public void enterAccountDetails(String accountName, String accountType, String accountNumber) {
		this.accountName.sendKeys(accountName);
		this.accountType.click();
		selectElement(accountType, accountTypePath);
		this.accountNumber.sendKeys(accountNumber);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		continueButton.click();
	}

}
