package icehrm_automation;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelTestUtil2 {
	
	private Workbook workbook;
	private Sheet sheet;

	public Object[][] getExcelData(String filePath, String sheetName) {
		try {
			FileInputStream inputstream = new FileInputStream(filePath);
			String extensions = filePath.substring(filePath.indexOf(".") + 1);
			System.out.println(extensions);
			if (extensions.equals("xlsx")) {
				workbook = new XSSFWorkbook(inputstream);
			} else {
				workbook = new HSSFWorkbook(inputstream);
			}
			sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(totalRows + " " + totalCols);
			Object[][] object = new Object[totalRows - 1][1];
			for (int i = 1; i < totalRows; i++) {
				EmpDetails empDetail = new EmpDetails();
				double id = sheet.getRow(i).getCell(0).getNumericCellValue();
				empDetail.setId(id);
				String empName = sheet.getRow(i).getCell(1).getStringCellValue();
				empDetail.setEmpName(empName);
				String address = sheet.getRow(i).getCell(2).getStringCellValue();
				empDetail.setAddress(address);
				String state = sheet.getRow(i).getCell(3).getStringCellValue();
				empDetail.setState(state);
				double salary = sheet.getRow(i).getCell(4).getNumericCellValue();
				empDetail.setSalary(salary);
				String desgination = sheet.getRow(i).getCell(5).getStringCellValue();
				empDetail.setDesgination1(desgination);
				double adharno = sheet.getRow(i).getCell(6).getNumericCellValue();
				empDetail.setAdharno(adharno);
				String pancard = sheet.getRow(i).getCell(7).getStringCellValue();
				empDetail.setPanCard(pancard);
				object[i - 1][0] = empDetail;
			}
			workbook.close();
			inputstream.close();
			return object;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
	
	
	
	


