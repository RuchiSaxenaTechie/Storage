package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test9 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Hotels")).click();
		Thread.sleep(1000);
		driver.close();

	}

}
