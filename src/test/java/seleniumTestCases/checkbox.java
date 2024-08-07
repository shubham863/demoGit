package seleniumTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);

		System.out.println(dr.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
