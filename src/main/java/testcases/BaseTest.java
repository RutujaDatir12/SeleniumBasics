package testcases;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import util.PropertyFile;

public class BaseTest extends BaseClass {

    Properties prop;

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
    	return new Object[][]
         {
            {"rutudatir97@gmail.com", "124845"},
            {"mansigole308@gmail.com", "Mansi308"},
            {"Test123@gmail.com", "Test123"}
        };
    }

    @Test(dataProvider = "loginData")
    public void addToCartTest(String username, String password)throws IOException {

//        prop = new Properties();
//        FileInputStream fis =new FileInputStream("src/main/resources/AddToCartNew.properties");
//        prop.load(fis);

        String keyword = PropertyFile.readProperty("keyword");
        System.out.println("Testing User : " + username);
        System.out.println("Keyword : " + keyword);
       
        //first Page
        //LoginPage lp = new LoginPage(driver);
        lp.login(username, password);
        boolean loginSuccessful = lp.isLoginSuccessful();
        Assert.assertTrue( loginSuccessful, "Login failed for user: " + username);
        
        //Second Page
        //HomePage hp = new HomePage(driver);
        hp.searchProduct(keyword);
        
        //Third Page
        // SearchPage sp = new SearchPage(driver);
        boolean productDisplayed = sp.isProductDisplayed();
        Assert.assertTrue(productDisplayed, "No product found for keyword: " + keyword);         
        System.out.println("Successfully Searched \"" + keyword + "\"");
        sp.clickFirstProduct();

        //Fourth page
       // ProductPage pp = new ProductPage(driver);
        pp.clickAddToCart();
        pp.openCart();

       //Fifth Page
      // CartPage cp =new CartPage(driver);
        boolean itemPresent =  cp.isItemPresentInCart();
        Assert.assertTrue(itemPresent,"Selected item is NOT appearing in cart");
        System.out.println("Selected item is appearing in the cart");
        PropertyFile.writeProperty("ActualResult", "Selected item is appearing in the cart");
    
                
    }
}
