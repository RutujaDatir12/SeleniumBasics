package demowebshop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderPrint {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		List<WebElement> headers=driver.findElements(By.cssSelector(".top-menu li a"));
		
		for (WebElement header:headers) {
			System.out.println(header.getText());
			
		}
		
		driver.quit();
	}

}
