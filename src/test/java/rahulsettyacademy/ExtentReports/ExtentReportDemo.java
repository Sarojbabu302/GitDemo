package rahulsettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	WebDriver driver;
	ExtentReports extent;
	
	@BeforeTest
	public void Config()
	{
		// ExtentSparkReporter & ExtentReport
		String path= System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Saroj Kumar Behera");
	}
	
	@Test
	public void InitialTest()
	{
		extent.createTest("Initial Test");
		System.setProperty("webdriver.chromedriver","C://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		extent.flush();
	}

}
