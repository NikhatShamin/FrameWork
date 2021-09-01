package com.xeroFrameworkNikhat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


//This class is used to select WebElements from the List
public class BasePage {

	WebDriver driver;

	public void clickMenu(String menu, String subMenu, WebDriver driver) {
		Actions action = new Actions(driver);
		List<WebElement> elements = driver.findElements(By.cssSelector(
				"div[class='xnav-header--main'] ol[role='navigation'][class*='xnav-tabgroup'] li[class='xnav-tab']"));

		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(menu)) {
				action.click(element).build().perform();
				clickSubMenu(subMenu, driver, element);
				break;
			}
		}
	}

	private void clickSubMenu(String option, WebDriver driver, WebElement rootElement) {
		Actions action = new Actions(driver);
		List<WebElement> elements = rootElement.findElements(By.cssSelector(" li[class='xnav-verticalmenuitem']"));

		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(option)) {
				action.click(element).build().perform();
				break;
			}
		}
	}

	public void selectElement(String parameter, String elementPath) {
		Actions action = new Actions(driver);
		List<WebElement> elements = driver.findElements(By.cssSelector(elementPath));

		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(parameter)) {
				action.click(element).build().perform();
				break;
			}
		}
	}

}
