package windowhandles;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseClass {

	WebDriver driver;

	@BeforeMethod
	public void initialise() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows#google_vignette");
		

	}

	@AfterMethod
	public void quit() {
		driver.quit();

	}

}
