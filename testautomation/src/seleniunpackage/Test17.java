package seleniunpackage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test17 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver.get("http://www.sentia.in/");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@src,'pay_online.jpg')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[contains(text(),'Transport')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[contains(@class,'btn btn-default')])[3]")).click();
		Thread.sleep(1000);
		//get browser windows/tabs handles
		ArrayList<String> a=new ArrayList<String>(driver.getWindowHandles());
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
			}
		//get 2nd browser windows/tabs handles
		driver.switchTo().window(a.get(1));
		driver.close();
		Thread.sleep(1000);
		//get 1st browser windows/tabs handles
				driver.switchTo().window(a.get(0));
				driver.close();
				Thread.sleep(1000);
				//get 3rd browser windows/tabs handles
				driver.switchTo().window(a.get(2));
				driver.close();
				Thread.sleep(1000);
		
		
		
		
		

	}

}
