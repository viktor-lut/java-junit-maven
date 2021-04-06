import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
                this.driver = driver;
    }

    private By loginField = By.cssSelector("input.MuiInputBase-input.MuiFilledInput-input");
    private By passwordField = By.name("password");
    private By signInButton = By.xpath("//button[@type='submit']");
//    private By heading = By.xpath(".//*h1");
    private By heading = By.tagName("h1");
    private By errorAuthorizationEmail = By.cssSelector("p.MuiFormHelperText-root.MuiFormHelperText-contained.Mui-error");
    private By errorAuthorizationPassword = By.cssSelector(".MuiFormHelperText-root");
    private By createAccLink = By.xpath("//a[text()=\"Sign Up\"]");

    public LoginPage typeUsername(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginInvalidCreds(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getErrorAuthTextEmail(){
        return driver.findElement(errorAuthorizationEmail).getText();
    }

    public String getErrorAuthTextPassword() {
        return driver.findElement(errorAuthorizationPassword).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }

}
