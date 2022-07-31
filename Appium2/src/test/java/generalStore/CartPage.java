package generalStore;

import java.util.List;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class CartPage extends BasicTest {
	@Test
	public void cartPage() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("ABCD");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click(); //Country selector
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click(); //Older one becomes added to cart
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double sum =0;
		for(int i=0;i < count ;i++)
		{
			String amountString = productPrices.get(i).getText();
			//We cannot sum 2 string
			Double price = Double.parseDouble(amountString.substring(1)); //Will exclude $
			sum = sum + price;
		}
		System.out.println("The sum is "+sum);
		String purchaseAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double totalValue = getFormattedAmount(purchaseAmount);
		System.out.println("The final value is "+totalValue);
		Assert.assertEquals(sum, totalValue);
		if(totalValue == sum)
		{
			System.out.println("The price comparasion is correct");
		}
		else {
			System.out.println("Error in calculation");
		}
		driver.findElement(By.className("android.widget.CheckBox")).click();
		WebElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(terms);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(3000);
	}

}
