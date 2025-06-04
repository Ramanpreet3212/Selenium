package browsernavigations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class browserNavigationsTest {

	@Test

	public void testNavigation() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		//driver.navigate().to("https://the-internet.herokuapp.com/");

		WebElement formAuthentication = driver.findElement(By.linkText("Form Authentication"));
		formAuthentication.click();
		driver.navigate().back();

		WebElement draganddropField = driver.findElement(By.linkText("Drag and Drop"));
		draganddropField.click();
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();

		WebElement title = driver.findElement(By.xpath("//*[@id='content']/div/h3"));
		String titleheading = title.getText();
		Assert.assertEquals(titleheading, "Drag and Drop");
		driver.quit();

	}

}
