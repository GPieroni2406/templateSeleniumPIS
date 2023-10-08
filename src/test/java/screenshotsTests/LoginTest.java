package screenshotsTests;
import automation.VisualTesting;
import automation.WebAutomator;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pom.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import test.TestBase;


public class LoginTest extends TestBase {
	
	@Test(enabled = true)
	@Parameters({"host","newBase","user","pass"})
	public void login(String host,String newBase,String user,String pass) throws IOException, InterruptedException {
		setExtent("Login"); //Seteamos nombre del reporte.
		test.log(Status.INFO, "Directing to the website:"+ host);
		this.automator.goTo(host);
		this.automator.maximizeWindows();
		
		test.log(Status.INFO, "Capturing page...");
		VisualTesting vt = new VisualTesting(this.automator.getDriver());
		
		vt.Capture(newBase, test, "LoginHome.png");
		Login l = new Login(this.automator, test, vt, newBase);
		l.Loguearse(user, pass);
		this.automator.closeAll();
	}
	
	
}