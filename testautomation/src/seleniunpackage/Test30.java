package seleniunpackage;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test30 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(1000);
		driver.manage().window().maximize();

	}

}
