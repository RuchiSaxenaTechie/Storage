package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test16 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver.get("http://jqueryui.com/checkboxradio/");
		Thread.sleep(1000);
		//switch to frame
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//*[@class='ui-checkboxradio-icon-space'])[1]/preceding-sibling::*")).click();
		driver.findElement(By.xpath("(//*[@class='ui-checkboxradio-icon-space'])[7]/preceding-sibling::*")).click();
		//back to page
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		//close site
		driver.close();
		
		
		
		
		

	}

}
