package pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automation.VisualTesting;
import automation.WebAutomator;

public class PruebaGoogle {
	private By buscadorGoogle = By.id("APjFqb");
	private By buscadorJavatpoint = By.className("gsc-input");
	private By primerEntrada = By.xpath("//a[contains(@href, 'javatpoint')]");
	
	// Driver
	private WebAutomator automator;

	public PruebaGoogle(WebAutomator a) {
		this.automator = a;
	}

	public void buscarEnGoogle(String texto,VisualTesting vt, ExtentTest test,String newBase, WebDriver d) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(d, 10);
		
		this.automator.find(buscadorGoogle).setText(texto);
		this.automator.find(buscadorGoogle).submit();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3")));
		this.automator.find(primerEntrada).click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(buscadorJavatpoint));
		/*Thread.sleep(6000);
		this.automator.getDriver().findElement(buscadorJavatpoint).sendKeys("hola");
		this.automator.getDriver().findElement(buscadorJavatpoint).submit();
		Thread.sleep(10000);*/
		
		vt.Capture(newBase, test, "capturaJavatpoint.png");
		test.log(Status.INFO, "Capturing page...");
	}

}
