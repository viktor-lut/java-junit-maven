import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setp() {
        System.setProperty("webdriver.gecko.driver", "F:\\Attract\\Vizable\\auto-tests\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1680, 1050));
        driver.get("https://app.vizable-u-dev.php-cd.attractgroup.com/sign-up");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void setSignUpEmptyName() {
        String sp = signUpPage.getHeadingText();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
