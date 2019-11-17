package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test12 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(1000);
		//validate a radio button
		driver.findElement(By.linkText("Flights")).click();
		Thread.sleep(1000);
		try
		{
		if(driver.findElement(By.name("tripType")).isDisplayed())
		{
			System.out.println("Displayed");
			if(driver.findElement(By.name("tripType")).isEnabled())
			{
				System.out.println("Enabled");
			
			if(driver.findElement(By.name("tripType")).isSelected())
			{
				System.out.println("Selected");
			}
			
			else 
			{
				System.out.println("Not selected");
				
			}
		}
			else
			{
			System.out.println("DISABLED");
			}
		}
			else
			{
				System.out.println("Hidden");
			}
	
	}catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
	
	}
}
	
