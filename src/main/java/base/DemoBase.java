package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoBase {
    WebDriver driver;
    
    public DemoBase(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    @FindBy(linkText="Register")
    WebElement register;
    
    public void url() {
    	driver.get("https://demowebshop.tricentis.com/");
    }
    
    
	public void sign() {
	
		//driver.findElement(By.linkText("Register")).click();
        register.click();
		
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


