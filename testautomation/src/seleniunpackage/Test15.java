package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test15 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert3");
			Thread.sleep(1000);
			driver.switchTo().frame("iframeResult");
			driver.findElement(By.xpath("(//*[contains(text(),'Try it')])[2]")).click();
			Thread.sleep(1000);
			
			
			
		
		

	}

}
