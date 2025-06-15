package windowhandles;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assigWindowHandle extends baseClass {

	@Test
	public void assignment() {
		String winMain = driver.getWindowHandle();
		System.out.println(winMain);
		driver.findElement(By.id("windowButton")).click();
		String win1 = driver.getWindowHandle();
		System.out.println(win1);

		driver.findElement(By.id("windowButton")).click();
		String win2 = driver.getWindowHandle();
		System.out.println(win2);

		driver.findElement(By.id("windowButton")).click();
		String win3 = driver.getWindowHandle();
		System.out.println(win3);

		Set<String> windowSet = driver.getWindowHandles();
		String window;
		for (String win : windowSet) {
			System.out.println(windowSet);

			if (!win.equals(winMain)) {
				driver.switchTo().window(win);
				window = driver.findElement(By.xpath("//*[@id='browserWindows']/h1")).getText();
				Assert.assertEquals(window, "Browser Windows");
				
			}

			driver.switchTo().window(winMain);
		}

	}

}
