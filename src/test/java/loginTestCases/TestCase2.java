package loginTestCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("deviceName", "39ecf2e97d74");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		cap.setCapability("app", "C:\\Users\\Admin\\Desktop\\apk\\linkedin.apk");
		cap.setCapability("adbExecTimeout", 90000);
		//cap.setCapability("newCommandTimeout", 50000);

		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("start");
		AppiumDriver<MobileElement> dr=new AndroidDriver<>(url,cap);
		System.out.println("end");
		Thread.sleep(2000);
		
		
		List<MobileElement> str=dr.findElements(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button"));
	
		for(int i=0;i<str.size();i++) {
				if(str.get(i).getText().equals("Agree & Join")) {
					Thread.sleep(3000);
					str.get(i).click();
					break;
				}
			}
		MobileElement fn=dr.findElement(MobileBy.id("com.linkedin.android:id/growth_join_split_form_first_name"));
		fn.click();
		fn.setValue("UserName");
		dr.findElement(MobileBy.id("com.linkedin.android:id/growth_join_split_form_join_button")).click();
		String errorMessage=dr.findElement(MobileBy.id("com.linkedin.android:id/textinput_error")).getText();
		System.out.println("Message "+errorMessage);
	}

}
