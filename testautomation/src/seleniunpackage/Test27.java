package seleniunpackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test27 {

	public static void main(String[] args) {
		DesiredCapabilities c=DesiredCapabilities.chrome();
		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://cacert.org/ ");
		driver.manage().window().maximize();
		
		
	}

}
