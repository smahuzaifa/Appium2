package smahuzaifaAppium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{
	 @Test
	 public void LongPressGesture() throws InterruptedException
	 {
		 driver.findElement(AppiumBy.accessibilityId("Views")).click();
		 driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		 driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
		 
		 /* Appium github gestures
		 *  https://appium.io/docs/en/writing-running-appium/android/android-mobile-gestures/
		 * 
		 * mobile: longClickGesture
			This gesture performs long click action on the given element/coordinates. Available since Appium v1.19
			
			Supported arguments:		
			elementId: The id of the element to be clicked. If the element is missing then both click offset coordinates must be provided. If both the element id and offset are provided then the coordinates are parsed as relative offsets from the top left corner of the element.
			x: The x-offset coordinate
			y: The y-offset coordinate
			duration: Click duration in milliseconds. 500 by default. The value must not be negative
			
			Code:
			((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
    		"elementId", ((RemoteWebElement) element).getId()));
		 */
		 WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		 longPressAction(ele);
//		 ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
//				 ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
//						 "duration",2000));
		 String menuText = driver.findElement(By.id("android:id/title")).getText();
		 Assert.assertEquals(menuText, "Sample menu");
		 System.out.println(menuText);
		 Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		 //This will be directly asserting if it is displayed
		
		 
		 Thread.sleep(4000);
		 
		 
	 }

}
 