package seleniunpackage;

import java.io.File;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

public class Test50 {

	public static void main(String[] args) {
		
		//GET TEST DATA SIZE
		HashMap<String,String> pwds=new HashMap<String,String>(); 
		Scanner sc=new Scanner(System.in);
		System.out.println("enter test data size");
		int noi = Integer.parseInt(sc.nextLine());
		for(int i=0;i<noi;i++)
		{
			System.out.println("enter pwd");
			String x=sc.nextLine();
			System.out.println("enter pwd criteria");
			String y=sc.nextLine();
			pwds.put(x, y);
		}
			//create html reports file
			ExtentReports er=new ExtentReports("gmailddt.html",false);
			ExtentTest et=er.startTest("gmail pwd testing");
		
			//data driven testing
		ChromeDriver driver=null;
		
			for(Map.Entry<String,String> e:pwds.entrySet())
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
					//enter valid user id and click next
					driver.findElement(By.name("identifier")).sendKeys("ruchisaxena028");
					w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Next']")));
					driver.findElement(By.xpath("//*[text()='Next']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
					//enter password & click
					driver.findElement(By.name("password")).sendKeys(e.getKey());
					w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text(),'Next']")));
					driver.findElement(By.xpath("//*[text(),'Next']")).click();
					Thread.sleep(5000);
					//validations
					if(e.getKey().length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Enter an email')]")).isDisplayed())
					{
						et.log(LogStatus.PASS,"blank pswd test passed");
					}
					else if (e.getKey().equalsIgnoreCase("invalid") && driver.findElement(By.xpath("(//*[contains(text(),' find your Google Account')])[2]")).isDisplayed() )
					{
						et.log(LogStatus.PASS,"invalid pswd test passed ");
					}
					else if(e.getKey().equalsIgnoreCase("valid") && driver.findElement(By.name("password")).isDisplayed())
					
					{
						et.log(LogStatus.PASS,"valid pswd test passed ");	
					}
					else 
					{
						SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
						Date d=new Date();
						String fname=sf.format(d)+".png";
						File src=driver.getScreenshotAs(OutputType.FILE);
						File dest=new File(fname);
						FileHandler.copy(src,dest);
						et.log(LogStatus.FAIL,"PSWD TEST FAILED "+et.addScreenCapture(fname));
					}
					driver.close();
				}
					catch(Exception ex) { driver.close();
					et.log(LogStatus.ERROR,ex.getMessage());
					}
			}
			//save results
			er.endTest(et);
			er.flush();
	}
}
						
				



