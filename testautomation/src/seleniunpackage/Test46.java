package seleniunpackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test46 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter  mobile no.");
		String mobno = sc.nextLine();
		System.out.println("enter  criteria");
		String mobnoc = sc.nextLine();
		System.out.println("enter pswd");
		String pswd = sc.nextLine();
		System.out.println("enter  criteria");
		String pswdc = sc.nextLine();
		// launch site
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.way2sms.com");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		// do login
		driver.findElement(By.name("mobileNo")).sendKeys(mobno);
		driver.findElement(By.name("password")).sendKeys(pswd);
		driver.findElement(By.xpath("(//*[contains(text(),'Login ')])[2]")).click();
		// validations
		if (mobno.length() == 0
				&& driver.findElement(By.xpath("//*[text()='Enter your mobile number'])")).isDisplayed()) 
		   {
			System.out.println("blank mobile no. test passed");
		   }
		else if (mobno.length() < 10 && driver
				.findElement(By.xpath("//*[contains(text(),'Enter valid mobile number')])[1]")).isDisplayed())
		   {
			System.out.println("wrong size mobile no. test passed");
		   }
		else if (pswd.length() == 0
				&& driver.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed()) 
		  {
			System.out.println("blank password test passed");
		 }
		else if (pswdc.equals("invalid")&& driver.findElement(By.xpath("(//*[contains(text(),'Incorrect number or password')])[1]")).isDisplayed())
        {
	     System.out.println("invalid password test passed");
        }
		else if(mobnoc.equals("invalid")&& driver.findElement(By.xpath("(//*[contains(text(),'Enter valid mobile number')])[1]")).isDisplayed())
		{
			 System.out.println("invalid mobno. test passed");	
		}
		else if(mobnoc.equals("valid")&& driver.findElement(By.xpath("//*[text()='Send SMS']")).isDisplayed()) 
		{
		System.out.print("valid data test passed");
		}
		else
		{
			//send screenshot
			SimpleDateFormat sf=new SimpleDateFormat();
			Date d=new Date();
			String fname=sf.format(d)+".png";
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(fname);
			FileHandler.copy(src,dest);
			System.out.println("loggin test failed");
		}	
	//close site
	driver.close();
		}
	}


