package OrangeTests;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordTests extends TestBase {


    @BeforeMethod
    public void LoginPrecondition(){

        loginPage.loginData("Admin","admin123").loginClick()
                .waitForDashboard();
    }

    @Test
    public void changePassword(){

        homePage.waitForMenuAndClick().clickChangePassword().waitSaveButton()
                .newPassword("admin123","3la3lo581995").clickSave().waitForSuccesChanges();
    }
}
