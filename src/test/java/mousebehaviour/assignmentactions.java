package mousebehaviour;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assignmentactions {

	WebDriver driver;

	@Test
	public void actionsAssigment() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://practicesoftwaretesting.com/");

		driver.findElement(By.xpath("//a[@data-test='nav-categories']")).click();
		WebElement move = driver.findElement(By.xpath("//a[text()='Power Tools']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(move).click(move).build().perform();

		WebElement sander = driver.findElement(By.xpath("//input[@value='01JWW3TJ26T60GX29J4E1M6N5Q']"));
		actions.click(sander).perform();

		WebElement random = driver.findElement(By.xpath("//h5[text()=' Random Orbit Sander '] "));
		actions.click(random).perform();

		String orbit = driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div[1]/div[2]/h1")).getText();
		Assert.assertEquals(orbit, "Random Orbit Sander");
		driver.quit();

	}

}
