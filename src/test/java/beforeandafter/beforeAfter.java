package beforeandafter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class beforeAfter {
	
		WebDriver driver;
		@BeforeMethod
		public void initialise() {
			
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("https://practicesoftwaretesting.com/");
			
		}
		@AfterMethod
		public void endTest() {
			driver.quit();
		}
		@Test
		
		public void signIn(){
			
			driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[4]/a")).click();
			driver.findElement(By.linkText("Register your account")).click();
			WebElement titleText=driver.findElement(By.tagName("h3"));
			String titlename =titleText.getText();
			Assert.assertEquals(titlename, "Customer registration");
			
			
			
			driver.findElement(By.id("first_name")).sendKeys("Ramanpreet");
			driver.findElement(By.id("last_name")).sendKeys("Kaur");
			driver.findElement(By.id("dob")).sendKeys("2025-06-01");
			driver.findElement(By.id("street")).sendKeys("Mississauga");
			driver.findElement(By.id("postal_code")).sendKeys("1abc");
			
			WebElement dropdownEle =driver.findElement(By.id("country"));
			Select dropdown = new Select(dropdownEle);
			dropdown.selectByValue("CA");
			
			driver.findElement(By.id("phone")).sendKeys("123456");
			driver.findElement(By.id("email")).sendKeys("Raman@gmail.com");
			driver.findElement(By.id("password")).sendKeys("Ramanpreet@1");
			
			
			
		}
		
		
		
		
		
	
	

}
