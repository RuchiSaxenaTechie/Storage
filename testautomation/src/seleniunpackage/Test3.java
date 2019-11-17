package seleniunpackage;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test3{

	public static void main(String[] args) {
		
	OperaOptions oo=new OperaOptions();			
	oo.setBinary("C:\\Program Files (x86)\\Opera.exe");
	System.setProperty("webdriver.opera.driver","E:\\selenium\\operadriver.exe");

		OperaDriver driver=new OperaDriver(oo);
		

	}

}
