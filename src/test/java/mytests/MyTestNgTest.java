package mytests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyTestNgTest {

	@Test

	public void myFirstSeleniumTest() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		WebElement formAuthentication = driver.findElement(By.xpath("//*[@id='content']/ul/li[21]/a"));
		formAuthentication.click();

		WebElement usernameField = driver.findElement(By.xpath("//*[@id='username']"));
		usernameField.sendKeys("tomsmith");

		WebElement passwordField = driver.findElement(By.xpath("//*[@id='password']"));
		passwordField.sendKeys("SuperSecretPassword!");

		WebElement login = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		login.click();

		WebElement secureArea = driver.findElement(By.xpath("//*[@id='content']/div/h2"));
		String headingTest = secureArea.getText();
		if (headingTest.equals("Secure Area")) {
			System.out.println("test pass");
		} else {
			System.out.println("test fail");
		}

		// Assert.assertEquals(headingTest,"SecureArea");//comparing string to string
		// Assert.assertEquals(headingTest.equals("Secure Area"), true);//boolean value
		// tested here
		driver.quit();
	}
}
