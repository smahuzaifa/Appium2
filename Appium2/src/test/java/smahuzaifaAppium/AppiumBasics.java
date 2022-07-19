package smahuzaifaAppium;

//import java.io.File;
import java.net.MalformedURLException;
//import java.net.URL;

//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends BaseTest {
	@Test
	public void WifiSettingName() throws MalformedURLException, InterruptedException
	{
		//ConfigureAppium();
		//Since @BeforeClass is mentioned in the parent class we do not have to call the method
			//as TestNG will automatically run BeforeClass method first
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		Thread.sleep(2000);
		//tearDown(); //Similar to Before class we are using AfterClass here
		
	}
}
