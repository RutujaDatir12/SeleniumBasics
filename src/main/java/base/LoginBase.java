package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginBase {
		
		WebDriver driver;
		public LoginBase(WebDriver driver) {
			this.driver = driver;
		}
		
		public void url() {
			driver.get("https://demowebshop.tricentis.com/");
			
		}
        
		public void logIn(String email, String password) {
			driver.findElement(By.xpath(password));
			
		}
		
		public void logOut() {
			
		}
	}


