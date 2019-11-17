package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Test34 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		// for locating desired data in search box,it will take some time
		WebDriverWait w = new WebDriverWait(driver, 500);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		// search for a video
		driver.findElement(By.id("search")).sendKeys("TOM & JERRY VIDEOS");
		driver.findElement(By.xpath("//*[@id='search-icon-legacy']/yt-icon")).click();
		w.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[contains(@title,'Tom & Jerry | Best of Little Quacker ')]")));
		// start video
		driver.findElement(By.xpath("//*[contains(@title,'Tom & Jerry | Best of Little Quacker ')]")).click();
		// pause video(sikulix)
		Screen s = new Screen();
		s.mouseMove(200, 200);// move mouse pointer to video body
		s.click("pause.png");
		// play video
		Thread.sleep(5000);
		s.mouseMove(200, 200);
		s.click("play.png");
		// maximize
		Thread.sleep(5000);
		/*
		 * s.mouseMove(200, 200); s.click("maximize.png");
		 */

		s.wheel(Button.WHEEL_DOWN, 5);
		Thread.sleep(5000);

		s.wheel(Button.WHEEL_UP, 5);
	}
}
	
	

	