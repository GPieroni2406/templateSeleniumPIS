package automation;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import config.Config;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.CoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class VisualTesting {
	
	private WebDriver driver;
	private AShot ashot;
	
	private static final org.apache.logging.log4j.Logger 
	logger = LogManager.getLogger(VisualTesting.class);
	
	private String baselineFolder = Config.SCREENSHOT_PATH + "baselines/";
	private String checkpointFolder = Config.SCREENSHOT_PATH + "checkpoints/";
	private String compFolder = Config.SCREENSHOT_PATH + "comparisons/";
	
	//Constructors
	public VisualTesting(WebDriver driver) {
		this.driver = driver;
		this.ashot = new AShot().shootingStrategy(ShootingStrategies.scaling(Config.SCALING_FACTOR));
	}
	
	public VisualTesting(WebDriver driver, ShootingStrategy s, CoordsProvider cp) {
		this.driver = driver;
		this.ashot = new AShot()
				.shootingStrategy(s)
				.coordsProvider(cp);
	}
	
	public void setShootingStrategy(ShootingStrategy s) {
		this.ashot.shootingStrategy(s);
	}
	
	public void setCoordsProvider(CoordsProvider cp) {
		this.ashot.coordsProvider(cp);
	}
	
	//Take Screenshot of an element
	public Screenshot takeElementScreenshot(WebElement e) {
		return this.ashot.takeScreenshot(this.driver, e);
	}
	
	public Screenshot takeScreenshot() {
		return this.ashot.takeScreenshot(this.driver);
	}
	
	//Add element to ignore
	public void addIgnoredElement(By ignoredElem) {
			this.ashot.addIgnoredElement(ignoredElem);
		}
	
	//Add elements to ignore
	public void addIgnoredElements(Set<By> ignoredElems) {
			for (By elem:ignoredElems) {
				this.ashot.addIgnoredElement(elem);
			}
		}

	
	//Save images as Baselines
	public void saveScreenshotAsBaseline(Screenshot s, String name) {
		try {
			ImageIO.write(s.getImage(), "PNG", new File(baselineFolder + name));
		} catch (IOException e) {
			System.out.println("Unable to set Baseline screenshot with name " + name);
		}
	}
	
	//Save images as checkpoint
	public void saveScreenshotAsCheckpoint(Screenshot s, String name) {
		try {
			ImageIO.write(s.getImage(), "PNG", new File(checkpointFolder + name));
		} catch (IOException e) {
			System.out.println("Unable to set screenshot with name " + name);
		}
	}
	
	public void Capture(String newBase,ExtentTest test,String name) {
		Screenshot s = this.takeScreenshot();
		if (newBase.contentEquals("true") || (loadBaseline(name)==null) ) {
			saveScreenshotAsBaseline(s,name);
			test.log(Status.PASS, "The base is created...");
		}
		else {
			saveScreenshotAsCheckpoint(s, name);
			checkScreenshots(loadBaseline(name),loadCheckpoint(name),name,test);
			test.log(Status.PASS, "Checkpoints and comparisons are created!");
		}
	}
	
	public void Capture(String newBase,ExtentTest test,String name,By elem) {//Add ignored element
		Screenshot s;
		if (newBase.contentEquals("true") || (loadBaseline(name)==null) ) {
			s = takeScreenshot();
			saveScreenshotAsBaseline(s,name);
			test.log(Status.PASS, "The base is created...");
		}
		else {
			addIgnoredElement(elem);
			s = takeScreenshot();
			checkScreenshots(loadBaseline(name),s,name,test);
			saveScreenshotAsCheckpoint(s, name);
			test.log(Status.PASS, "Checkpoints and comparisons are created!");
		}
	}
	
	public void Capture(String newBase,ExtentTest test,String name,Set<By> elems) {//Add ignored element
		Screenshot s;
		if (newBase.contentEquals("true") || (loadBaseline(name)==null) ) {
			s = takeScreenshot();
			saveScreenshotAsBaseline(s,name);
			test.log(Status.PASS, "The base is created...");
		}
		else {
			addIgnoredElements(elems);
			s = takeScreenshot();
			checkScreenshots(loadBaseline(name),s,name,test);
			saveScreenshotAsCheckpoint(s, name);
			test.log(Status.PASS, "Checkpoints and comparisons are created!");
		}
	}
	
	public void CaptureElem(String newBase,WebElement elem,ExtentTest test,String name,By ignored) { //Add Ignored Elem
		Screenshot s;
		if (newBase.contentEquals("true")) {
			s = takeElementScreenshot(elem);
			saveScreenshotAsBaseline(s,name);
			test.log(Status.PASS, "Base was overwritten!");
			logger.info("Base was overwritten!");
		}
		else {
			addIgnoredElement(ignored);
			s = takeElementScreenshot(elem);
			checkScreenshots(loadBaseline(name),s,name,test);
			saveScreenshotAsCheckpoint(s,name);
			test.log(Status.PASS, "Checkpoints and comparisons are created!");
			logger.info("Checkpoints and comparisons are created!");
		}
	}
	
	public void CaptureElem(String newBase,WebElement elem,ExtentTest test,String name,Set<By> ignored) { //Add Ignored Elem
		Screenshot s;
		if (newBase.contentEquals("true")) {
			s = takeElementScreenshot(elem);
			saveScreenshotAsBaseline(s,name);
			test.log(Status.PASS, "Base was overwritten!");
			logger.info("Base was overwritten!");
		}
		else {
			addIgnoredElements(ignored);
			s = takeElementScreenshot(elem);
			checkScreenshots(loadBaseline(name),s,name,test);
			saveScreenshotAsCheckpoint(s,name);
			test.log(Status.PASS, "Checkpoints and comparisons are created!");
			logger.info("Checkpoints and comparisons are created!");
		}
	}
	
	public void CaptureElem(String newBase,WebElement elem,ExtentTest test,String name) {
		Screenshot s = this.takeElementScreenshot(elem);
		if (newBase.contentEquals("true")) {
			saveScreenshotAsBaseline(s,name);
			test.log(Status.PASS, "Base was overwritten!");
			logger.info("Base was overwritten!");
		}
		else {
			saveScreenshotAsCheckpoint(s,name);
			checkScreenshots(loadBaseline(name),s,name,test);
			test.log(Status.PASS, "Checkpoints and comparisons are created!");
			logger.info("Checkpoints and comparisons are created!");
		}
	}
	
	// Compares images
	public boolean checkScreenshots(Screenshot baseline, Screenshot checkpoint, String compName,ExtentTest test) {
		System.out.println("Ignored Elements :" + checkpoint.getIgnoredAreas().toString());
		baseline.setIgnoredAreas(checkpoint.getIgnoredAreas()); // set ignored coordinates before comparing for the master screen
		baseline.setCoordsToCompare(checkpoint.getCoordsToCompare()); // set coordinates which are going to be compared for the master screen
		//checks Differences
		ImageDiff diff = new ImageDiffer().makeDiff(baseline, checkpoint);
		if (diff.hasDiff()) {
			test.log(Status.INFO, "there are differences");
			logger.info("there are differences");
			try {
				ImageIO.write(diff.getMarkedImage(), "PNG", new File(compFolder + compName));
				test.log(Status.FAIL, 
	                    "The base image is different to the checkpoint image"
	            ).fail("Expected image:")
	            .fail(MediaEntityBuilder.createScreenCaptureFromPath(baselineFolder+compName).build())
	            .fail("Image obtained:")
	            .fail(MediaEntityBuilder.createScreenCaptureFromPath(checkpointFolder+compName).build())
	            .fail("differences:")
	            .fail(MediaEntityBuilder.createScreenCaptureFromPath(compFolder+compName).build());
				return true;
			} catch (IOException e) {
				System.out.println("Unable to write Diff image with name " + compName);
				return true;
			}
		} else {
			test.log(Status.INFO, "there aren't differences");
			logger.info("there aren't differences");
			return false;
		}
	}
	
	public Screenshot loadBaseline(String name) {
		try {
			return new Screenshot(ImageIO.read(new File(baselineFolder + name)));
		} catch (IOException e) {
			System.out.println("Unable to load baseline image with name " + name);
		}
		return null;
	}
	
	public Screenshot loadCheckpoint(String name) {
		try {
			return new Screenshot(ImageIO.read(new File(checkpointFolder + name)));
		} catch (IOException e) {
			System.out.println("Unable to load checkpoint image with name " + name);
		}
		return null;
	}
	
	/*
	public void compararImagenes(Screenshot checkpoint, String nameScreenshot) throws IOException {
		//Comparar Base vs. Test Screenshots
		String rutaComparacion = Config.SCREENSHOT_PATH +  "/img/" + "comparaciones/";
		
		try {
			Screenshot baseline = new Screenshot(ImageIO.read(new File(nameScreenshot + ".png")));
			baseline.setIgnoredAreas(checkpoint.getIgnoredAreas()); // set ignored coordinates before comparing for the master screen
			baseline.setCoordsToCompare(checkpoint.getCoordsToCompare()); // set coordinates which are going to be compared for the master screen
			
			//Genero diferencias
			ImageDiff diff = new ImageDiffer().makeDiff(baseline, checkpoint);
			ImageIO.write(diff.getMarkedImage(), "PNG", new File(rutaComparacion + nameScreenshot + ".png"));
			if (diff.hasDiff()) { //Lanzo mensaje pero no se frena la ejecucion
				logger.info("Hubo diferencias");
			}
		} catch (Exception e) {
			System.out.println("No hay linea base > se guarda checkpoint como baseline");
			ImageIO.write(checkpoint.getImage(), "PNG", new File( nameScreenshot + ".png"));
			
		}
		
		
	}
	*/

}