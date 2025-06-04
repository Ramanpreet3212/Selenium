package browsernavigations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dropAndDown {
	@Test

	public void testDropAndDown() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

		WebElement dropDownEle = driver.findElement(By.xpath("//*[@id='dropdown']"));

		Select dropDown = new Select(dropDownEle);
		dropDown.deselectByVisibleText("Option 1");
		// dropDown.selectByValue("2");
		// dropDown.selectByIndex(1);
		WebElement option1 = driver.findElement(By.xpath("//*[@id='dropdown']/option[2]"));
		String attributeValue = option1.getDomAttribute("selected");
		Assert.assertEquals(attributeValue, "true");

		driver.quit();

	}

}
