package com.qa.openkart.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitElementVisisbility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public List<WebElement> waitElementsVisisbility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	

	public WebElement dofindWebElement(By Locator) {
		return driver.findElement(Locator);
	}

	public List<WebElement> findlistofWebElement(By Locator) {
		return driver.findElements(Locator);
	}

	public void doclick(By locator) {
		dofindWebElement(locator).click();
	}

	public void doSendKeys(By locator, String value) {
		dofindWebElement(locator).clear();
		dofindWebElement(locator).sendKeys(value);
		
	}

	public void doActionclick(By locator) {
		Actions act = new Actions(driver);
		act.click(dofindWebElement(locator)).build().perform();

	}

}
