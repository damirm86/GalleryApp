package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;
import java.time.Duration;

public class TestLogin {
    private WebDriver wd;

    //// Data provider is used to enter the login fields

    @DataProvider(name = "test")
    public Object[][] test() {

        return new Object[][]{
                {"16user@ymail.com", "pass123#"}, {"644865user@google.com", "pass123#"}, {"ludi_s@xxx.com", "ludak123"},
        };
    }

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");

        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void zatvoriWebDriver() {
        wd.close();
    }

    /**
     *  This test tests logging in with valid user.
     *
     *  Test steps:
     *  1. Go to : https://gallery-app.vivifyideas.com
     *  2. Login with valid user
     *  3. Assert that Logout button is present
     * @throws IOException
     */

    @Test(dataProvider = "test")
    public void TestLogin(String email, String password) {

        wd.get("https://gallery-app.vivifyideas.com/");
        wd.manage().window().maximize();

        Login log1 = new Login(wd);

        log1.clickOnLogin();
        log1.enterEmail(email);
        log1.enterPassword(password);
        log1.clickOnSubmit();

        Assert.assertTrue(log1.logoutIsDisplayed(), "Logout button should be displayed.");

        log1.clickOnLogout();

    }
}
