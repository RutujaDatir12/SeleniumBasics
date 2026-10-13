package demowebshop;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesData {

	public static void main(String[] args) throws IOException {

			
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("src/main/resources/data.properties");
			prop.load(fis);

			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();

			
			driver.get(prop.getProperty("url"));

		
			driver.findElement(By.linkText("Register")).click();

			driver.findElement(By.id("gender-female")).click();

		
			driver.findElement(By.id("FirstName")).sendKeys(prop.getProperty("firstname"));

		
			driver.findElement(By.id("LastName")).sendKeys(prop.getProperty("lastname"));

			driver.findElement(By.id("Email")).sendKeys(prop.getProperty("email"));

	
			driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password"));

		
			driver.findElement(By.id("ConfirmPassword")).sendKeys(prop.getProperty("confirmPassword"));

	
			driver.findElement(By.id("register-button")).click();

			fis.close();

			driver.quit();
		}
	}


