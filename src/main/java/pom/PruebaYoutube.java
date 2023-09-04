package pom;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automation.VisualTesting;
import automation.WebAutomator;

public class PruebaYoutube {
	private By buscadorYT = By.id("search");
	private By botonBuscar = By.id("search-icon-legacy");
	// Driver
	private WebAutomator automator;

	public PruebaYoutube(WebAutomator a) {
		this.automator = a;
	}

	public void pruebaBuscar(String busqueda, VisualTesting vt, ExtentTest test,String newBase) throws InterruptedException {
		Thread.sleep(10000);
		WebElement elemento = this.automator.getDriver().findElement(By.id("search"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) this.automator.getDriver();
		jsExecutor.executeScript("arguments[0].textContent = arguments[1];", elemento, busqueda);
		this.automator.find(botonBuscar).click();
		Thread.sleep(5000);
	}

}
