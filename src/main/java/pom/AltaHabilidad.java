package pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import automation.VisualTesting;
import automation.WebAutomator;

public class AltaHabilidad {
	//Driver
	private WebAutomator automator;
	private VisualTesting vt;
	private String newBase;
	private ExtentTest test;
	private By crearHabilidad = By.xpath("//a[@href='/etiquetas/crear-etiqueta']");
	private By nombre = By.xpath("//input[@placeholder='Nombre']");
	private By crear = By.xpath("//button[@label='Crear Habilidad']");
		
	public AltaHabilidad(WebAutomator a,ExtentTest test,VisualTesting vt,String newBase){
		this.automator = a;
		this.newBase=newBase;
		this.test = test;
		this.vt = vt;
	}
	
	public void agregar(String habilidad) throws InterruptedException {
		this.automator.waitUntilVisible(crearHabilidad).click();
		Thread.sleep(4000);
		vt.Capture(newBase, test, "crearHabilidad.png");
		Thread.sleep(4000);
		this.automator.waitUntilVisible(nombre).setText(habilidad);
		Thread.sleep(2000);
		this.automator.waitUntilVisible(crear).click();
		Thread.sleep(4000);
		vt.Capture(newBase, test, "habilidadCreada.png");
	}
	
}