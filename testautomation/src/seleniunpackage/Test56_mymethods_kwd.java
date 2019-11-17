package seleniunpackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test56_mymethods_kwd {
	public WebDriver driver;
	public WebDriverWait wait;
	

	// observations for cross browser checking
	public String launch(String e, String d, String c) throws Exception
	{
		if (e.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
            driver = new ChromeDriver();
		} 
		else if (e.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.geco.driver", "E:\\selenium\\gecodriver.exe");
			driver = new FirefoxDriver();
		} 
		else if (e.equalsIgnoreCase("ie"))
        {
			System.setProperty("webdriver.ie.driver", "E:\\selenium\\iedriverserver.exe");
			driver = new InternetExplorerDriver();
		} 
		else if (e.equalsIgnoreCase("opera"))
		{
			OperaOptions oo = new OperaOptions();
			oo.setBinary("C:\\Program Files (x86)\\Opera.exe");
			System.setProperty("webdriver.ie.driver", "E:\\selenium\\iedriverserver.exe");
			driver = new OperaDriver(oo);
		} 
		else
		{
			return ("unknown browser");
		}
		// to get test data as url to launch
		driver.get(d);
	    wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		driver.manage().window().maximize();
		return ("done");
	}

	// to get test data as mobile no. & password to fill
	public String fill(String e, String d, String c) 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		driver.findElement(By.xpath(e)).sendKeys(d);
		return ("done");
	}

	// to click
	public String click(String e, String d, String c) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(e)));
		driver.findElement(By.xpath(e)).click();
		return ("done");
	}

	// in try catch block --observations to validate login
	public String validatelogin(String e, String d, String c) throws Exception {
		Thread.sleep(5000);
		try {
			if (c.equalsIgnoreCase("mobilenoblank")
					&& driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed()) {
				return ("passed");
			} else if (c.equalsIgnoreCase("invalid size mobileno")
					&& driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed()) {
				return ("passed");
			} else if (c.equalsIgnoreCase("wrong mobileno")
					&& driver.findElement(By.xpath("//*[text()='Invalid Mobile Number']")).isDisplayed()) {
				return ("passed");
			} else if (c.equalsIgnoreCase("blank password")
					&& driver.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed()) {
				return ("passed");
			} else if (c.equalsIgnoreCase("wrong password") && driver
					.findElement(By.xpath("//*[text()='Incorrect number or password! Try Again.']")).isDisplayed()) {
				return ("passed");
			} else if (c.equalsIgnoreCase("validmobilenopassword")
					&& driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed()) {
				return ("passed");
			} else {
				String temp = this.screenshot();
				return ("test failed & go to" + temp);
			}
		} catch (Exception ex) {
			String temp = this.screenshot();
			return ("test interrupted & go to" + temp);
		}
	}

	// to close site
	public String close(String e, String d, String c) {
		driver.close();
		return ("done");
	}

	// programmer defined method to take screenshot
	public String screenshot() throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		Date d = new Date();
		String snap = sf.format(d) + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(snap);
		FileHandler.copy(src, dest);
		return (snap);
	}
}
