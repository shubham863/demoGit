package TaskEase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class settingPasswordTestCase {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("deviceName", "[2409:4040:e05:c930:2422:fdf4:8c4:1ba7]:5555");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		//cap.setCapability("app", "C:\\Users\\Admin\\Desktop\\apk\\teletrader.apk");
		cap.setCapability("appPackage", "com.teletrader.android"); // Replace with your app's package name
        cap.setCapability("appActivity", "com.teletrader.android.TeleTraderStartActivity"); // Replace with the main activity of your app
        //uiautomator2ServerInstallTimeout:80000
		cap.setCapability("adbExecTimeout", 90000);
		cap.setCapability("newCommandTimeout", 50000);

		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("start");
		AppiumDriver<MobileElement> dr=new AndroidDriver<>(url,cap);
		System.out.println("end");
		Thread.sleep(2000);
		
		
		 	int startX = dr.manage().window().getSize().width-3;
		 	//startX=startX+2;
	        int endX = dr.manage().window().getSize().width;
	        endX=endX-endX+3;
	        int centerY = dr.manage().window().getSize().height / 2;
	        Thread.sleep(1000);	        //forward
	        for(int i=0;i<=8;i++) {
	        	TouchAction touchAction = new TouchAction(dr);
		        touchAction.press(PointOption.point(startX, centerY))
		                .moveTo(PointOption.point(endX, centerY))
		                .release()
		                .perform();	
		        Thread.sleep(200);
				System.out.println(i+"  ");

	        }
	        
			System.out.println("end1");
			//backward
//			for(int i=0;i<6;i++) {
//	        	TouchAction touchAction = new TouchAction(dr);
//		        touchAction.press(PointOption.point(endX, centerY))
//		                .moveTo(PointOption.point(startX, centerY))
//		                .release()
//		                .perform();	
//		        Thread.sleep(1000);
//	        }
			
	        Thread.sleep(1000);
	        Dimension size = dr.manage().window().getSize();
	        int startx = size.getWidth() / 2;
	        int starty = (int) (size.getHeight() * 0.8);
	        int endy = (int) (size.getHeight() * 0.2);
	        //Thread.sleep(2000);
	        TouchAction touchAction = new TouchAction<>(dr);
	        for(int i=0;i<10;i++) {
	        	  touchAction.press(PointOption.point(startx, starty))
	                .moveTo(PointOption.point(startx, endy))
	                .release()
	                .perform();
	        	  Thread.sleep(1000);
					System.out.println(i+"  ");

	        }
	        Thread.sleep(1000);
	        
	        int centerWidth = size.getWidth() / 2;
	        int centerHeight=size.getHeight()/2;
	        int starty1 = (int) (size.getHeight() * 0.8); // 75% from the bottom (25% from the top)
	        int endy1 = (int) (size.getHeight() * 0.2);   // 65% from the top (35% from the bottom)

	        TouchAction touchAction1 = new TouchAction<>(dr);
	        for (int i = 0; i < 40; i++) {
	            touchAction1.press(PointOption.point(centerWidth,centerHeight-200))
	                       .moveTo(PointOption.point(centerWidth,centerHeight+200))
	                       .release()
	                       .perform();
	            Thread.sleep(1000);
	        }

	        
		MobileElement terms=dr.findElement(MobileBy.id("com.teletrader.android:id/btn_accept"));
		terms.click();
//		MobileElement dropdown=dr.findElement(MobileBy.id("com.teletrader.android:id/btn_accept"));
//		terms.click();
		dr.quit();
		//h-1280
		//w-720
		//startx-320at center
		//startY- 1024
		//endY-256
	}

}




























