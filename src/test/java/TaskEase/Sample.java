package TaskEase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
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

public class Sample {

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
		//cap.setCapability("newCommandTimeout", 50000);

		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("start");
		AppiumDriver<MobileElement> dr=new AndroidDriver<>(url,cap);
		System.out.println("end");
		Thread.sleep(2000);
		
		
	
        TouchAction touch=new TouchAction(dr);
        Dimension size = dr.manage().window().getSize();
        int startX = (int) (size.width -3);
        int startY = size.height / 2;
        Thread.sleep(2000);
        int endX = (int) (size.width *0.1);
        for(int i=0;i<=6;i++) {
        	touch.press(PointOption.point(startX, startY))
            .moveTo(PointOption.point(endX, startY))
            .release()
            .perform();
        	Thread.sleep(400);
        }
        for(int i=0;i<=4;i++) {
        	touch.press(PointOption.point(endX, startY))
            .moveTo(PointOption.point(startX, startY))
            .release()
            .perform();
        	Thread.sleep(400);
        }
        for(int i=0;i<=6;i++) {
        	touch.press(PointOption.point(startX, startY))
            .moveTo(PointOption.point(endX, startY))
            .release()
            .perform();
        	Thread.sleep(400);
        }
        
        int heightHalf=size.height/2;
        int wid=size.width/2;
        for(int i=0;i<=6;i++) {
        	touch.press(PointOption.point(wid,heightHalf+150))
            .moveTo(PointOption.point(wid,heightHalf-20))
            .release()
            .perform();
        	Thread.sleep(1000);
        }
        for(int i=0;i<=6;i++) {
        	touch.press(PointOption.point(wid,heightHalf-20))
            .moveTo(PointOption.point(wid,heightHalf+150))
            .release()
            .perform();
        	Thread.sleep(1000);
        }
	 	//System.out.println(startX.getWidth());
        MobileElement terms=dr.findElement(MobileBy.id("com.teletrader.android:id/btn_accept"));
		terms.click();
    	Thread.sleep(5000);
    	
    	
    	
//    	MobileElement threeDotsButton = dr.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ImageView[3]"));
//        TouchAction touchAction = new TouchAction(dr);
//        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(threeDotsButton))).perform();
    	List<MobileElement> icons=dr.findElements(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ImageView"));
//    	int temp=1;
//    	for(MobileElement icon:icons) {
//    		if(temp==3) {
//    			icon.click();
//    		}
//    		temp++;
//    	}
//    
////    	
////		MobileElement drop=dr.findElement(MobileBy.id("com.teletrader.android:id/tt_options_menu_button"));
////		drop.click();
//    	Thread.sleep(1000);
//
//		MobileElement dropElement=dr.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"));
//		dropElement.click();
//        Thread.sleep(3000);

	 	dr.quit();
	 	
	 	
	 	
	 	
	 	
	 	
	 	

	}

}










