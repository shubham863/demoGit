package seleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\seleniumWebdriver\\FirefoxDriver\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);

		dr.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		dr.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
		Thread.sleep(3000);
		dr.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
		dr.findElement(By.xpath("(//a[@class='ui-state-default'])[18]")).click();
		Thread.sleep(10000);
		dr.quit();
	}

}
