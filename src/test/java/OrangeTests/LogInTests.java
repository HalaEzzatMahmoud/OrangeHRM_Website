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

        loginPage.loginData("Admin","admin").loginClick()
                .invalidMessages();

    }

    /*@Test
    public void logInWrongUsername(){
        logInPageObject = new LogInPage(driver);
        logInPageObject.setLogInInfo("UserName","admin123");
        //logInPageObject.assertMessages("Invalid credentials");
    }

    @Test
    public void logInUsernameEmptyInput(){
        logInPageObject = new LogInPage(driver);
        logInPageObject.setLogInInfo("","admin123");
        Assert.assertEquals(logInPageObject.requiredUsername.getText(),"Required");
    }

    @Test
    public void logInPasswordEmptyInput(){
        logInPageObject = new LogInPage(driver);
        logInPageObject.setLogInInfo("Admin","");
        Assert.assertEquals(logInPageObject.requiredPassword.getText(),"Required");
    }

    @Test
    public void logInEmptyInputs(){
        logInPageObject = new LogInPage(driver);
        logInPageObject.setLogInInfo("","");
        Assert.assertEquals(logInPageObject.requiredUsername.getText(),"Required");
        Assert.assertEquals(logInPageObject.requiredPassword.getText(),"Required");
    }*/





}
