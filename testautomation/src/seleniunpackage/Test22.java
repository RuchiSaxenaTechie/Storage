package seleniunpackage;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test22 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver .get("https://www.google.co.in");
		Thread.sleep(1000);
		driver.executeScript("alert('yippee...yahoo')");
		
	}

}
