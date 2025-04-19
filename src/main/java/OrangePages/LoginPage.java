package OrangePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //WebElements
    private By USERNAME = By.name("username");
    private By PASSWORD = By.name("password");
    private By LOGIN_BTN = By.xpath("//*[@type=\"submit\"]");

    private By INVALID_MESSAGE = By.cssSelector("p.oxd-alert-content-text");

    //Constructor
    public LoginPage(WebDriver driver,WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Login Methods
    public void loginData(String username,String password){

        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void loginSubmit(){
        driver.findElement(LOGIN_BTN).click();
    }


    public void waitLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BTN));
    }

    public void invalidMessages(){
        wait.until(ExpectedConditions.presenceOfElementLocated(INVALID_MESSAGE));

    }
}
