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


public class Prueba2 extends TestBase {
	
	@Test(enabled = true)
	@Parameters({"urlBBC","newBase"})
	


	public void buscar(String urlBBC,String newBase) throws IOException, InterruptedException {
		setExtent("CR7"); //Seteamos nombre del reporte.
		test.log(Status.INFO, "Directing to the website:"+ urlBBC);
		this.automator.goTo(urlBBC);
		this.automator.maximizeWindows();
		
		test.log(Status.INFO, "Capturing page...");
		VisualTesting vt = new VisualTesting(this.automator.getDriver());
		
		vt.Capture(newBase, test, "bbchome.png");
		pruebaBBC p = new pruebaBBC(this.automator);
		p.registro("holaholaods2@gmail.com",vt,test,newBase);
		
		
	
	
	}
	
	
}