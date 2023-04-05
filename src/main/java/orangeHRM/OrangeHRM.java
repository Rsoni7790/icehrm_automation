package orangeHRM;

import org.openqa.selenium.By;

import icehrm_automation.BaseClass;

public class OrangeHRM extends BaseClass {
	
public	By username=By.name("username");
public 	By password=By.name("password");
public 	By loginButton=By.xpath("//button[@type='submit']");
 public By Pim=By.xpath("//ul[@class='oxd-main-menu']/descendant::a[2]");
 public By add=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
 public By plus=By.xpath("//div[@class='oxd-file-div oxd-file-div--active']");
 public By firstName=By.xpath("//input[@name='firstName']");
  public By lastName=By.name("lastName");
  public By save=By.xpath("//hr[@role=\"separator\"]//following::button[3]");
    
}
