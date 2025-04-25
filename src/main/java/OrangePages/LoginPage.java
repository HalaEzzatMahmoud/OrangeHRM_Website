package OrangePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    SoftAssert assert1;

    //WebElements
    static By USERNAME = By.name("username");
    static By PASSWORD = By.name("password");
    static By LOGIN_BTN = By.xpath("//*[@type=\"submit\"]");

    static By INVALID_MESSAGE = By.cssSelector("p.oxd-alert-content-text");

    static By EMPTY_USERNAME = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");
    static By EMPTY_PASSWORD = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span");
    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds((120)));
        assert1 = new SoftAssert();
    }

    //Login Methods
    public LoginPage loginData(String username,String password){

        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        return new LoginPage(driver);
    }

    public LoginPage waitLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN));
        return new LoginPage(driver) ;
    }

    public LoginPage loginClick(){
        driver.findElement(LOGIN_BTN).click();
        return new LoginPage(driver);
    }

    public void invalidMessages(){
        wait.until(ExpectedConditions.presenceOfElementLocated(INVALID_MESSAGE));
        System.out.println(driver.findElement(INVALID_MESSAGE).getText());

    }

    public HomePage waitForDashboard(){
        wait.until(ExpectedConditions.urlContains("dashboard"));
        return new HomePage(driver);
    }

    public void usernameEmpty(){
        wait.until(ExpectedConditions.presenceOfElementLocated(EMPTY_USERNAME));
        assert1.assertEquals(driver.findElement(EMPTY_USERNAME).getText(),"Required");
    }

    public void passwordEmpty(){
        wait.until(ExpectedConditions.presenceOfElementLocated(EMPTY_PASSWORD));
        assert1.assertEquals(driver.findElement(EMPTY_PASSWORD).getText(),"Required");
    }

    public void emptyFields(){
        usernameEmpty();
        passwordEmpty();

    }
}
