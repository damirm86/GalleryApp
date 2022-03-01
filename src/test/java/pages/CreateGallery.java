package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateGallery {
    private WebDriver wd;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/nav[1]/div[1]/ul[2]/li[1]/a[1]")
    WebElement loginButton;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
    WebElement email;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
    WebElement password;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/form[1]/button[1]")
    WebElement submitButton;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[3]/a[1]")
    WebElement createGallery;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")
    WebElement title;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]")
    WebElement description;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/input[1]")
    WebElement imageUrl;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")
    WebElement submit;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement myGallery;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]")
    WebElement gallery;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/nav[1]/div[1]/ul[2]/li[3]/a[1]")
    WebElement logoutButton;

    public CreateGallery(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public void enterEmail(String e) {
        email.clear();
        email.sendKeys(e);
    }

    public void enterPassword(String p) {
        password.clear();
        password.sendKeys(p);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void clickOnCreateGallery() {
        createGallery.click();
    }

    public void enterTitle() {
        title.clear();
        title.sendKeys("New gallery");
    }

    public void enterDescription() {
        description.clear();
        description.sendKeys("New pictures");
    }

    public void enterImageUrl() {
        imageUrl.clear();
        imageUrl.sendKeys("https://upload.wikimedia.org/wikipedia/commons/5/54/Halterstandingshotarabianone.jpg");
    }

    public void clickSubmit() {
        submit.click();
    }

    public void clickOnMyGallery() {
        myGallery.click();
    }

    public void clickOnLogout() {
        logoutButton.click();
    }

    public boolean galleryIsDisplayed() {
        return gallery.isDisplayed();
    }
}
