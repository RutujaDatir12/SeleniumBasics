package base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product-item")
    List<WebElement> products;

    public boolean isProductDisplayed() {
        return products.size() > 0;
    }

    public void printSearchResult(String keyword) {

        if (isProductDisplayed()) {
            System.out.println("Successfully Searched \"" + keyword + "\"");
        } else {
            System.out.println("No product found");
        }
    }

    public void clickFirstProduct() {
        if (products.size() > 0) {
            products.get(0).click();
        }
    }
}
