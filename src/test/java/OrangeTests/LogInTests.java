package OrangeTests;

import OrangePages.LogInPage;
import org.testng.annotations.Test;

public class LogInTests extends TestBase{

    LogInPage logInPageObject;

    @Test
    public void logInSuccessfully(){
        logInPageObject = new LogInPage(driver);
        logInPageObject.setLogInInfo("Admin","admin123");

    }


}
