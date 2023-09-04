package screenshotsTests;
import automation.VisualTesting;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import pom.*;
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
		p.buscarEnGoogle("Selenium tutorial for begginers",vt,test,newBase, this.automator.getDriver());
	}
	
	
}