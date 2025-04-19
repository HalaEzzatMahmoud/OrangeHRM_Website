package OrangeTests;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.Test;



public class LogInTests extends TestBase {

    @Test(priority = 2)
    public void logInSuccessfully(){

            loginPage.loginData("Admin","admin123");
            loginPage.loginSubmit();
            wait.until(ExpectedConditions.urlContains("dashboard"));

    }

    @Test(priority = 1)
    public void invalidLogin(){

        loginPage.loginData("Admin","admin");
        loginPage.loginSubmit();
        loginPage.invalidMessages();

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
