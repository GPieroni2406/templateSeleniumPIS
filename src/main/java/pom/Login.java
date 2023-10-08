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

public class Login {
	//Driver
	private WebAutomator automator;
	private VisualTesting vt;
	private String newBase;
	private ExtentTest test;
	
	private By buttonIniciar = By.xpath("//span[text()='Iniciar sesión']");
	private By email = By.id("inputEmail");
	private By password = By.id("inputPassword");
	private By buttonIngresar = By.xpath("//button[@label='Ingresar']");
	
	public Login(WebAutomator a,ExtentTest test,VisualTesting vt,String newBase){
		this.automator = a;
		this.newBase=newBase;
		this.test = test;
		this.vt = vt;
	}
	
	public void Loguearse(String user,String pass) throws InterruptedException {
		this.automator.waitUntilVisible(buttonIniciar).click();
		this.automator.waitUntilVisible(email).setText(user);
		this.automator.waitUntilVisible(password).setText(pass);
		this.automator.waitUntilVisible(buttonIngresar).click();
		Thread.sleep(5000);
		vt.Capture(newBase, test, "home.png");
	}
	
}