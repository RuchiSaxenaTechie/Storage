package seleniunpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test53 {

	public static void main(String[] args) throws Exception {
		// open file for take data
		File f = new File("way2sms.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		// creat html reports file
		ExtentReports er = new ExtentReports("w2sms.html", false);
		ExtentTest et = er.startTest("w2smslogin testing");
		// data driven testing
		ChromeDriver driver = null;
		String l = "";
		while ((l = br.readLine()) != null) 
		{
			String[] p = l.split(",");
			try
			{
			//launch site
			System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://way2sms.com");
			driver.manage().window().maximize();
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("")));
			driver.findElement(By.name("")).sendKeys(p[0]);
			driver.findElement(By.name("")).sendKeys(p[2]);
			driver.findElement(By.xpath("")).click();
			Thread.sleep(5000);
			//validations
			if (p[0].length()==0 && driver.findElement(By.xpath("")).isDisplayed()) 
			{
			et.log(LogStatus.PASS, "blank mobile no. test passed");	
			}
			else if (p[0].length()<10 && driver.findElement(By.xpath("")).isDisplayed())
			{
				et.log(LogStatus.PASS,"invalid size mobile no. test passed");
			}
			else if (p[1].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("")).isDisplayed()) 
			{
				et.log(LogStatus.PASS,"wrong mobile no. test passed");	
			}
			else if (p[3].length()==0 && driver.findElement(By.xpath("")).isDisplayed()) 
			{
				et.log(LogStatus.PASS,"blank password test passed");	
			}
			else if (p[3].equalsIgnoreCase("invalid") && driver.findElement(By.xpath("")).isDisplayed())
			{
				et.log(LogStatus.PASS,"wrong password test passed");
			}
			else if (p[0].equalsIgnoreCase("valid") && p[3].equalsIgnoreCase("valid") && driver.findElement(By.xpath("")).isDisplayed()) 
			{
				et.log(LogStatus.PASS,"valid mobile no. & valid password test passed");
			}
			else
			{
			//screenshot
			SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
			Date d=new Date();
			String fname=sf.format(d)+".png";
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File(fname);
			FileHandler.copy(src,dest);
			et.log(LogStatus.FAIL,"login status test failed"+et.addScreenCapture(fname));
		    }
		    //close site
			driver.close();
			}
			catch (Exception e) 
			{
				driver.close();
				et.log(LogStatus.ERROR,e.getMessage());
		    }
		    }
			//close text file (close read & write permission)
			br.close();
			fr.close();
			//save extent file results
			er.endTest(et);
			er.flush();
	}
}
		
			
