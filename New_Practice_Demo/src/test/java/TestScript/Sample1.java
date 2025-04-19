package TestScript;

import org.testng.annotations.Test;

import baseclassutility.BaseClassUtility;
import excelutility.ExcelUtility;
import javautility.JavaUtility;
import objectrepository.CreatingNewOrganizationPage;
import objectrepository.HomePage;
import objectrepository.OrganizationsPage;

public class Sample1 extends BaseClassUtility{

	@Test
	public void sampleTest() throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String expectedOrgName = elib.readDataFromExcel("org1", 7, 2) + jlib.randomNumber(5000);
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.getOrgNameEdt().sendKeys(expectedOrgName);
		cop.getSaveBtn().click();
		
		System.out.println("Arvind Harry");
		
	}
}
