package seleniunpackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test19 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver .get("https://www.google.co.in");
		Thread.sleep(1000);
		JavascriptExecutor jf=(JavascriptExecutor)driver;
		jf.executeScript("document.getElementById('lst-ib').style.border='2px dotted red';");
		Thread.sleep(1000);

	}

}
