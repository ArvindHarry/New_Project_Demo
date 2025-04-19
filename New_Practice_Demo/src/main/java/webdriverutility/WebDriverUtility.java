package webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void getMaximumScreen(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementToLoad(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void selectFromDropDown(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void selectFromDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

	public void selectFromDropDown(int value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByIndex(value);
	}

	public void getMoveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}

	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		for (String windowHandle : set) {
			driver.switchTo().window(windowHandle);
			String actURL = driver.getCurrentUrl();
			if (actURL.equals(partialURL)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		for (String windowHandle : set) {
			driver.switchTo().window(windowHandle);
			String actTitle = driver.getTitle();
			if (actTitle.equals(partialTitle)) {
				break;
			}
		}
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void waitForAlertToLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void scrollToPageEnd(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
	}

}
