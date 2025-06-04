package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlerts {

	@Test

	public void jsAlert() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		WebElement jsAlert = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button"));
		jsAlert.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		WebElement message = driver.findElement(By.id("result"));
		String messageText = message.getText();
		Assert.assertEquals(messageText, "You successfully clicked an alert");
		driver.quit();

	}

	@Test

	public void jsConfirm() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		String messageText = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(messageText, "You clicked: Ok");

		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();

		alert = driver.switchTo().alert();
		alert.dismiss();

		messageText = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(messageText, "You clicked: Cancel");

		driver.quit();

	}

	@Test
	public void jsPrompt() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("i'm writing text");
		alert.accept();

		String messageText = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(messageText, "You entered: i'm writing text");

		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();

		alert = driver.switchTo().alert();
		alert.dismiss();

		messageText = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(messageText, "You entered: null");
		driver.quit();

	}

}
