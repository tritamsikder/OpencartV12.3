package utilities;

//import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider (name="loginData")
	public String[][] getData() throws IOException {
		
		String path = "./testData/Opencart_LoginData.xlsx";
		
		ExcelUtility xlutils = new ExcelUtility(path);
		
		int totalRows = xlutils.getRowCount("Sheet1");
		int totalCols = xlutils.getCellCount("Sheet1", 1);
		
		String loginData[][] = new String[totalRows][totalCols];
		
		for(int r = 1; r <= totalRows; r++) {
			for(int c = 0; c < totalCols; c++) {
				loginData[r-1][c] = xlutils.getCellData("Sheet1", r, c);
			}
		}
		
		return loginData;
		
	}
}