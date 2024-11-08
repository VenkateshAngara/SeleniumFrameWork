package Wipro.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {


	public ArrayList<String> getData(String testcase) throws IOException {
	ArrayList<String> al= new ArrayList<String>();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Wipro/Resources/TestData.xlsx");
		XSSFWorkbook w= new XSSFWorkbook(fis);
		int noofsheet=w.getNumberOfSheets();
		for(int i=0;i<noofsheet;i++) {
			if(w.getSheetName(i).equalsIgnoreCase("Data")) {
				XSSFSheet sheet=w.getSheetAt(i);
				Iterator<Row>it=sheet.iterator();
				Row firstRow=it.next();
				Iterator<Cell>cell=firstRow.cellIterator();
				int k=0,column=0;
				while(cell.hasNext()) {
					Cell value=cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcase")) {
						column=k;
					}
					k++;
				}
				System.out.println(column);
				while(it.hasNext()) {
					Row r=it.next();
				
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcase)) {
						Iterator<Cell> ce=r.cellIterator();
						while(ce.hasNext()) {
							Cell cel=ce.next();
							if(cel.getCellType()==CellType.STRING) {
							al.add(cel.getStringCellValue());
							}
							else if(cel.getCellType()==CellType.NUMERIC) {
								
								al.add(NumberToTextConverter.toText(cel.getNumericCellValue()));
								}
						}
					 
					}
	
				}
			
			}
		}
		w.close();
		return al;
	}
	
}
