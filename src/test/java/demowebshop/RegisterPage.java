package demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterPage {


			public static void main(String[] args) {

				WebDriver driver = new ChromeDriver();

				driver.manage().window().maximize();

				driver.get("https://demowebshop.tricentis.com/");

				
				driver.findElement(By.linkText("Register")).click();

			
				driver.findElement(By.id("gender-female")).click();

			
				driver.findElement(By.id("FirstName")).sendKeys("Rutuja");

			
				driver.findElement(By.id("LastName")).sendKeys("Datir");

			
				driver.findElement(By.id("Email")).sendKeys("rutuja123456@gmail.com");

			
				driver.findElement(By.id("Password")).sendKeys("Rutuja@123");

			
				driver.findElement(By.id("ConfirmPassword")).sendKeys("Rutuja@123");

			
				driver.findElement(By.id("register-button")).click();

				driver.quit();
			}
		}
	

