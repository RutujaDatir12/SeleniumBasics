package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    public WebDriver driver;

    // Page Objects
    protected LoginPage lp;
    protected HomePage hp;
    protected SearchPage sp;
    protected ProductPage pp;
    protected CartPage cp;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");

        // Initialize Page Objects
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        sp = new SearchPage(driver);
        pp = new ProductPage(driver);
        cp = new CartPage(driver);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

        System.out.println("Browser closed");
    }
}