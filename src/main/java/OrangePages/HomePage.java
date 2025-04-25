package OrangePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    static By MENU = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i");
    static By LOGOUT = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a");

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    public HomePage waitForMenuAndClick(){
        wait.until(ExpectedConditions.elementToBeClickable(MENU)).click();
        return new HomePage(driver);
    }

    public HomePage clickLogout(){
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT)).click();
        return new HomePage(driver);
    }

    public void waitForLogin(){
        wait.until(ExpectedConditions.urlContains("login"));
    }
}
