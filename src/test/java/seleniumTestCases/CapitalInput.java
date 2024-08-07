package seleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CapitalInput {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.amazon.in/?tag=msndeskabkin-21&ref=pd_sl_5szpgfto9j_e&adgrpid=1320515071595367&hvadid=82532458765178&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=116073&hvtargid=kwd-82533067351416:loc-90&hydadcr=14452_2334185");
		Thread.sleep(2000);
		Actions act=new Actions(dr);
		act.moveToElement(dr.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		Thread.sleep(7000);
		dr.quit();

	}

}
