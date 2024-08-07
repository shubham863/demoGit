package dess;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Dess {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "D1AGAD57C0320264");
		//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		cap.setCapability("adbExecTimeout", 80000);
		//cap.setCapability("newCommandTimeout", 100000);
		cap.setCapability("appPackage", "com.dess.ddmdessmeetings");
		cap.setCapability("appActivity", "com.dess.dms.MainActivity");
		//cap.setCapability("newCommandTimeout", 50000);
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("start1");
		AppiumDriver<MobileElement> dr=new AndroidDriver<>(url,cap);
		System.out.println("end");
		
	}

}
