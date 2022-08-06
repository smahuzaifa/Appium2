package iOSDemoApp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasicTest extends BaseTest {
	@Test
	public void iOSBasicTest() {
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\'Text Entry\']")).click();
		driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTextField\"")).sendKeys("hello world"); //We can use conjunction of multiple attributes using AND
		//Second attribute should be written after first value
		//We can also use BEGINSWITH for case sensitive BEGINSWITH[c] and similarly ENDSWITH
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Confirm / Cancel")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Confirm\"`]")).click();
		
		
	}

}
