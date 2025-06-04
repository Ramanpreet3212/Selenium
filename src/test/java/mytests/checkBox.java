package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class checkBox {

	@Test

	public void testCheckbox() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		WebElement checkBox = driver.findElement(By.xpath("//*[@id='content']/ul/li[6]/a"));
		checkBox.click();

		WebElement tick = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
		tick.click();
		/*
		 * WebElement tick2=
		 * driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
		 * tick2.click();
		 */

		WebElement letter = driver.findElement(By.xpath("//*[@id='page-footer']/div/div"));
		String text = letter.getText();
		if (text.equals("Powered by Elemental Selenium")) {
			System.out.println("test pass");
		} else {
			System.out.println("test failed");
		}

		driver.quit();
	}
}
