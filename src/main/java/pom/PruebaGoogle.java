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
	
	private By botonBuscar = By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b");
	private By primeraOpcion = By.cssSelector("#rso > div.hlcw0c > div > div > div > div > div > div > div > div.yuRUbf > div > a > h3");
	private By primeraOpcion2 = By.cssSelector("#post-53 > div > div > div > section > div > div > div > div.elementor-element.elementor-element-9b95451.elementor-widget.elementor-widget-text-editor > div > p:nth-child(2) > a > span");
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
		this.automator.find(primeraOpcion).click();
		Thread.sleep(2000);
		this.automator.find(primeraOpcion2).click();
		Thread.sleep(2000);
		vt.Capture(newBase, test, "capturaImagen.png");
		test.log(Status.INFO, "Capturing page...");
		
		
	

	}

}
