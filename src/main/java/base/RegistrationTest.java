package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest {
	
	WebDriver driver;
	
	@DataProvider(name="loginData")
	public Object[][] getdData(){
		return new Object[][] {
			{"user12", "passwrd1",},
			{"user23", "passwrd2"},
			{"user34", "passwrd3"},
		};
		
	}
	
	@Test(dataProvider="loginData")
	public void login(String user, String pswrd) {
		System.out.println(user);
		System.out.println(pswrd);
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Browser Launched");
	}
	
	@BeforeMethod
	public void openRegPage() {
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Register")).click();
		System.out.println("Reg Page Opened");
	}
	
	@Test
	public void pageTitle() {
		String title= driver.getTitle();
		System.out.println("Title= " +title);
			
	}
	
	@Test
	public void pageHeading() {
		String heading=driver.findElement(By.xpath("//h1")).getText();
		System.out.println("Heading= "+ heading);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
		System.out.println("Browser Closed");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
}
