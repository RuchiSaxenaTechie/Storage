package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test11 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(1000);
		try
		{
			if(driver.findElement(By.name("holiday_category")).isDisplayed())
			{
				System.out.println("Destination is showing");
			}
			else
			{
				System.out.println("Destination is not showing");
			}
				
		}
				catch(Exception ex)
				{
					System.out.println("wrong locator");
				}
			}
	}
