package OrangeTests;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.Test;



public class LogInTests extends TestBase {

    @Test
    public void logInSuccessfully(){

            loginPage.loginData("Admin","admin123").loginClick().waitForDashboard()
                    .waitForMenuAndClick().clickLogout().waitForLogin();

    }

    @Test
    public void invalidLogin(){

        loginPage.loginData("Hala","khtfy").loginClick()
                .invalidMessages();
    }

    @Test
    public void invalidPassword(){
        loginPage.loginData("Hala","khtfy").loginClick()
                .invalidMessages();
    }


    @Test
    public void invalidUsername(){
        loginPage.loginData("Hala","admin123").loginClick()
                .invalidMessages();
    }

    @Test
    public void emptyFieldUsername(){
        loginPage.loginData("","admin123").loginClick()
                .usernameEmpty();
    }

    @Test
    public void emptyFieldPassword(){
        loginPage.loginData("Admin","").loginClick()
                .passwordEmpty();
    }

    @Test
    public void bothFieldsEmpty(){
        loginPage.loginData("","").loginClick()
                .emptyFields();
    }

}
