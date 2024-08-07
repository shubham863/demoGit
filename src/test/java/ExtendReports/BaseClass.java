package ExtendReports;

import org.testng.annotations.AfterMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
    protected static AppiumDriver driver;

	public static void setup() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "[2401:4900:1d41:787b:3bcc:f5a6:e1e8:acfc]:5555");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		//cap.setCapability("app", "C:\\Users\\Admin\\Desktop\\apk\\teletrader.apk");
		cap.setCapability("appPackage", "com.google.android.calculator"); // Replace with your app's package name
        cap.setCapability("appActivity", "com.android.calculator2.Calculator"); // Replace with the main activity of your app

		cap.setCapability("adbExecTimeout", 90000);
		//cap.setCapability("newCommandTimeout", 50000);

		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("start");
		AppiumDriver<MobileElement> driver=new AndroidDriver<>(url,cap);
		//Thread.sleep(00);
	}
	@AfterMethod
	protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	 

}
