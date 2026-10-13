package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.LoginBase;

public class TestNGTest {
	WebDriver driver =new ChromeDriver();
	
	@Test
	public void login() {
		
		LoginBase lb = new LoginBase(driver);
		lb.url();
		lb.logIn("rutuja123456@gmail.com", "rutuja123");
		lb.logOut();
		
	}

}
