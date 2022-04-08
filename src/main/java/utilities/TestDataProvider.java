package utilities;

import java.util.Hashtable;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name = "sendersDetailsData")
	public Object[][] sendersNameData() {
		System.out.println("inside dataprovider");
		return getTestData("H:\\POMWorkspace\\ver1.2\\BookCabs\\resources\\TestData.xlsx","GIFTCARDS","TestCase2");
	}
	
	@DataProvider(name ="FillingCabDetailsData")
	public Object[][] fillingCabDetailsData() {
		return getTestData(".\\resources\\TestData.xlsx","CABS","searchCabsFromToDataDrivenTest");
	}
	
	
	public static Object[][] getTestData(String DataFileName, String SheetName, String TestName) {

		ReadExcelDataFile readdata = new ReadExcelDataFile(DataFileName);
		String sheetName = SheetName;
		String testName = TestName;

		// Find Start Row of TestCase
		int startRowNum = 0;
		while (!readdata.getCellData(sheetName, 0, startRowNum).equalsIgnoreCase(testName)) {
			startRowNum++;
		}
		
		int startTestColumn = startRowNum + 1;
		int startTestRow = startRowNum + 2;

		// Find Number of Rows of TestCase
		int rows = 0;
		while (!readdata.getCellData(sheetName, 0, startTestRow + rows).equals("")) {
			rows++;
		}
		
		// Find Number of Columns in Test
		int colmns = 0;
		while (!readdata.getCellData(sheetName, colmns, startTestColumn).equals("")) {
			colmns++;
		}
		
		//Define Two Object Array
		Object[][] dataSet = new Object[rows][1];
		Hashtable<String, String> dataTable = null;
		int dataRowNumber=0;
		for (int rowNumber = startTestRow; rowNumber <= startTestColumn + rows; rowNumber++) {
			dataTable = new Hashtable<String, String>();
			for (int colNumber = 0; colNumber < colmns; colNumber++) {
				String key = readdata.getCellData(sheetName, colNumber, startTestColumn);
				String value = readdata.getCellData(sheetName, colNumber, rowNumber);
				dataTable.put(key, value);
			}
			dataSet[dataRowNumber][0]=dataTable;
			dataRowNumber++;
		}
	 return dataSet;
	}
	
}

