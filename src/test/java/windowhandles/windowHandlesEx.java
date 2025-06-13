package windowhandles;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class windowHandlesEx {

	@Test
	public void test() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Windows.html");
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();
		Set<String> winset = driver.getWindowHandles();
		String head;
		for (String handle : winset) {
			System.out.println(handle);
			
			if(!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
				head = driver.findElement(By.xpath("//h1[@class='d-1 fw-bold']")).getText();
				Assert.assertEquals(head , "Selenium automates browsers. That's it!");
			}
		}
		
		driver.switchTo().window(parentWindow);
		driver.quit();
	}

}
