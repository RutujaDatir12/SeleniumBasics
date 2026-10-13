package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ico-login")
    WebElement loginButton;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(css = "input[value='Log in']")
    WebElement loginButtonInside;
    
    @FindBy(className = "ico-logout")
    WebElement logoutButton;

    public void clickLogin() {
        loginButton.click();
    }

    public void enterEmail(String username) {
        email.sendKeys(username);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLoginInside() {
        loginButtonInside.click();
    }
    
    public boolean isLoginSuccessful() {
        return logoutButton.isDisplayed();
    }

    public void login(String username, String pass) {
        clickLogin();
        enterEmail(username);
        enterPassword(pass);
        clickLoginInside();
    }
}
