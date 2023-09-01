package screenshotsTests;
import automation.VisualTesting;

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


public class buscarGoogle extends TestBase {
	@Test(enabled = true)
	@Parameters({"urlGoogle","newBase"})
	public void pruebaCapturaCompleta(String urlGoogle,String newBase) throws IOException, InterruptedException {
		setExtent("PruebaGoogle"); //Seteamos nombre del reporte.
		test.log(Status.INFO, "Directing to the website:"+ urlGoogle);
		this.automator.goTo(urlGoogle);
		this.automator.maximizeWindows();
		
		test.log(Status.INFO, "Capturing page...");
		VisualTesting vt = new VisualTesting(this.automator.getDriver());
		
		vt.Capture(newBase, test, "googleHome.png");
		PruebaGoogle p = new PruebaGoogle(this.automator);
		p.buscarEnGoogle("hola",vt,test,newBase);
	
	}
	
	
}