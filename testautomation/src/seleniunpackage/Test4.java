package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver .get("http://www.gmail.com");
		//Do login
				driver.findElement(By.name("identifier")).sendKeys("ruchisaxena028");
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(5000);
				driver.findElement(By.name("password")).sendKeys("summer@2");
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(1000);
				//Click compose
				driver.findElement(By.xpath("//*[@class='T-I J-J5-Ji T-I-KE L3']")).click();	
				Thread.sleep(1000);
				//Fill compose
				driver.findElement(By.name("to")).sendKeys("ankursaxena.151@gmail.com");
						driver.findElement(By.name("subjectbox")).sendKeys("automation");
						driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Hi dear..I am sending this mail via automation...yippeee");
						Thread.sleep(1000);
						driver.findElement(By.xpath("(//*[@class='T-I J-J5-Ji aoO T-I-atl L3'])")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//*[contains(@aria-label,'Google Account')]/span")).click();
						driver.findElement(By.linkText("Sign out")).click();
						Thread.sleep(1000);
						//CLOSE SITE
						driver.close();
						
						
						
						
						
				
				
						

	}

}
