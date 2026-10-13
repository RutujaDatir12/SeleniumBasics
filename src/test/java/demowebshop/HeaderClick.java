package demowebshop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderClick {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demowebshop.tricentis.com/");

		List<WebElement> headers = driver.findElements(By.cssSelector(".top-menu li a"));

		for (int i = 0; i < headers.size(); i++) {

			driver.get("https://demowebshop.tricentis.com/");

			headers = driver.findElements(By.cssSelector(".top-menu li a"));

			String headerName = headers.get(i).getText();

			System.out.println(headerName);

			if (headers.get(i).isDisplayed() && headers.get(i).isEnabled()) {

				headers.get(i).click();

			}
		}

		driver.quit();
	}
}