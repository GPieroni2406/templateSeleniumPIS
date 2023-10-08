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


public class AltaHabilidadTest extends TestBase {
	
	@Test(enabled = true)
	@Parameters({"host","newBase","user","pass","habilidad"})
	public void altaHabilidad(String host,String newBase,String user,String pass,String habilidad) throws IOException, InterruptedException {
		setExtent("Login"); //Seteamos nombre del reporte.
		test.log(Status.INFO, "Directing to the website:"+ host);
		this.automator.goTo(host);
		this.automator.maximizeWindows();
		
		test.log(Status.INFO, "Capturing page...");
		VisualTesting vt = new VisualTesting(this.automator.getDriver());
		
		vt.Capture(newBase, test, "Home.png");
	
		Login l = new Login(automator, test, vt, newBase);
		l.Loguearse(user, pass);
		Thread.sleep(3000);
		AltaHabilidad ah = new AltaHabilidad(automator, test, vt, newBase);
		ah.agregar(habilidad);

		this.automator.closeAll();
	}
	
}