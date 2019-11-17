package seleniunpackage;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test47calender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(
				"https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		driver.manage().window().maximize();
		//giving wait condition for selecting table/portion of calender 
		WebDriverWait w=new WebDriverWait(driver,10);
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='calendarContainer']")));
		 //select the date
		 driver.findElement(By.linkText("22")).click();
		 //wait for (bubble) load completion
		 w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='raDiv']")));
		 driver.close();
		 
	}
}
