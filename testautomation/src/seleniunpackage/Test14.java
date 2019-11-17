package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test14 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.way2sms.com");
		Thread.sleep(1000);
		//get attribute value
		driver.findElement(By.name("mobileNo")).sendKeys("8801829241");
		driver.findElement(By.name("password")).sendKeys("summer@2");
/*		driver.findElementByClassName("btn-theme-sm btn-ls text-uppercase").click();fsedgfvfdhbgfb
*/		
		

	}
	
}
