package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.UserLoginPUI;

public class UserLoginPO extends BasePage {
    private WebDriver driver;

    public UserLoginPO(WebDriver driver){
        this.driver = driver;
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementClickable(driver, UserLoginPUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserLoginPUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementClickable(driver, UserLoginPUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserLoginPUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton(){
        waitForElementClickable(driver, UserLoginPUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPUI.LOGIN_BUTTON);
    }

    public UserHomePO loginToSystem(String emailAddress, String password) {
        enterToEmailTextbox(emailAddress);
        enterToPasswordTextbox(password);
        clickToLoginButton();
        return PageGenerator.getUserHomePage(driver);
    }
}
