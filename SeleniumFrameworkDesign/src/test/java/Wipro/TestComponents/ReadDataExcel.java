package Wipro.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadDataExcel {
	
	public String[][] getData(String sheet) throws IOException {
		File f= new File(System.getProperty("user.dir")+"/src/main/java/Wipro/Resources/TestData.xlsx");
		FileInputStream fs= new FileInputStream(f);
		XSSFWorkbook xs= new XSSFWorkbook(fs);
		XSSFSheet s=xs.getSheet(sheet);
		
		int rows=s.getLastRowNum();
		System.out.println(rows);
		
		Row r=s.getRow(0);
		int col=r.getLastCellNum();
		System.out.println(col);
		
		DataFormatter d =new DataFormatter();
		String data[][]=new String[rows][col];
		for(int i=1;i<=rows;i++) {
			for(int j=0;j<col;j++) {
				data[i-1][j]=d.formatCellValue(s.getRow(i).getCell(j));
			}
		}
		xs.close();
		return data;
	}
}
