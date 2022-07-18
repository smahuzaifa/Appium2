package smahuzaifaAppium;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumBasics {
	@Test
	public void AppiumBasics() throws MalformedURLException
	{
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 5");
		options.setApp("//Users//syedmahmoodaleemhuzaifa//eclipse-workspace//Appium2//src//test//java//resources//ApiDemos-debug.apk");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
	}
}
