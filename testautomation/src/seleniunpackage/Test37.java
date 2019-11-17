package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test37 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[contains(@class,'w3-border-green')])[1]"));
		driver.findElement(By.xpath("//*[contains(text(),'Try it Yourself')])[1]")).click();
		
		
	}
	
}
