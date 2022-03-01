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
import pages.CreateGallery;

import java.io.IOException;
import java.time.Duration;

public class TestCreateGallery {
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
     *  This test tests creating new gallery.
     *
     *  Test steps:
     *  1. Go to : https://gallery-app.vivifyideas.com
     *  2. Login with valid user
     *  3. Click Create Gallery
     *  4. Enter all the fields regulary
     *  5. Click Submit
     *  3. Assert that created gallery id displayed in All Galleries
     * @throws IOException
     */

    @Test(dataProvider = "test")
    public void TestCreateGallery(String email, String password) {

        wd.get("https://gallery-app.vivifyideas.com/");
        wd.manage().window().maximize();

        CreateGallery create = new CreateGallery(wd);

        create.clickOnLogin();
        create.enterEmail(email);
        create.enterPassword(password);
        create.clickOnSubmitButton();
        create.clickOnCreateGallery();
        create.enterTitle();
        create.enterDescription();
        create.enterImageUrl();
        create.clickSubmit();
        create.clickOnMyGallery();


        Assert.assertTrue(create.galleryIsDisplayed(), "New Gallery should be displayed.");

        create.clickOnLogout();

    }
}
