package mytests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		
		
		WebElement formAuthentication=driver.findElement(By.xpath("//*[@id='content']/ul/li[21]/a"));
		formAuthentication.click();
		
		
		WebElement usernameField=driver.findElement(By.xpath("//*[@id='username']"));
		usernameField.sendKeys("tomsmith");
		
		WebElement passwordField=driver.findElement(By.xpath("//*[@id='password']"));
		passwordField.sendKeys("SuperSecretPassword!");
		
		WebElement login= driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		login.click();
		
		
		WebElement secureArea=driver.findElement(By.xpath("//*[@id='content']/div/h2"));
		String headingTest=secureArea.getText();
		if(headingTest.equals("Secure Area")) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		
		//Assert.assertEquals(headingTest,"SecureArea");
		//Assert.assertEquals(headingTest.equals("Secure Area"), true);
		driver.quit();
	}

}
