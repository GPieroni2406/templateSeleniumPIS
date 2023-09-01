package pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automation.VisualTesting;
import automation.WebAutomator;

public class PruebaGoogle {
	private By buscadorGoogle = By.cssSelector("#APjFqb");
	private By imagenGoogle = By.cssSelector("a.LatpMc:nth-child(1) > div:nth-child(1) > span:nth-child(1)");
	private By botonBuscar = By.cssSelector("div.lJ9FBc:nth-child(11) > center:nth-child(2) > input:nth-child(1)");
	// Driver
	private WebAutomator automator;

	public PruebaGoogle(WebAutomator a) {
		this.automator = a;
	}

	public void buscarEnGoogle(String texto,VisualTesting vt, ExtentTest test,String newBase) throws InterruptedException {
		this.automator.find(buscadorGoogle).setText(texto);
		Thread.sleep(2000);
		this.automator.find(botonBuscar).click();
		Thread.sleep(2000);
		vt.CaptureElem(newBase, this.automator.find(imagenGoogle).getWebElement(), test, "capturaImagen.png");
		test.log(Status.INFO, "Capturing page...");
		
	

	}

}
