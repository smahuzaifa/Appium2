package iOSDemoApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
//import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
public IOSDriver driver;
public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, InterruptedException
	{
//		AppiumDriverLocalService service = new AppiumServiceBuilder()
//				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//				service.start();
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 13 Pro Max");
		options.setApp("Users/smahuzaifa/Downloads/Appium File and Folders/IOS Apps/UIKitCatalog.app");
		options.setPlatformVersion("15.2");
		//Appium -> Web driver Agent -> iOS Apps
		//options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		Thread.sleep(1000);
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
		//service.stop();
	}
}
