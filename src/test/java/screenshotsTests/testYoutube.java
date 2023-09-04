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


public class testYoutube extends TestBase {
	@Test(enabled = true)
	@Parameters({"urlYT","newBase"})
	public void pruebaCapturaCompleta(String urlYT,String newBase) throws IOException, InterruptedException {
		setExtent("PruebaYoutube");
		test.log(Status.INFO, "Directing to the website:"+ urlYT);
		this.automator.goTo(urlYT);
		PruebaYoutube p = new PruebaYoutube(this.automator); 
		p.pruebaBuscar("Selenium Tutorial for begginers",vt,test,newBase);
		
		/*this.automator.maximizeWindows();
		
		test.log(Status.INFO, "Capturing page...");
		VisualTesting vt = new VisualTesting(this.automator.getDriver());
		
		vt.Capture(newBase, test, "googleHome.png");
		PruebaGoogle p = new PruebaGoogle(this.automator);
		p.buscarEnGoogle("hola",vt,test,newBase);
		this.automator.goTo(urlGoogle);*/
	}
	
	
}