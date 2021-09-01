package com.xeroFrameworkNikhat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.xeroFrameworkNikhat.Utilities.ConfigReader;



// this class selects the answer for security question based on questions from .properties file.


public class SecurityQuestionPage {

	WebDriver driver;

	ConfigReader securityQAConfig = new ConfigReader("./Configuration/ConfigSecurityQuestionAnswer.properties");

	public SecurityQuestionPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@data-automationid='auth-firstanswer--label']")
	WebElement firstQuestion;

	@FindBy(how = How.XPATH, using = "//input[@data-automationid='auth-firstanswer--input']")
	WebElement firstAnswer;

	@FindBy(how = How.XPATH, using = "//*[@data-automationid='auth-secondanswer--label']")
	WebElement SecondQuestion;

	@FindBy(how = How.XPATH, using = "//input[@data-automationid='auth-secondanswer--input']")
	WebElement SecondAnswer;

	@FindBy(how = How.XPATH, using = "//button[@data-automationid='auth-submitanswersbutton']")
	WebElement ConfirmButton;

	public void answerSecurityQuestions() {

		String firstQues = firstQuestion.getText();

		if (firstQues.equals(securityQAConfig.getDataFromConfig("Question1"))) {
			firstAnswer.sendKeys(securityQAConfig.getDataFromConfig("Answer1"));
		}

		else if (firstQues.equals(securityQAConfig.getDataFromConfig("Question2"))) {

			firstAnswer.sendKeys(securityQAConfig.getDataFromConfig("Answer2"));
		} else {
			firstAnswer.sendKeys(securityQAConfig.getDataFromConfig("Answer3"));
		}

		String secondQues = SecondQuestion.getText();

		if (secondQues.equals(securityQAConfig.getDataFromConfig("Question1"))) {
			SecondAnswer.sendKeys(securityQAConfig.getDataFromConfig("Answer1"));
		}

		else if (secondQues.equals(securityQAConfig.getDataFromConfig("Question2"))) {

			SecondAnswer.sendKeys(securityQAConfig.getDataFromConfig("Answer2"));
		} else {
			SecondAnswer.sendKeys(securityQAConfig.getDataFromConfig("Answer3"));
		}

		ConfirmButton.click();

	}
}
