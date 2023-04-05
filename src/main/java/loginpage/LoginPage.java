package loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import icehrm_automation.BaseClass;

public class LoginPage extends BaseClass{
	
	//declare all the locator
   By username=By.name("username");
  	By password=By.name("password");
   By loginbutton=By.xpath("//button[text()='Log in ']");
  	By resetbutton=By.xpath("//form[@id='requestPasswordChangeForm']/preceding::a[1]");
	public By errorMsg=By.xpath("//div[@class='alert alert-danger']");
	
  //      @FindBy(name="username")
   //      public WebElement username;
      
  //      @FindBy(name="password")
  //      public WebElement password;
      
    //     @FindBy(xpath="//button[text()='Log in ']")
    //    public WebElement loginButton;
      
     public LoginPage(WebDriver driver)
      {
    	  //PageFactory.initElements(driver, LoginPage.class);
    	//  PageFactory.initElements(driver,this);
      }  
      
	
	
	 public void login(String username,String password)
	 {
 	 enterText(this.username,username);
		 enterText(this.password,password);
		 click(loginbutton);
	//	   this.username.sendKeys(username);
	//	    this.password.sendKeys(password);
	//	    this.loginButton.click();
		 
	 }
	

}

