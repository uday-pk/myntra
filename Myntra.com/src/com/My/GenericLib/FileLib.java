package com.My.GenericLib;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
	/**
	 * uday
	 * This method is used to get the value from properties file
	 * @param key
	 * @return String
	 */
public String getPropertyKeyvalue(String key)
	{
		FileInputStream ip=null;
		Properties prop=null;
		
		try
		{
			ip=new FileInputStream("./commandata/testdata.properties");
			prop=new Properties();
			
			prop.load(ip);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return prop.getProperty(key);
		
	}


	/**
	 * uday
	 * This method is used to get the value from excel sheet
	 * @param sheetname
	 * @param rowNum
	 * @param celNum
	 * @return
	 */
	public String getExcelData(String sheetname,int rowNum,int celNum)
	{
		FileInputStream ip=null;
		Workbook wb=null;
		
		try
		{
			ip=new FileInputStream("./commandata/Myntra.xlsx");
			
			wb=WorkbookFactory.create(ip);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Sheet sh=wb.getSheet(sheetname);
		Cell cell = sh.getRow(rowNum).getCell(celNum);
		
		CellType cType = cell.getCellType();
		
		if(cType.equals("Numeric"))
		{
			int data=(int)cell.getNumericCellValue();
			return String.valueOf(data);
			
		}
		else
		{
			String data=cell.getStringCellValue();
		return data;
		
		}
	}
}
