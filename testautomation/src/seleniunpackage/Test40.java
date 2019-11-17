package seleniunpackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test40 {

	public static void main(String[] args) throws Exception {
		// launch gmail site
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/gmail/");
		driver.manage().window().maximize();
		// do login
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.findElement(By.name("identifier")).sendKeys("ruchisaxena028");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Next')])[2]")));
		driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("summer@2");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Next')])[2]")));
		driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
		// compose
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Compose')])[1]")));
		driver.findElement(By.xpath("(//*[contains(text(),'Compose')])[1]")).click();
		driver.findElement(By.name("to")).sendKeys("ankursaxena.151@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("suggestion");
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[contains(@aria-label,'Message Body')])[2]")));
		driver.findElement(By.xpath("(//*[contains(@aria-label,'Message Body')])[2]")).sendKeys("yo yo bro");
		// attached file
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@id,':17z')])")));
		driver.findElement(By.xpath("(//*[contains(@id,':17z')])")).click();
		Thread.sleep(5000);
		// sending data to clipboard
		StringSelection x = new StringSelection("\"C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg\"");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x, null);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		// send
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@id,':15z')])")));
		driver.findElement(By.xpath("(//*[contains(@id,':15z')])")).click();
		//do logout
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'gb_9a gbii')]")));
		driver.findElement(By.xpath("//*[contains(@class,'gb_9a gbii')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Sign out')]")).click();
		
		
		

	}

}
