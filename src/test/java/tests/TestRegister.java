package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Register;

import java.io.IOException;
import java.time.Duration;

public class TestRegister {
    private WebDriver wd;
    Faker faker;

    // Data provider is used to create new users account in combination with faker
    @DataProvider(name = "test")
    public Object[][] test() {
        faker = new Faker();

        return new Object[][]{
                {faker.name().firstName(), faker.name().lastName() , faker.number().randomNumber()+ "user@yahoo.com",
                        "pass123#", "pass123#"},
                {faker.name().firstName(), faker.name().lastName(), faker.number().randomNumber()+ "user@google.com",
                        "pass123#", "pass123#"},
                {faker.name().firstName(), faker.name().lastName(), faker.number().randomNumber()+ "user@hotmail.com",
                        "pass123#", "pass123#"},
                {faker.name().firstName(), faker.name().lastName(), faker.number().randomNumber()+ "user@ymail.com",
                        "pass123#", "pass123#"},
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
     * This test tests new user registration with valid input data
     * <p>
     * Test steps:
     * 1. Go to : https://gallery-app.vivifyideas.com/register
     * 2. Use data provider for enter all the fields
     * 3. Check the "Accepted terms and conditions"
     * 4. Click "Submit" button
     * 5. Assert that registering was successfull
     *
     * @throws IOException
     */

    @Test(dataProvider = "test")
    public void Register(String f, String l, String e, String p, String cp) {


        wd.get("https://gallery-app.vivifyideas.com/register");
        wd.manage().window().maximize();

        Register reg1 = new Register(wd);

        reg1.enterFirstName(f);
        reg1.enterLastName(l);
        reg1.enterEmail(e);
        reg1.enterPassword(p);
        reg1.enterConfirmedPassword(cp);
        reg1.clickOnAccept();
        reg1.clickOnSubmit();


        Assert.assertTrue(reg1.logoutIsDisplayed(), "Logout button should be displayed");

        reg1.clickOnLogout();

    }

}