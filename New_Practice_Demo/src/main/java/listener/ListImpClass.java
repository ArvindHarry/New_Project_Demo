package listener;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import baseclassutility.BaseClassUtility;

public class ListImpClass implements ISuiteListener,ITestListener{
	
	ExtentReports report = null;
	ExtentTest test = null;
	
	@Override
	public void onStart(ISuite suite) {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("Havi Logictics");
		spark.config().setReportName("XOLO Application");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("OS", "Windows");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.PASS, name+" Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		TakesScreenshot tks = (TakesScreenshot)(BaseClassUtility.sdriver);
		String src = tks.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(":", "_").replace(" ", "_");
		
		test.addScreenCaptureFromBase64String(src, name+"_"+time);
		
		test.log(Status.FAIL, name+" Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP, name+" Skipped");
	}

}
