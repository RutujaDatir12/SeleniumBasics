package demowebshop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProduct {
       
	public static void main(String[] args) throws IOException {
		
		  Properties prop = new Properties();
          FileInputStream fis =new FileInputStream("src/main/resources/A5.properties");
          prop.load(fis);
         
          WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.get(prop.getProperty("url"));
          driver.findElement(By.linkText(prop.getProperty("loginLink"))).click();
          driver.findElement( By.id(prop.getProperty("emailLocator"))).sendKeys(prop.getProperty("email"));
          driver.findElement( By.id(prop.getProperty("passwordLocator"))) .sendKeys(prop.getProperty("password"));    
          driver.findElement(By.xpath(prop.getProperty("loginButtonLocator"))).click();   
          driver.findElement(By.id(prop.getProperty("searchBoxLocator"))) .sendKeys(prop.getProperty("keyword"));
          driver.findElement( By.xpath(prop.getProperty("searchButtonLocator"))).click();
          List<WebElement> products = driver.findElements( By.className(prop.getProperty("productLocator")));
        	if (products.size() > 0) {
        	    prop.setProperty("productStatus", "Valid Product");
        	    for (int i = 0; i < products.size(); i++) {
        	        String productName = products.get(i).getText();
        	        prop.setProperty("result" + (i + 1),productName);
        	    }
        	} else {
        	    for (int i = 1; i <= 10; i++) {
        	        prop.remove("result" + i);
        	    }
        	    prop.setProperty("result1", "No product found");
        	    prop.setProperty("productStatus", "Invalid Product");
        	}
        
          FileOutputStream fos = new FileOutputStream("src/main/resources/A5.properties");
          prop.store(fos, "Search Result");
          fos.close();
          fis.close();
          driver.quit();
      }
  }
                 

