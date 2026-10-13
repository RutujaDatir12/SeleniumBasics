package demowebshop;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

    public static void main(String[] args) throws IOException {

       
        Properties prop = new Properties();
        FileInputStream fis =new FileInputStream("src/main/resources/A6.properties");
        prop.load(fis);

        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        String keyword = prop.getProperty("keyword");
        String product = prop.getProperty("product");

        fis.close();

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        System.out.println("Login successful");

    
        WebElement searchBox =driver.findElement(By.id("small-searchterms"));
        searchBox.clear();
        searchBox.sendKeys(keyword);
        driver.findElement(By.cssSelector("input[value='Search']")).click();

        List<WebElement> products =driver.findElements(By.cssSelector(".product-item"));
             

        if (products.size() > 0) {
            System.out.println("Successfully Searched \"" + keyword + "\"");
            System.out.println( "Number of products found: " + products.size());
                   
        } else {
            System.out.println("No product found");
            driver.quit();
            return;
        }

        WebElement productLink =driver.findElement(By.linkText(product));
        productLink.click();
        System.out.println("Product opened: " + product);

       
        String productTitle =driver.findElement(By.cssSelector(".product-name h1")).getText();
        
                      
        if (productTitle.equals(product)) {
            System.out.println("Product page validation passed");

        } else {
            System.out.println("Product page validation failed");
        }
        driver.findElement(By.cssSelector("input[value='Add to cart']")).click();
               
        List<WebElement> notification = driver.findElements(By.cssSelector(".bar-notification.success"));
               
                        

        if (notification.size() > 0) {
            System.out.println("Product successfully added to cart");

        } else {
        	System.out.println("Product was NOT added to cart");
        }

       
        driver.findElement(By.linkText("Shopping cart")).click();

        List<WebElement> cartProducts =driver.findElements(By.cssSelector(".cart-item-row"));
                

        if (cartProducts.size() > 0) {

            System.out.println("Cart contains product");

        } else {

            System.out.println("Cart is empty");
        }

       
        List<WebElement> selectedProduct =driver.findElements(By.linkText(product));
                

        if (selectedProduct.size() > 0) {

            System.out.println( "Selected item is appearing in the cart");
                   

        } else {

            System.out.println("Selected item is NOT appearing in the cart");
                    
        }

        driver.quit();
    }
}