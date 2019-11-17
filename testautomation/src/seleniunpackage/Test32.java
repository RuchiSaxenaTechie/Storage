package seleniunpackage;

import java.sql.Driver;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test32 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your text");
		String x = sc.nextLine();
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--use-fake-ui-for-media-stream=1");
		ChromeDriver driver = new ChromeDriver(co);
		driver.get("https://www.google.co.in");
		// wait for page ready
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.manage().window().maximize();
		//click on mic
		driver.findElement(By.id("gsri_ok0")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("spchb")));
		

		// Convert into voice
		System.setProperty("mbrola.base", "E:\\selenium\\Mbrola");
		VoiceManager vm = VoiceManager.getInstance();
		Voice v = vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		sc.close();
		sc.close();

	}

}
