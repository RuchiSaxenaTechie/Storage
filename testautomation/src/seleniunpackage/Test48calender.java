package seleniunpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Test48calender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(
				"https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		driver.manage().window().maximize();
		
		FluentWait w=new FluentWait(driver).pollingEvery(2,TimeUnit.SECONDS).withTimeout(10,TimeUnit.SECONDS);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='rcMainTable']")));
		driver.findElement(By.linkText("22")).click();
		//wait for (bubble) load completion
		 w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='raDiv']")));
		 driver.close();

	}

}
