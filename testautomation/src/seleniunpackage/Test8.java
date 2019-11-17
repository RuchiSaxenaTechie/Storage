package seleniunpackage;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test8 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		String x=driver.getCurrentUrl();
		if(x.contains("https"))
		{
			System.out.println("SITE IS SECURED");
			
		}
		else
		{
			System.out.println("SITE IS NOT SECURED");
		}
	}
}


