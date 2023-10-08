package pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import automation.VisualTesting;
import automation.WebAutomator;

public class VerHabilidades {
	//Driver
	private WebAutomator automator;
	private VisualTesting vt;
	private String newBase;
	private ExtentTest test;
	private By verHab = By.xpath("//span[text()='Ver habilidades']");
	private String hab = "//tr/td/p-celleditor[text()=' intercambio ']";
		
	public VerHabilidades(WebAutomator a,ExtentTest test,VisualTesting vt,String newBase){
		this.automator = a;
		this.newBase=newBase;
		this.test = test;
		this.vt = vt;
	}
	
	public void ver(String habilidad) throws InterruptedException {
		this.automator.waitUntilVisible(verHab).click();
		Thread.sleep(4000);
		vt.Capture(newBase, test, "verHabilidades.png");
		Thread.sleep(3000);

	}
	
}