package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test7 {

	public static void main(String[] args) throws Exception {
		// launch site
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			WebElement e = driver.findElement(By.name("firstname"));
			if (e.isDisplayed()) {
				System.out.println("Displayed");
				if (e.isEnabled()) {
					System.out.println("Enabled");
					if (e.isSelected()) {
						System.out.println("Selected");

					} else {
						System.out.println("Not Selected");
					}
				} else {
					System.out.println("Disabled");
				}
			} else {
				System.out.println("Hidden");
			}
		}

		catch (Exception ex) {
			System.out.println("Exception");
		}
	}
}