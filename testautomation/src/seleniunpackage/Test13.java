package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test13 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.get("www.way2sms.com/");
		Thread.sleep(1000);
		// Get Attribute value
		WebElement e = driver.findElement(By.name("mobileNo"));
		String x = e.getAttribute("id");
		System.out.println(x);
		Thread.sleep(1000);
		// Get text value and css property value
		WebElement e1 = driver.findElement(By.name("mobileNo"));
		String y = e1.getAttribute("id");
		System.out.println(y);

	}

}
