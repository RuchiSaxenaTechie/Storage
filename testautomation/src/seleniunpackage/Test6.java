package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(1000);
		//Click register link
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(1000);
		//Fill registration page
		driver.findElement(By.name("firstName")).sendKeys("abc");
		driver.findElement(By.name("lastName")).sendKeys("xyz");
		driver.findElement(By.name("phone")).sendKeys("8801828252");
		driver.findElement(By.name("userName")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("asd1");
		driver.findElement(By.name("address2")).sendKeys("dsa2");
		driver.findElement(By.name("city")).sendKeys("kanpur");
		driver.findElement(By.name("state")).sendKeys("uttar pradesh");
		driver.findElement(By.name("postalCode")).sendKeys("202402");
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		s.selectByVisibleText("INDIA");
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abc");
		driver.findElement(By.name("confirmPassword")).sendKeys("abc");
		driver.findElement(By.name("register")).click();
		Thread.sleep(1000);
		driver.close();   
				
		
		
		
	}

}
