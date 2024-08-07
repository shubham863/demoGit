package ExtendReports;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Test1 extends BaseClass{
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		Test1 t1=new Test1();
		t1.setup();
		//t1.tearDown();
		t1.driver.close();
	}

}
