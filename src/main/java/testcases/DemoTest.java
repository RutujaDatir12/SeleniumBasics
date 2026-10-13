package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import base.DemoBase;
public class DemoTest {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		DemoBase db=new DemoBase(driver);
		db.url();
		db.sign();
       			}
}


