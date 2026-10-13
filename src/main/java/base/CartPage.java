package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cart-item-row")
    WebElement cartItem;

    public boolean isItemPresentInCart() {
        return cartItem.isDisplayed();
    }

    public void verifyItemInCart() {
        if (isItemPresentInCart()) {
            System.out.println("Selected item is appearing in the cart");
        } else 
        {
            System.out.println("Selected item is NOT appearing in the cart");
        }
    }
}
