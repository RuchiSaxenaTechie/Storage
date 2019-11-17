package seleniunpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test24 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		// Get items(invisible) of a dropdown without open
		List<WebElement> il = driver.findElements(By.xpath(""));
		
		System.out.println(il.size());
		for (int i = 0; i < il.size(); i++) {
			driver.executeScript("var x=argument[0].textContent;window.alert(x);", il.get(i));
			// String y=driver.switchTo().alert().dismiss();

		}

	}
}
