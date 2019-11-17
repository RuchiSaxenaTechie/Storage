package seleniunpackage;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test33 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumhq.org/");
		WebDriverWait w= new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		driver.manage().window().maximize();
		///right click on link
		WebElement e=driver.findElement(By.linkText("Download"));
		Actions a=new Actions(driver);
		a.contextClick(e).build().perform();
		//automate winmenu(java robot(in jdk))[TO SELECT 2ND OPTION AFTER RIGHT CLICK   
		
		
		Robot r=new Robot();
				for(int i=1; i<=2; i++)
				{
					r.keyPress(KeyEvent.VK_DOWN);
					r.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(1000);
				}
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
				

		
				

	}

}
