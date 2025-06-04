package mousebehaviour;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyboardMouseActions extends baseclass {

	@Test(priority=0)

	public void mouseActions() {

		driver.findElement(By.linkText("Form Authentication")).click();
		WebElement username = driver.findElement(By.id("username"));
		Actions myKeys = new Actions(driver);
		Action act = myKeys.click(username).keyDown(Keys.SHIFT).sendKeys("tomsmith").keyUp(Keys.SHIFT).doubleClick()
				.contextClick().build();

		act.perform();
		System.out.println("Hello!!");
	}

	@Test(priority=1)
	public void dragAndDrop() {
		
		driver.findElement(By.linkText("Drag and Drop")).click();
		WebElement sourceA=driver.findElement(By.id("column-a"));
		WebElement targetB=driver.findElement(By.id("column-b"));
		
		Actions actions= new Actions(driver);
		actions.dragAndDrop(sourceA,targetB).build().perform();
		String elementIncolumnA=driver.findElement(By.id("column-a")).getText();
		Assert.assertEquals(elementIncolumnA, "B");
	}
}
