package seleniunpackage;


import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class Test54 {

	public static void main(String[] args) throws Exception {
		//open.xls file for reading
		File f=new File("readwritefile.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);//0 means sheet1
		int nour=rsh.getRows();//count of used rows
		//open same excel file for writing
		WritableWorkbook wwb=Workbook.createWorkbook(f, rwb);
		WritableSheet wsh=wwb.getSheet(0);//sheet 1
		//data driven
		//1st row has names in cloumn so will start from 2nd row
		for(int i=1;i<nour;i++)
		{
			int x=Integer.parseInt(rsh.getCell(0,i).getContents());
			int y=Integer.parseInt(rsh.getCell(1,i).getContents());
			int z=x+y;
			
			Number n=new Number(2,i,z);
			wsh.addCell(n);
		
			}
		//save excel file
		wwb.write();//save
		rwb.close();//close
		wwb.close();//close
	}
}
			
				
				
				
		
		
		
		
		
		
		



