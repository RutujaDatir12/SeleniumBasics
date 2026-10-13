package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import base.LoginBase;

public class LogTest {
	public static void main(String[] args) {
	
		WebDriver driver =new ChromeDriver();
		LoginBase lb = new LoginBase(driver);
		lb.url();
		lb.logIn("rutuja123456@gmail.com", "rutuja123");
		lb.logOut();
	}
	
	
  

}

