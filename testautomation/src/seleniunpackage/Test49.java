package seleniunpackage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test49 {

	public static void main(String[] args)  {
		ArrayList<String> uids=new ArrayList<String>();
		ArrayList<String> cs=new ArrayList<String>();
		//GET TEST DATA SIZE
		Scanner sc=new Scanner(System.in);
		System.out.println("enter test data size");
		int noi = Integer.parseInt(sc.nextLine());
		for(int i=0;i<noi;i++)
		{
			System.out.println("enter id");
			uids.add(sc.nextLine());
			System.out.println("enter criteria");
			cs.add(sc.nextLine());
		}
			//create html reports file
			ExtentReports er=new ExtentReports("gmail.html",false);
			ExtentTest et=er.startTest("gmail uid testing");
		
			//data driven testing
		
		ChromeDriver driver=null;
		
			for(int i=0;i<noi;i++)
			{
				try
				{
					//launch site
					System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.get("https://www.gmail.com");
					driver.manage().window().maximize();
					WebDriverWait w=new WebDriverWait(driver,20);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
					driver.findElement(By.name("identifier")).sendKeys(uids.get(i));
					w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
					driver.findElement(By.xpath("//*[text()='Next']")).click();
					Thread.sleep(5000);
					//validations
					if(uids.get(i).length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Enter an email')]")).isDisplayed())
					{
				     et.log(LogStatus.PASS,"blank uid test passed");
					}
					else if (cs.get(i).equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),' find your Google Account')])[2]")).isDisplayed() )
					{
						et.log(LogStatus.PASS,"invalid uid test passed ");
					}
					else if(cs.get(i).equalsIgnoreCase("valid") && driver.findElement(By.name("password")).isDisplayed())
					
					{
						et.log(LogStatus.PASS,"valid uid test passed ");
					}
					else 
					{
						SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
						Date d=new Date();
						String fname=sf.format(d)+".png";
						File src=driver.getScreenshotAs(OutputType.FILE);
						File dest=new File(fname);
						FileHandler.copy(src,dest);
						System.out.println("test failed");
					}
					driver.close();
				}
					catch(Exception ex)
				   { 
						driver.close();
					et.log(LogStatus.ERROR, ex.getMessage());
					}
			}
			//save results
			er.endTest(et);
			er.flush();
						
}
}


