package base;


import OrangePages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;

    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    @Parameters({"browser"})
    public void SetUpEnv(@Optional("chrome") String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        loginPage = new LoginPage(driver,wait);
        loginPage.waitLoginButton();

    }


    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
