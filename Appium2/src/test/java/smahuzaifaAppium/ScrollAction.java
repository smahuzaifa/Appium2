package smahuzaifaAppium;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollAction extends BaseTest{
	 @Test
	 public void ScrollDemo() throws InterruptedException
	 {
		 driver.findElement(AppiumBy.accessibilityId("Views")).click();
		 
		 //Scroll Action 1 : When we know till when the scroll should happen
		 //We will be using google engine now to scroll in our app
//		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
//		 		+ ".scrollIntoView(text(\"Web View\"))"));
		 /*
		  * In google engine, to scroll we use UiSelector class
		  * We have to create object for the class and that class expects and argument called UiSelector
		  * In the UiSelector class we have a method called scollIntoView that accepts argument text.
		  * This text is the part of screen till which the app must scroll
		  */
		 
		 //Scroll Action 2: When we don't know up to which extent the scroll should happen
		 scrollToEndAction();
		 
		 //Have made common method for this too in base test
//		 boolean canScrollMore;
//		 do 
//		 {
//			  canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
//					 ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200,
//					    "direction", "down", //Direction is mandatory
//					    "percent", 3.0));
//		 }while(canScrollMore);
		 //If there is still scope to scroll then it will return true, this will continue till the return is false
		 //as long as canScrollMore is true the do loop will execute
		 
	 }

}
