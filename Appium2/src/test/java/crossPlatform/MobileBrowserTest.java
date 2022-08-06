package crossPlatform;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BasicTest{
	@Test
	public void BrowserTest() throws InterruptedException {
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		System.out.println(driver.getTitle());
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[routerlink='/products']")).click();
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
		String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(text, "Devops");
	}

}
