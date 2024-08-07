package seleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "C:\\seleniumWebdriver\\FirefoxDriver\\geckodriver-v0.34.0-win32\\geckodriver.exe");
		WebDriver dr=new ChromeDriver();
		dr.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement drop=dr.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select sc=new Select(drop);
		sc.selectByIndex(2);
		System.out.println(sc.getFirstSelectedOption().getText());
		sc.selectByValue("USD");
		System.out.println(sc.getFirstSelectedOption().getText());
		sc.selectByVisibleText("INR");
		System.out.println(sc.getFirstSelectedOption().getText());
		
		
	}

}
