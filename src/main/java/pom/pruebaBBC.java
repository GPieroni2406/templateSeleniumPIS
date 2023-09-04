package pom;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automation.VisualTesting;
import automation.WebAutomator;

public class pruebaBBC {
	private By bbcSign = By.cssSelector("#idcta-username");
	private By bbcReg = By.cssSelector("#signin-page > div.sb-layout-wrapper > div > div.sb-account-section.sb-account-section--with-top-border.sb-account-section--centre-aligned-content > a > span");
	private By over = By.cssSelector("#container > div > div.sb-layout-wrapper > div > div > div.sb-account-content-container > div.form > fieldset > div.sb-flex-container > a:nth-child(2)");
	private By dia = By.cssSelector("#day-input");
	private By mes  = By.cssSelector("#month-input");
	private By anio  = By.cssSelector("#year-input");
	private By selec  = By.cssSelector("#submit-button > span");
	private By correo  = By.xpath("//input[@id='user-identifier-input']");
	private By contra  = By.cssSelector("#password-input");
	private By selec2  = By.cssSelector("#submit-button");
	private By foto = By.id("submit-button");
	// Driver
	private WebAutomator automator;

	public pruebaBBC(WebAutomator a) {
		this.automator = a;
	}

	public void registro(String texto,VisualTesting vt, ExtentTest test,String newBase) throws InterruptedException {
		Thread.sleep(2000);
		this.automator.find(bbcSign).click();
		Thread.sleep(2000);
		this.automator.find(bbcReg).click();
		Thread.sleep(2000);
		this.automator.find(over).click();
		Thread.sleep(2000);
		this.automator.find(dia).setText("2");
		Thread.sleep(2000);
		this.automator.find(mes).setText("10");
		Thread.sleep(2000);
		this.automator.find(anio).setText("2000");
		Thread.sleep(2000);
		this.automator.find(selec).click();
		Thread.sleep(6000);
		this.automator.find(correo).setText(texto);
		Thread.sleep(2000);
		this.automator.find(contra).setText("123456");
		Thread.sleep(2000);
		this.automator.find(selec2).click();
		
		WebElement captura = this.automator.find(foto).getWebElement();
		vt.CaptureElem(newBase,captura, test, "bbc.png");
		test.log(Status.INFO, "Capturing page...");
		
		
	

	}

}