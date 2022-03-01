package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {

    private WebDriver wd;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
    WebElement firstName;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
    WebElement lastName;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/div[3]/input[1]")
    WebElement email;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/div[4]/input[1]")
    WebElement password;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/div[5]/input[1]")
    WebElement confirmedPassword;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/div[6]/input[1]")
    WebElement termsAndConditions;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/button[1]")
    WebElement submit;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/nav[1]/div[1]/ul[2]/li[3]/a[1]")
    WebElement logout;




    public Register(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    public void enterFirstName(String fname) {
        this.firstName.clear();
        this.firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        this.lastName.clear();
        this.lastName.sendKeys(lname);
    }

    public void enterEmail(String mail) {
        this.email.clear();
        this.email.sendKeys(mail);
    }

    public void enterPassword(String pass) {
        this.password.clear();
        this.password.sendKeys(pass);
    }

    public void enterConfirmedPassword(String cpass) {
        this.confirmedPassword.clear();
        this.confirmedPassword.sendKeys(cpass);
    }

    public void clickOnAccept() {
        this.termsAndConditions.click();
    }

    public void clickOnSubmit() {
        this.submit.click();
    }

    public boolean logoutIsDisplayed() {
        return logout.isDisplayed();
    }

    public void clickOnLogout() {
        this.logout.click();
    }

}
