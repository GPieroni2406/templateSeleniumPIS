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


public class PrueboCapturaCompleta extends TestBase {
	@Test(enabled = true)
	@Parameters({"host","newBase"})
	public void pruebaCapturaCompleta(String host,String newBase) throws IOException, InterruptedException {
		setExtent("PruebaCompleta"); //Seteamos nombre del reporte.
		test.log(Status.INFO, "Directing to the website:"+ host);
		this.automator.goTo(host);
		this.automator.maximizeWindows();
		test.log(Status.INFO, "Capturing page...");
		VisualTesting vt = new VisualTesting(this.automator.getDriver());
		
		
		vt.Capture(newBase, test, "viewport_page.png");
	}
	
	@Test(enabled = true)
	@Parameters({"host","newBase"})
	public void pruebaIgnorarElemento(String host,String newBase) throws IOException, InterruptedException {
		setExtent("PruebaIgnorarElemento");
		
		this.automator.goTo(host);
		this.automator.maximizeWindows();
		test.log(Status.INFO, "Directing to the website:"+ host);
		
		//Cambio elemento en pantalla
		JavascriptExecutor js = (JavascriptExecutor) this.automator.getDriver();
		js.executeScript("document.getElementsByTagName('h1')[0].textContent='resolvemo tema de calidad papa'");
		VisualTesting vt = new VisualTesting(this.automator.getDriver());
		vt.Capture(newBase, test, "viewport_page_ignore.png",By.tagName("h1"));
	
	}
}