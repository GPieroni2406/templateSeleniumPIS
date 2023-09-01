package test;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import automation.VisualTesting;
import automation.WebAutomator;
import browsers.Browser;
import config.Config;
import util.PropertiesHandler;

public class TestBase {
	
	protected WebAutomator automator;
	protected PropertiesHandler mp;
	protected String browser;
	ExtentReports extent = new ExtentReports();
	protected ExtentTest test;
	protected VisualTesting vt;
	

	public ExtentReports getExtent() {
		return extent;
	}

	public void setExtent(String reportName) {
		ExtentSparkReporter spark = new ExtentSparkReporter(Config.REPORTS_PATH + reportName + ".html");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);
		test = extent.createTest("Test " + reportName);
	}
	
	
	// Logger
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(TestBase.class);
	
	
	
	@BeforeMethod
	@Parameters({"browser","isHeadless", "max_wait"})
	public void setUpDriver(@Optional("CHROME") String browser, Boolean isHeadless, @Optional("30") long max_wait) throws Exception 
	{
		//Initialize WebDriver
		Browser b = Browser.valueOf(browser);
		automator = new WebAutomator(b,isHeadless, true, max_wait);
		//Initialize property Manager
		mp = new PropertiesHandler();
		this.browser = browser;
		
		vt = new VisualTesting(this.automator.getDriver());
	}
	
	public void setUpDriverParaIncognito(String browser, @Optional("30") long max_wait) throws Exception 
	{
		logger.info("Se abre un nuevo driver con el navegador incognito");
		Browser b = Browser.valueOf(browser);
		automator = new WebAutomator(b, true, true, max_wait);		
	}
	
	@AfterClass
	@Parameters({"close_browser_after_execution"})
	public void tearDownDriver(@Optional("true") boolean closeBrowser) throws Exception {
		if (closeBrowser) {
			automator.closeBrowser();
		}
	}
	
	@AfterMethod
	public void tearDownDriver() throws Exception {
		automator.closeAll();
	}

	protected WebAutomator getAutomator(){
		return this.automator;
	}
	
	
}
