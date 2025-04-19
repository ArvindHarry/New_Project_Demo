package excelutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readDataFromExcel(String sheetName, int rowIndex, int colIndex) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowIndex);
		Cell cell = row.getCell(colIndex);
		String data = cell.toString();
		wb.close();
		
		return data;
	}
	
	public void writeDataBackToExcel(String sheetName, int rowIndex, int colIndex, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowIndex);
		Cell cell = row.createCell(colIndex);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./TestData/Book1.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	public int getLastRowNum(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("path");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRowNum = sh.getLastRowNum();
		
		return lastRowNum;
	}
	
	public int getLastCellNum(String sheetName, int rowIndex) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowIndex);
		int lastCellNum = row.getLastCellNum();
		
		return lastCellNum;
	}

}
