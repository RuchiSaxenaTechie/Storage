package seleniunpackage;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test26 {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(java.lang.System.in);
		System.out.println("Enter a word");
		String x = s.nextLine();
		// launch a site
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://angularjs.org/");
		driver.manage().window().maximize();

		// wait for page ready
	WebDriverWait w = new WebDriverWait(driver, 50);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@ng-model='yourName']"))).sendKeys(x);
		driver.manage().window().maximize();
		w.until(ExpectedConditions.textToBePresentInElement(By.xpath("(//*[contains(text(),'Hello')])[2]"),
				"Hello " + x + "!"));
		Thread.sleep(5000);
		driver.close();

		s.close();

	}

}
