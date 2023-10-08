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

public class AltaEstudiante {
	//Driver
	private WebAutomator automator;
	private VisualTesting vt;
	private String newBase;
	private ExtentTest test;
	
	private By registrarse = By.xpath("//span[text()='Registrarse']");
	private By nom = By.id("Nombre");
	private By apell = By.id("Apellido");
	private By email = By.id("email");
	private By password = By.xpath("//input[@placeHolder='Contraseña']");
	private By confirmPassword = By.xpath("//input[@placeHolder='Verificar contraseña']");
	private By selectCarrera = By.id("carreras");
	private By crearUsuario = By.xpath("//button[@label='Crear Usuario']");
	
	public AltaEstudiante(WebAutomator a,ExtentTest test,VisualTesting vt,String newBase){
		this.automator = a;
		this.newBase=newBase;
		this.test = test;
		this.vt = vt;
	}
	
	public void registrar(String mail,String pass, String nombre, String apellido,String carrera) throws InterruptedException {

		this.automator.waitUntilVisible(registrarse).click();
		//Thread.sleep(5000);
		this.automator.waitUntilVisible(email).setText(mail);
		//Thread.sleep(2000);
		this.automator.waitUntilVisible(nom).setText(nombre);
		//Thread.sleep(2000);
		this.automator.waitUntilVisible(apell).setText(apellido);
		//Thread.sleep(2000);
		this.automator.waitUntilVisible(password).setText(pass);
		//Thread.sleep(2000);
		this.automator.waitUntilVisible(confirmPassword).setText(pass);
		//Thread.sleep(2000);
		this.automator.waitUntilVisible(crearUsuario).click();
		Thread.sleep(8000);
		vt.Capture(newBase, test, "RegistroUsuario.png");
	}
	
}