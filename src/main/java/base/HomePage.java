package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(css = "input[value='Search']")
    WebElement searchButton;

    public void searchProduct(String keyword) {

        searchBox.clear();
        searchBox.sendKeys(keyword);
        searchButton.click();
    }
}
