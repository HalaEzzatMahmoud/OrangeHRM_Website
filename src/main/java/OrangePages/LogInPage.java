package OrangePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage  extends PageBase{

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input.oxd-input.oxd-input--active")
    WebElement usernameTxt;

    @FindBy(css = "input.oxd-input.oxd-input--active")
    WebElement passwordTxt;

    @FindBy(css = "button.oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
    WebElement loginBtn;

    public void setLogInInfo(String username,String password){
        setTextElement(usernameTxt,username);
        setTextElement(passwordTxt,password);
        clickBtn(loginBtn);
    }
}
