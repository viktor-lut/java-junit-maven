import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "F:\\Attract\\Vizable\\auto-tests\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1680, 1050));
        driver.get("https://app.vizable-u-dev.php-cd.attractgroup.com/");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signInForm() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign In", heading);
    }

    @Test
    public void signUpForm() throws InterruptedException {
        LoginPage loginPage = mainPage.clickSignIn();
        Thread.sleep(3000);
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Sign Up", heading);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
