package OrangePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ChangePasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert assert1;

    static By CURRENT_PASSWORD = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/input");
    static By NEW_PASSWORD = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    static By CONFIRM_PASSWORD = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    static By SAVE_CHANGES = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    static By SUCCESS_CHANGES = By.id("oxd-toaster_1");


    public ChangePasswordPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        assert1 = new SoftAssert();
    }

    public ChangePasswordPage newPassword(String currentPassword,String newPassword){
        driver.findElement(CURRENT_PASSWORD).sendKeys(currentPassword);
        driver.findElement(NEW_PASSWORD).sendKeys(newPassword);
        driver.findElement(CONFIRM_PASSWORD).sendKeys(newPassword);

        return new ChangePasswordPage(driver);
    }

    public ChangePasswordPage clickSave(){
        driver.findElement(SAVE_CHANGES).click();
        return new ChangePasswordPage(driver);
    }

    public ChangePasswordPage waitSaveButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_CHANGES));
        return new ChangePasswordPage(driver);
    }

    public void waitForSuccesChanges(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CHANGES));
    }
}
