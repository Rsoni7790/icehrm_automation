package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import icehrm_automation.EmpDetails;
import icehrm_automation.ExcelTestUtil2;
import icehrm_automation.TestListeners;

public class ExcelTestCase extends TestListeners{

	@DataProvider
	public Object[][] getTestData() {
		ExcelTestUtil2 excelutil = new ExcelTestUtil2();
		String filePath = "/Users/rsoni/OneDrive/Documents/testData.xlsx";
		String sheetName = "Sheet2";
		return excelutil.getExcelData(filePath, sheetName);
	}

	@Test(dataProvider = "getTestData")
	public void test(EmpDetails emp) {
		double empId = emp.getId();
		String empName1 = emp.getEmpName();
		String empad = emp.getAddress();
		String state=emp.getState();
		double sal = emp.getSalary();
		String des = emp.getDestination1();
		double adh = emp.getAdharNo();
		String pan = emp.getPanCard();
		System.out.println(empId + " " + empName1 + " " +state+" "+ empad + " " + sal + " " + des + " " + adh + " " + pan);
		System.out.println("--------------");

	}

}
