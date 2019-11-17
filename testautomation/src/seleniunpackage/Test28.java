
package seleniunpackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test28 {

	public static void main(String[] args) {
		ChromeOptions o =new ChromeOptions();
		o.addArguments();
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://in.bookmyshow.com/");
		

	}

}
