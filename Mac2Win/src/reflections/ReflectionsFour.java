package reflections;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReflectionsFour {
	
	public static String valueone;

	public static void main(String[] args) throws IllegalAccessException, Exception {
		// TODO Auto-generated method stub
		// Setting path of excel file
		File excel = new File("C:\\Users\\ud\\Desktop\\keyword.xlsx");
		FileInputStream fis = new FileInputStream(excel);

		// Workbook connection
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// WorkSheet connection
		XSSFSheet ws = wb.getSheet("Sheet1");

		// Counting rows
		int rownum = ws.getLastRowNum();

		// counting columns
		int colnum = ws.getRow(0).getLastCellNum();

		String[][] data = new String[rownum][colnum];

		for (int i = 0; i < rownum; i++) {
			XSSFRow row = ws.getRow(i);
			for (int j = 0; j < colnum; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				data[i][j] = value;
				System.out.println("The values from excel are " + value);
				value = valueone;  
			}
			System.out.println("The updated values from excel are " + valueone);
		}

	}

	public static String cellToString(XSSFCell cell) {
		// TODO Auto-generated method stub
		int type;
		Object result;
		type = cell.getCellType();
		switch (type) {
		case 0: // Numeric Value in excel
			result = cell.getNumericCellValue();
			break;
		case 1: // String value in excel
			result = cell.getStringCellValue();
			break;
		default:
			throw new RuntimeException("There is no support type for this");

		}
		return result.toString();
	}

}
