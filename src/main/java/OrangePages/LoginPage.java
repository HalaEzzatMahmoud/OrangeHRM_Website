package OrangePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //WebElements
    private By USERNAME = By.name("username");
    private By PASSWORD = By.name("password");
    private By LOGIN_BTN = By.xpath("//*[@type=\"submit\"]");

    private By INVALID_MESSAGE = By.cssSelector("p.oxd-alert-content-text");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds((120)));
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


}
