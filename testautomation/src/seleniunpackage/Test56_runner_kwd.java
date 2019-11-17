package seleniunpackage;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;



import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Test56_runner_kwd {

	public static void main(String[] args) throws Exception {
		// connect to excel file
		File f = new File("Book1.xls");
		// open excel file for reading
		Workbook rwb = Workbook.getWorkbook(f);
		Sheet rsh1 = rwb.getSheet(0);// sheet 1(test id)
		int nour1 = rsh1.getRows();
		System.out.println(nour1);
		int nouc1 = rsh1.getColumns();
		System.out.println(nouc1);
        Sheet rsh2 = rwb.getSheet(1);// sheet 2(step id)
		int nour2 = rsh2.getRows();
		System.out.println(nour2);
		int nouc2 = rsh2.getColumns();
		System.out.println(nouc2);
		// open excel file for writing
		WritableWorkbook wwb = Workbook.createWorkbook(f, rwb);
		WritableSheet wsh1 = wwb.getSheet(0);
		WritableSheet wsh2 = wwb.getSheet(1);
		WritableCellFormat cf = new WritableCellFormat();
		cf.setAlignment(Alignment.JUSTIFY);
		cf.setWrap(true);
		// take date as column name
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		Date dt = new Date();
		String snap = sf.format(dt);
		// set name as result in column in sheet1
		Label l1 = new Label(nouc1, 0, snap, cf);
		wsh1.addCell(l1);
		// set name as result in column in sheet2
		Label l2 = new Label(nouc2, 0, snap, cf);
		wsh2.addCell(l2);
		// create an object of Mymethods class
		Mymethods mm=new Mymethods();
		// collect methods info using method class object
		Method m[]=mm.getClass().getMethods();
		int s=m.length;
		System.out.println(s);
		// key driven
		try 
		{
			// calling methods one after one
			// 1st row (index start from 0)have column name in sheet1
			for (int i = 1; i < nour1; i++) // from 2nd row (index=1)
			{
				int flag = 0;
				// get tid and mode from sheet1
				String tid = rsh1.getCell(0, i).getContents();
				String mode = rsh1.getCell(2, i).getContents();
				if (mode.equalsIgnoreCase("Yes"))
				{
					// 1st row (index start from 0)have column name in sheet2

					for (int j = 1; j < nour2; j++)
					{
						// get stid from sheet2
						String stid = rsh2.getCell(0, j).getContents();
						if (tid.equalsIgnoreCase(stid)) 
						{
							// take step details from sheet2
							String mn = rsh2.getCell(2, j).getContents();
							String e = rsh2.getCell(3, j).getContents();
							String d = rsh2.getCell(4, j).getContents();
							String c = rsh2.getCell(5, j).getContents();
							System.out.println(mn + " " + e + " " + d + " " + c);
							// for accessing methods from method class in runner class
							for (int k=0;k<s; k++) 
							{
								if (m[k].getName().equals(mn)) 
								{
									String r = (String) m[k].invoke(mm,e,d,c);
									Label ll = new Label(nouc2, j, r, cf);
									wsh2.addCell(ll);
									if (r.equalsIgnoreCase("unknown browser"))
									{
										wwb.write();
										wwb.close();
										rwb.close();
										System.exit(0);// stop run
									}
									if (r.contains("failed") || r.contains("Failed") || r.contains("Interrupted"))
									{
										flag = 1;
									}
								} // if closing otherwise if we got that element which we want so we can break or
									// terminate the loop
							}
						}
					}

					if (flag == 0) {
						Label l3 = new Label(nouc1, i, "passed", cf);
						wsh1.addCell(l3);
					}
					else {
						Label l3 = new Label(nouc1, i, "failed", cf);
						wsh1.addCell(l3);
					}
				}
			}
		} 
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		// save the results
		wwb.write();
		wwb.close();
		rwb.close();

	}

}
