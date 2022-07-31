package smahuzaifaAppium;

//import java.io.File;
import java.net.MalformedURLException;
//import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscellaneousAppiumActions extends BaseTest {
	@Test
	public void Miscellaneous() throws MalformedURLException, InterruptedException
	{
		//ConfigureAppium();
		//Since @BeforeClass is mentioned in the parent class we do not have to call the method
			//as TestNG will automatically run BeforeClass method first
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		/*
		 * AppiumBy should be used for accessibility id and androiUIAutomator
		 */
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		
		//To change screen orientation
		DeviceRotation landScape = new DeviceRotation(0,0,90);
		driver.rotate(landScape);
		 
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alerttitle= driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(alerttitle);
		Assert.assertEquals(alerttitle, "WiFi settings");
		
		//copy paste
		//copy to clipboard - paste it to clipboard
		driver.setClipboardText("ABCD");
	
		//This code will compare app that has got from app and the actual
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		//Android Keys
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//driver.findElement(By.id("android:id/button1")).click();
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); //This will press Back button of mobile
		driver.pressKey(new KeyEvent(AndroidKey.HOME)); //This will press Home Button of mobile
		Thread.sleep(4000);
		//Can be used when only class name is present and multiple instances of same class is present
		//tearDown(); //Similar to Before class we are using AfterClass here
		 
	}
}
