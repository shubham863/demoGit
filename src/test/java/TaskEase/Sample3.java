package TaskEase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Sample3 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\seleniumWebdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");

		//WebDriver driver=new ChromeDriver();
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "[2405:204:38e:cdad:ecaf:187e:3d3a:b04d]:5555");
		//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		cap.setCapability("adbExecTimeout", 80000);
		//cap.setCapability("newCommandTimeout", 100000);
		cap.setCapability("appPackage", "com.teletrader.android");
		cap.setCapability("appActivity", "com.teletrader.android.TeleTraderStartActivity");
		//cap.setCapability("newCommandTimeout", 50000);
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("start");
		AppiumDriver<MobileElement> dr=new AndroidDriver<>(url,cap);
		System.out.println("end");
		Thread.sleep(10000);
		
		MobileElement mb=dr.findElement(MobileBy.id("com.teletrader.android:id/skip"));
		mb.click();

    	Thread.sleep(3000);
		MobileElement terms=dr.findElement(MobileBy.id("com.teletrader.android:id/btn_accept"));
		terms.click();

		Thread.sleep(10000);
		MobileElement terms1=dr.findElement(MobileBy.id("com.teletrader.android:id/mainMenuImageView"));
		//terms1.click();
		TouchAction tc=new TouchAction(dr);
		tc.tap(TapOptions.tapOptions().withElement(ElementOption.element(terms1))).perform();
		Thread.sleep(3000);

        Dimension size = dr.manage().window().getSize();
		int heightHalf=size.height/2;
        int wid=size.width/2;
        for(int i=0;i<=2;i++) {
        	tc.press(PointOption.point(wid,heightHalf+200))
            .moveTo(PointOption.point(wid,heightHalf-10))
            .release()
            .perform();
        	Thread.sleep(1000);
        }
        MobileElement yt=dr.findElement(MobileBy.id("com.teletrader.android:id/baha_twitter_icon"));
        yt.click();
        Thread.sleep(10000);
//        String context = dr.getContextHandles().stream()
//                .filter(c -> c.toString().contains("WEBVIEW"))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException("No webview context found"));
//        dr.context(context);
//        Thread.sleep(2000);
//        System.out.println(dr.getTitle());
		
	}

}










