package smahuzaifaAppium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	//public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
//		AppiumDriverLocalService service = new AppiumServiceBuilder()
//				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//				service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 5");
		options.setApp("//Users//smahuzaifa//git//Appium2//Appium2//ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		//Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
		//service.stop();
	}
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				 ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						 "duration",2000));
	}
	public void scrollToEndAction()
	{
		 boolean canScrollMore;
		 do 
		 {
			  canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
					 ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200,
					    "direction", "down", //Direction is mandatory
					    "percent", 3.0));
		 }while(canScrollMore);
	}
}
