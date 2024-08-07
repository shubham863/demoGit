package seleniumTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);

		dr.findElement(By.xpath("//*[@id='autosuggest']")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> ls=dr.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement wb:ls) {
			if(wb.getText().equalsIgnoreCase("India")) {
				//Thread.sleep(2000);
				wb.click();
				break;
			}
		}
		Thread.sleep(5000);
		dr.quit();
	}

}
