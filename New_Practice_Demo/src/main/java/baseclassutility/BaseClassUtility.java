package baseclassutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import fileutility.FileUtility;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import webdriverutility.WebDriverUtility;

public class BaseClassUtility {
	
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	FileUtility flib = new FileUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	
	
	@BeforeSuite
	public void configBS() throws Throwable {
		System.out.println("===Connect to Database===");
	}
	
	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("===Launch Browser===");
		String BROWSER = flib.getDataFromPropertiesFiles("browser");
		if(BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.contains("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		wlib.getMaximumScreen(driver);
		wlib.waitForPageToLoad(driver);
		String URL = flib.getDataFromPropertiesFiles("url");
		driver.get(URL);
		sdriver = driver;

	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("===Login===");
		LoginPage lp = new LoginPage(driver);
		lp.login();
	}
	
	@AfterMethod
	public void configAM() throws Throwable {
		System.out.println("===Logout===");
		Thread.sleep(2000);
		HomePage hp = new HomePage(driver);
		hp.logout();
		
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("===Close browser===");
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("===Close Database Connection===");
	}

}
