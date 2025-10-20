package Oct_20;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadDemo {

	public static void main(String[] args) 
	{
		File f;
		FileInputStream fis ;
		XSSFWorkbook wb;
		 XSSFSheet sh ;
		// HSSFWorkbook  --- .xls
		try {
			 f= new File(".\\src\\test\\java\\Oct_20\\Book1.xlsx");
			 fis = new FileInputStream(f);
			  wb= new XSSFWorkbook(fis);
			  sh = wb.getSheetAt(0);
			  
//				String value =sh.getRow(2).getCell(1).getStringCellValue();
//				System.out.println(value);
				  
				System.out.println(" Row count : "+ sh.getLastRowNum());
				System.out.println("coulunm count : "+sh.getRow(0).getLastCellNum());
				
				 for(int r=0 ; r<=sh.getLastRowNum() ;r++) // rows
				 {
					 for(int c=0 ; c<sh.getRow(0).getLastCellNum() ;c++) // columns
					 {
						 System.out.print(sh.getRow(r).getCell(c).getStringCellValue()+"   ");
					 }
					 System.out.println();
				 }
			
		} catch (IOException e) 
		{			
			e.printStackTrace();
		}
	}
}
