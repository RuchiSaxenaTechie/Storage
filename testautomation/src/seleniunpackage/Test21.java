package seleniunpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test21 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		//Scroll to bottom
		driver.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(1000);
		//Scroll to top
				driver.executeScript("window.scrollTo(document.body.scrollHeight,0);");
				Thread.sleep(1000);
				//Scroll to specific element
				WebElement e=driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']"));
						driver.executeScript("arguments[0].scrollIntoView();",e);
						

	}

}
