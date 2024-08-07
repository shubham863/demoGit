package TaskEase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "[2409:4040:d1d:16c8:9406:20f8:44ed:d9fa]:5555");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		//cap.setCapability("app", "C:\\Users\\Admin\\Desktop\\apk\\teletrader.apk");
		cap.setCapability("appPackage", "com.google.android.calculator"); // Replace with your app's package name
        cap.setCapability("appActivity", "com.android.calculator2.Calculator"); // Replace with the main activity of your app

		cap.setCapability("adbExecTimeout", 90000);
		//cap.setCapability("newCommandTimeout", 50000);

		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("start");
		AppiumDriver<MobileElement> dr=new AndroidDriver<>(url,cap);
		System.out.println("end");
		Thread.sleep(5000);
		dr.quit();
	}

}
