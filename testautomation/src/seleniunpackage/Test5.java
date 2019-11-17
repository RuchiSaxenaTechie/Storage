package seleniunpackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5{

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(1000);
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Flights")).click();
		Thread.sleep(1000);
		try
		{
			WebElement e=driver.findElement(By.name("tripType"));
			if(e.isDisplayed())
         { 
              System.out.println("Displayed");
        if(e.isEnabled())
        {
	System.out.println("Enabled");
        if(e.isEnabled())
        {
	System.out.println("Selected");
         }
      else
      {
	System.out.println("Not Selected");
}
}
else
		{
			System.out.println("Disabled");
		}
	}
	else
	{
		System.out.println("Hidden");
	}
}
catch(Exception ex)
{
	System.out.println(ex.getMessage());
}
	}
}
	
		
		

	

		

