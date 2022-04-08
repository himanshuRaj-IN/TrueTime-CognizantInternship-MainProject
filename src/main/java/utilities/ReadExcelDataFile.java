package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelDataFile {

	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	
	/*************************** Constructor *********************************/
	public ReadExcelDataFile(String path) {

		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/*************************** Get Cell Data *******************************/	
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";

			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());

				return cellText;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}
	
	/*************************** Get Cell Data *******************************/
	public String getCellData1(String sheetName, int rowIndex, int columnIndex) {
		int sheetIndex = workbook.getSheetIndex(sheetName);
		if (sheetIndex == -1 || rowIndex < 0 || columnIndex < 0) {
			return "Sheet Not Found or May be Row or Column is less than 0 ";
		}
		sheet = workbook.getSheetAt(sheetIndex);
		row = sheet.getRow(rowIndex);
		if (row == null) {
			return "";
		}
		cell = row.getCell(columnIndex);
		if(cell == null) {
			return "";
		}
		switch (cell.getCellTypeEnum()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			Double temp = cell.getNumericCellValue();
			NumberFormat formatter = new DecimalFormat("#");  
			String f = formatter.format(temp);  
			return 	f;
			

		default:
			return "";
		}
		

	}

}
