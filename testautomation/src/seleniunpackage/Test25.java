package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test25 {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.telerik.com/products/aspnet-ajax/calendar.aspx");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("(//*[@class='js-reveal'])[1]"));
	
			

	}

}
