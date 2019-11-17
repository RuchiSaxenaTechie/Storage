package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test20 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver .get("https://www.google.co.in");
		Thread.sleep(1000);
		WebElement e=driver.findElement(By.name("q"));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].setAttribute('disabled','true');",e);
				Thread.sleep(1000);
				js.executeScript("arguments[0].removeAttribute('disabled','true');",e);
				Thread.sleep(1000);

	}

}
