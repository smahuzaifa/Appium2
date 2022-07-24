package smahuzaifaAppium;

// import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;

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
		options.setApp("//Users//syedmahmoodaleemhuzaifa//git//Appium2//Appium2//ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		//Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
		//service.stop();
	}
}