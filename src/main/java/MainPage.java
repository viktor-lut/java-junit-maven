import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.className("header_btn");

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

//    public MainPage typeEmail(String email) {
//        driver.findElement(emailField).sendKeys(email);
//        return this;
//    }
//
//    public MainPage typePassword(String password) {
//        driver.findElement(passwordField).sendKeys(password);
//        return this;
//    }
}
