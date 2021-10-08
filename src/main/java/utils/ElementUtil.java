package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
			break;

		case "name":
			locator = By.name(locatorValue);
			break;

		case "className":
			locator = By.className(locatorValue);
			break;

		case "linkText":
			locator = By.className(locatorValue);
			break;

		case "partialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;

		case "xpath":
			locator = By.xpath(locatorValue);
			break;

		case "cssSelector":
			locator = By.cssSelector(locatorValue);
			break;

		}
		return locator;
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	public java.util.List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

	public String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if (wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
		}
		return null;
	}

	/*******************
	 * User Actions Utils
	 * 
	 * @throws InterruptedException
	 *****************/
	public void twoLevelMenuHandle(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}

	/******************** Drop Down Utils (Select tag) ***********/
	public void doSelectByVisibleText(By locator, String text) {

		Select select=new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
}