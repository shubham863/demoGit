package TaskEase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class sample1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "[2401:4900:517e:84a9:521d:3264:622f:ed2f]:5555");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		cap.setCapability("app", "C:\\Users\\Admin\\Desktop\\apk\\teletrader.apk");
		cap.setCapability("adbExecTimeout", 40000);
		cap.setCapability("newCommandTimeout", 60000);
		//cap.setCapability("newCommandTimeout", 50000);

		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("start");
		AppiumDriver<MobileElement> dr=new AndroidDriver<>(url,cap);
		System.out.println("end");
		Thread.sleep(5000);
		
		MobileElement mb=dr.findElement(MobileBy.id("com.teletrader.android:id/skip"));
		mb.click();
		
    	Thread.sleep(3000);
		MobileElement terms=dr.findElement(MobileBy.id("com.teletrader.android:id/btn_accept"));
		terms.click();
    	
		Thread.sleep(5000);
		MobileElement threeDotsButton = dr.findElement(MobileBy.id("com.teletrader.android:id/tt_options_menu_button"));
		TouchAction touchAction = new TouchAction(dr);
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(threeDotsButton))).perform();
  	
		
//		Thread.sleep(3000);
//		MobileElement drop=dr.findElement(MobileBy.id("com.teletrader.android:id/tt_options_menu_button"));
//		drop.click()

		

	}

}
