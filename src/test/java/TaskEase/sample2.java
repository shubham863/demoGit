package TaskEase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class sample2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "D1AGAD57C0320264");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		cap.setCapability("app", "C:\\Users\\Admin\\Desktop\\apk\\teletrader.apk");
		cap.setCapability("adbExecTimeout", 40000);
		cap.setCapability("newCommandTimeout", 100000);
		//cap.setCapability("newCommandTimeout", 50000);

		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("start");
		AppiumDriver<MobileElement> dr=new AndroidDriver<>(url,cap);
		System.out.println("end");
		Thread.sleep(3000);
		
		MobileElement mb=dr.findElement(MobileBy.id("com.teletrader.android:id/skip"));
		mb.click();
		
    	Thread.sleep(3000);
		MobileElement terms=dr.findElement(MobileBy.id("com.teletrader.android:id/btn_accept"));
		terms.click();

		Thread.sleep(3000);
		MobileElement portfolio=dr.findElement(MobileBy.id("com.teletrader.android:id/tt_footer_navigation_portfolio"));
		portfolio.click();
		
		//Thread.sleep(5000);
		MobileElement dropdown=dr.findElement(MobileBy.id("com.teletrader.android:id/watchlistAndPortfolioNameList"));
		dropdown.click();

		//Thread.sleep(5000);
		MobileElement dropdownele=dr.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ImageView"));
		dropdownele.click();
		
		
		
		MobileElement inputtext=dr.findElement(MobileBy.id("com.teletrader.android:id/tt_inputNewPortfolio"));
		inputtext.click();
		inputtext.setValue("shubham");
		
		MobileElement cntlist=dr.findElement(MobileBy.id("com.teletrader.android:id/tt_createPortfolioCurrency"));
		cntlist.click();
		
		List<MobileElement> country=dr.findElements(MobileBy.id("android:id/contentPanel"));
		for(MobileElement ele:country) {
			if(ele.getText().equals("USD")) {
				ele.click();
			}
		}
	
		
		MobileElement checkbox=dr.findElement(MobileBy.xpath("com.teletrader.android:id/agregateCB"));
		checkbox.click();
		
		MobileElement inputnum=dr.findElement(MobileBy.xpath("com.teletrader.android:id/tt_portfolioCreateValue"));
		inputnum.click();
		inputnum.setValue("1000");
		
		
		
		
		
		
		
		
		
		
	}

}
