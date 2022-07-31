package generalStore;

import java.net.MalformedURLException;
import java.net.URL;
//import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BasicTest {
	public AndroidDriver driver;
	//public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, InterruptedException
	{
//		AppiumDriverLocalService service = new AppiumServiceBuilder()
//				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//				service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 5");
		options.setApp("//Users//smahuzaifa//git//Appium2//Appium2//General-Store.apk");
		//options.setChromedriverExecutable("Path"); 
		//Use this if webview automation is failing due to chrome driver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
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
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				 "elementId",((RemoteWebElement)ele).getId(), //key value pair on which swipe will be done
				    "direction", direction,
				    "percent", 0.75
				));
	}
	public void dragAction(WebElement ele, int x, int y)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", x,
			    "endY", y
			));
	}
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

}
