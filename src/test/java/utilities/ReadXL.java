package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXL {
	public static String ReadXI(String sheetName,int r, int c, Object XSSFCell ) throws IOException {
		File F = new File(FilePath.XLPath);
		FileInputStream fi;
		String value ="";
		
		
		
		fi = new FileInputStream(F);
		XSSFWorkbook w = new XSSFWorkbook(fi);
        XSSFSheet s = w.getSheet(sheetName);
       XSSFRow row = s.getRow(r);
       XSSFCell cell = row.getCell(c);

       int cellType = cell.getCellType();
       //cell is String
       if (cellType==1){
          value = cell.getStringCellValue();
          //cell is data
       }
       else if(Date.isXSSFCellDateFormatted(cell)) {
           Date d = cell.getDateCellValue();
           SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyy");
           value = sim.format(d);
       }
       else{
           double d = cell.getNumericCellValue();
           //type casting
           long l = (long) d;
           value = String.valueOf(l);
       }

        return value;
		
	}
}
