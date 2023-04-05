package loginpage;

import org.openqa.selenium.By;

public class EmployeePage {
	
	  public By employeeMenu=By.xpath("//div[@id='EmployeeProfileStatus']/descendant::span[2]");
	  public By employeeSub=By.xpath("//ul[@id='admin_Employees']/descendant::i[1]");
	  public By allempinfo=By.xpath("//tbody[@class='ant-table-tbody']/tr/td");
	  public By searchBox=By.id("advanced_search_searchTerm");
	  public By searchButton=By.xpath("//span[text()='Search']");
	  
	}