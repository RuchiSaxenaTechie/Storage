package seleniunpackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test18 {

	public static void main(String[] args)throws Exception{
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver .get("https://www.google.co.in");
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('lst-ib').click();");
		Thread.sleep(1000);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("document.getElementById('lst-ib').value='chicken tikka';");
		Thread.sleep(1000);
		JavascriptExecutor jf=(JavascriptExecutor)driver;
		Thread.sleep(1000);
		jf.executeScript("document.getElementById('lst-ib').style.border='2px solid green';");
		Thread.sleep(1000);
	}

}
