package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utility {
	public static String path;

	public static FileOutputStream file;

	public static XSSFWorkbook wb;

	public static XSSFSheet s;

public static void excelInit() throws FileNotFoundException

{

	Excel_Utility.path = System.getProperty("user.dir")+"\\Test_Data\\News_Around_Cognizant.xlsx";
 
	Excel_Utility.file = new FileOutputStream(path);
 
	Excel_Utility.wb = new XSSFWorkbook();

	Excel_Utility.s = Excel_Utility.wb.createSheet("Sheet1");
 
}

public static void saveDataToExcel(List<String> news, List<String> firstNews, List<String> secondNews) throws FileNotFoundException {

					Excel_Utility.excelInit();
//					XSSFCellStyle style=wb.createCellStyle(); 
//			         
//					style.setFillBackgroundColor(IndexedColors.RED.getIndex());
	
					XSSFRow row1 = Excel_Utility.s.createRow(0);
 
					row1.createCell(0).setCellValue("First Page News: News Around Cognizant");
					//row1.createCell(0).setCellStyle(style);

					for(int r=1;r<7;r++) {
 
						XSSFRow row = Excel_Utility.s.createRow(r);

						row.createCell(0).setCellValue(firstNews.get(r-1));
 

					}

					XSSFRow row2 = Excel_Utility.s.createRow(10);
 
					row2.createCell(0).setCellValue("Second Page News");
					//row2.createCell(0).setCellStyle(style);

					for(int r=11;r<16;r++) {
 
						XSSFRow row = Excel_Utility.s.createRow(r);
 
						row.createCell(0).setCellValue(secondNews.get(r-11));
 
					}
					XSSFRow row3 = Excel_Utility.s.createRow(18);
					 
					row3.createCell(0).setCellValue("News");
					//row3.createCell(0).setCellStyle(style);
					
					for(int r=19;r<24;r++) {
						 
						XSSFRow row = Excel_Utility.s.createRow(r);
 
						row.createCell(0).setCellValue(news.get(r-19));
 
						 
					}
 
				}
 
		
 
 
public static void closeExcel() throws IOException

{
 
	Excel_Utility.wb.write(file);
 
	Excel_Utility.wb.close();
 
	Excel_Utility.file.close();

}
}
