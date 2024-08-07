package seleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtons {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "C:\\seleniumWebdriver\\FirefoxDriver\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://rahulshettyacademy.com/dropdownsPractise/");
		dr.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);

		for(int i=0;i<4;i++) {
			dr.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		dr.findElement(By.id("btnclosepaxoption")).click();
		dr.quit();
	}

}
