package com.practice.Keyword.Engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import com.practice.Keyword.Base.Base;

public class KeywordEngine {
	
	public WebDriver driver;
	public Properties prop;
	
	public static final String SCENARIOSHEET_PATH="D:\\Sivaram_Selenium\\KeywordDriven\\src\\main\\java\\com\\practice\\Keyword\\datatables\\ScenarioSheet.xlsx";

	public static Workbook workbook;
	
	public static Sheet sheet;
	
	public void startExecution(String SheetName)
	{
		FileInputStream file=null;
		try {
			 file=new FileInputStream(SCENARIOSHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			workbook=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=workbook.getSheet(SheetName);
		
		int col=1;
		
		for(int row=1;row<=sheet.getLastRowNum();row++)
		{
			String locator=sheet.getRow(row).getCell(col).toString().trim();
			
			String locatorName,locatorValue;
			
			if(!locator.equalsIgnoreCase("NA"))
			{
				 locatorName=locator.split("=")[0].trim();
				 locatorValue=locator.split("=")[1].trim();
			}
			String action=sheet.getRow(row).getCell(col+1).toString().trim();
			String value=sheet.getRow(row).getCell(col+2).toString().trim();
			
			switch (action) {
			case "open browser":
				Base base=new Base();
				prop=base.init_properties();
				if(value.isEmpty()||value.equals("NA"))
				{
				driver=base.init_driver(prop.getProperty("browser"));
				}
				else
				{
					driver=base.init_driver(value);
				}
					
				break;
				
			case "open URL":
				
				driver.get(value);
				break;
				
			case "quit":
				
				driver.quit();

			default:
				break;
			}
			
			//System.out.println(locator+action+value);
			
			
			
			
			
			
		}
	}
}
