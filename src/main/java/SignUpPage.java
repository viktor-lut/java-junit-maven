import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

        WebDriver driver;

        public SignUpPage(WebDriver driver) {
            this.driver = driver;
        }

        private By heading = By.xpath("//div[@class='authorizeBLock']//h1");
        private By nameField = By.xpath("//input[@name='organization_name']//div");
        private By nameFieldError = By.cssSelector("p.MuiFormHelperText-root.MuiFormHelperText-contained.Mui-error");
        private By typeOrganisaionField = By.xpath("//input[@name='organization_type_clarification']//div");
        private By emailField = By.xpath("//input[@name='email']//div");
        private By webSiteField = By.xpath("//input[@name='web_site']//div");
        private By regNumberField = By.xpath("//input[@name='registration_number']//div");
        private By postcodeField = By.xpath("//input[@name='postcode']//div");
        private By passwordField = By.xpath("//input[@name='password']//div");

        private By nextButton = By.xpath("//button[@type='submit']");


        public SignUpPage signUpNextButtonPress() {
                driver.findElement(nextButton).click();
                return this;
        }

        public String getHeadingText(){
                return driver.findElement(heading).getText();
        }

        public SignUpPage typeName(String username){
                driver.findElement(nameField).sendKeys(username);
                return this;
        }

        public SignUpPage typeType(String type){
                driver.findElement(typeOrganisaionField).sendKeys(type);
                return this;
        }

        public SignUpPage typeEmail(String email){
                driver.findElement(emailField).sendKeys(email);
                return this;
        }

        public SignUpPage typeWebsite(String website){
                driver.findElement(webSiteField).sendKeys(website);
                return this;
        }

        public SignUpPage typeRegNumber(String regnumber){
                driver.findElement(regNumberField).sendKeys(regnumber);
                return this;
        }

        public SignUpPage typePostCode(String postcode){
                driver.findElement(postcodeField).sendKeys(postcode);
                return this;

        }

        public SignUpPage typePassword(String password){
                driver.findElement(passwordField).sendKeys(password);
                return this;

        }

        public SignUpPage signUpInvalidCreds(String username, String type, String email, String webswite, String regnumber, String postcode, String password) {
                this.typeName(username);
                this.typeName(type);
                this.typeName(email);
                this.typeName(webswite);
                this.typeName(regnumber);
                this.typeName(postcode);
                this.typePassword(password);
                driver.findElement(nextButton).click();
                return new SignUpPage(driver);
        }

}
