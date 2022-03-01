package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver wd;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/nav[1]/div[1]/ul[2]/li[1]/a[1]")
    WebElement loginButton;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
    WebElement email;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
    WebElement password;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/button[1]")
    WebElement submitButton;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/nav[1]/div[1]/ul[2]/li[3]/a[1]")
    WebElement logoutButton;


    public Login(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }


    public void clickOnLogin() {
        loginButton.click();
    }

    public void enterEmail(String em) {
        email.clear();
        email.sendKeys(em);
    }

    public void enterPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void clickOnSubmit() {
        submitButton.click();
    }

    public boolean logoutIsDisplayed() {
        return logoutButton.isDisplayed();
    }

    public void clickOnLogout() {
        logoutButton.click();
    }

}
