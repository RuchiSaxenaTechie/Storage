package seleniunpackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.template.SimpleDate;
import jxl.HeaderFooter.Contents;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.read.biff.BiffException;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Test55 {

	public static void main(String[] args) throws Exception   {
		// open .xls file for test data reading
		File f = new File("w2sms.xls");
		Workbook rwb = Workbook.getWorkbook(f);
		Sheet rsh = rwb.getSheet(0);// sheet 1
		// count of used rows
		int nour = rsh.getRows();
		// open .xls file for test data writing
		WritableWorkbook wwb = Workbook.createWorkbook(f, rwb);
		WritableSheet wsh = wwb.getSheet(0);// sheet 1
		//creat result column(next to last column)
		int nouc=rsh.getColumns();
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date d=new Date();
		String colname=sf.format(d);
		Label l=new Label(nouc,0,colname);
		wsh.addCell(l);
		//data driven testing
		//1st row (index is 0) have column names
		ChromeDriver driver=null;
		WritableFont wf=null;
		WritableCellFormat cf= null;
		//common decorations
		wf=new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
		wf.setColour(Colour.ORANGE);
		cf=new WritableCellFormat(wf);
		cf.setAlignment(Alignment.JUSTIFY);
		cf.setWrap(true);
		for(int i=1;i<nour;i++)
		{
		    String mobno=rsh.getCell(0,i).getContents();
			String mobnoc=rsh.getCell(1,i).getContents();
			String pwd=rsh.getCell(2,i).getContents();
			String pwdc=rsh.getCell(3,i).getContents();
			try
			{
				//launch site
				System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.get(" ");
				driver.manage().window().maximize();
				WebDriverWait w=new WebDriverWait(driver,20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
				driver.findElement(By.name("mobileNo")).sendKeys(mobno);
				driver.findElement(By.name("password")).sendKeys(pwd);
				driver.findElement(By.xpath("(//*[contains(text(),'Login')])[2] ")).click();
				Thread.sleep(5000);
				//validations
				if(mobno.length()==0 && driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
				{
				Label l1=new Label(nouc,i,"blank mobile no test passed");
				l1.setCellFormat(cf);
				wsh.addCell(l1);
				}
				else if (mobno.length()<10 && driver.findElement(By.xpath("//*[text()='Enter valid mobile number']")).isDisplayed()) 
				{
					Label l2=new Label(nouc,i," invalid size mobileno test passed");
					l2.setCellFormat(cf);
					wsh.addCell(l2);
				}
				else if (mobnoc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[text()='Invalid Mobile Number']")).isDisplayed() ) 
				{
					Label l3=new Label(nouc,i," wrong mobileno test passed");
					l3.setCellFormat(cf);
					wsh.addCell(l3);
				}
				else if (pwd.length()==0 && driver.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed()) 
				{
					Label l4=new Label(nouc,i," blank password test passed");
					l4.setCellFormat(cf);
					wsh.addCell(l4);
				}
				else if (pwdc.equalsIgnoreCase("invalid") && driver.findElement(By.xpath("//*[text()='Incorrect number or password! Try Again.']")).isDisplayed()) 
				{
					Label l5=new Label(nouc,i," wrong password test passed");
					l5.setCellFormat(cf);
					wsh.addCell(l5);
				}
				else if (pwdc.equalsIgnoreCase("valid")&& mobnoc.equalsIgnoreCase("valid") && driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed() ) 
				{
					Label l6=new Label(nouc,i," valid data test passed");
					l6.setCellFormat(cf);
					wsh.addCell(l6);
				}
				else
				{
					//get screenshot 
					String fname=sf.format(d)+".png";
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File(fname);
					FileHandler.copy(src,dest);
					//seprate decorations for test failed
					Label l7=new Label(nouc,i,"login test failed and see"+fname);
					wf=new WritableFont(WritableFont.COURIER,20,WritableFont.BOLD);
					wf.setColour(Colour.RED);
					cf=new WritableCellFormat(wf);
					cf.setAlignment(Alignment.JUSTIFY);
					cf.setWrap(true);
					l7.setCellFormat(cf);
					wsh.addCell(l7);
				}
					//close sie
					driver.quit();
			}
					catch (Exception e) 
			{
						driver.quit();
						Label l8=new Label(nouc,i,e.getMessage());
						wsh.addCell(l8);
			}
		}
		//save excel file
				wwb.write();//save
				rwb.close();//close
				wwb.close();//close			
			}
}

					
				
				
				
		
		
		
		


