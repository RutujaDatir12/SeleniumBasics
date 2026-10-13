package demowebshop;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn {

    public static void main(String[] args) throws IOException, InterruptedException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/A4.properties");
        prop.load(fis);  

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.findElement(By.linkText(prop.getProperty("LoginClick"))).click();
               
        for (int i = 1; i <= 6; i++) {

            String tc = "tc0" + i;
            String username = prop.getProperty(tc + ".username");
            String password = prop.getProperty(tc + ".password");
            driver.findElement(By.id(prop.getProperty("EmailBox"))).clear();
            driver.findElement(By.id(prop.getProperty("PasswordBox"))).clear();     
            if (!username.isEmpty()) {
                driver.findElement( By.id(prop.getProperty("EmailBox"))).sendKeys(username);         
            }

            if (!password.isEmpty()) {
                 driver.findElement(By.id(prop.getProperty("PasswordBox"))).sendKeys(password);
      
            }
            driver.findElement(By.xpath(prop.getProperty("LoginButton"))).click();   
            Thread.sleep(1000);
            System.out.println(tc + " : " + prop.getProperty(tc + ".expected"));     
            if (i == 1) {
                driver.navigate().back();
            }
        }

        driver.quit();
    }
}