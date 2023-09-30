package com.ActiTime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This Class is a Generic Class which contains non static methods to read data from property and excel file
 * @author Shri
 *
 */
public class FileLibrary 
{
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fish = new FileInputStream("./testdata/commondata.property");
		Properties p = new Properties();
		p.load(fish);
		String value = p.getProperty(key);
		return value;
	}
	/**
	 * This method is a non static method used to read data from excel sheet
	 * @param sheetname
	 * @param row
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String sheetname, int row, int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fish = new FileInputStream("./testdata/app.xlsx");
		Workbook wb = WorkbookFactory.create(fish);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cellno).getStringCellValue();
		return value;
	}
}
