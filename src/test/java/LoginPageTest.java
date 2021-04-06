import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "F:\\Attract\\Vizable\\auto-tests\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1680, 1050));
        driver.get("https://app.vizable-u-dev.php-cd.attractgroup.com/sign-in");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmPtyEmailTest() throws InterruptedException {
        Thread.sleep(2000);
        LoginPage newLoginPage = loginPage.loginInvalidCreds("", "Qwer1234-");
        Thread.sleep(2000);
        String error = newLoginPage.getErrorAuthTextEmail();
        Assert.assertEquals("email is a required field", error);
    }

    @Test
    public void loginWithEmPtyPasswordTest() throws InterruptedException {
        Thread.sleep(2000);
        LoginPage newLoginPage = loginPage.loginInvalidCreds("vihard.test+org77@gmail.com", "");
        Thread.sleep(2000);
        String error = newLoginPage.getErrorAuthTextPassword();
        Assert.assertEquals("password is a required field", error);
    }

    @Test
    public void createAccTest()throws InterruptedException {
        Thread.sleep(2000);
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Sign Up", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
