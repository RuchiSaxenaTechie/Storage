package seleniunpackage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.guide.ClickableWindow;

public class Test36 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.sentia.in");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[contains(@src,'pay_online.jpg')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[contains(@href,'transportfeesentia1')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[contains(@href,'paymentOptionsGroup')])[3]")).click();
		Thread.sleep(1000);
		// get browser windows tabs handles
		ArrayList<String> a = new ArrayList<String>(driver.getWindowHandles());
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
		// switch to 2nd window/tab and close
		driver.switchTo().window(a.get(1));

		driver.close();
		// switch to 3rd window/tab and close
		driver.switchTo().window(a.get(2));
		driver.close();

	}

}
