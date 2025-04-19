package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fileutility.FileUtility;

public class LoginPage {
	
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement userName;
	
	@FindBy(name = "user_password")
	private WebElement password;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void login() throws Throwable {
		FileUtility flib = new FileUtility();
		String USERNAME = flib.getDataFromPropertiesFiles("username");
		String PASSWORD = flib.getDataFromPropertiesFiles("password");
		
		userName.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		submitBtn.click();
	}

}
