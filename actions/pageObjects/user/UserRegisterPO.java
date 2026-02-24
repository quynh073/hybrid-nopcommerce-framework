package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.UserRegisterPUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver){
        this.driver = driver;
    }
    public void clickToGenderRadio(String gender) {
        waitForElementClickable(driver, UserRegisterPUI.GENDER_MALE_RADIO);
        clickToElement(driver, UserRegisterPUI.GENDER_MALE_RADIO, gender);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserRegisterPUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserRegisterPUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, UserRegisterPUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPUI.EMAIL_TEXTBOX, email);
    }

    public void enterToCompanyNameTextbox(String companyName) {
        waitForElementVisible(driver, UserRegisterPUI.COMPANY_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, UserRegisterPUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPUI.REGISTER_BUTTON);    }

    public String getRegisterSuccessMessage() {
        return getElementText(driver, UserRegisterPUI.REGISTER_SUCCESS_MESSAGE);
    }

    public UserHomePO clickToLogoutLink() {
        waitForElementClickable(driver, UserRegisterPUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPUI.LOGOUT_LINK);
        return PageGenerator.getUserHomePage(driver);
    }


    public String getFirstNameErrorMessage() {
        return getElementText(driver, UserRegisterPUI.FIRST_NAME_ERROR_MESSAGE);
    }

    public String getLastNameErrorMessage() {
        return getElementText(driver, UserRegisterPUI.LAST_NAME_ERROR_MESSAGE);
    }

    public String getEmailErrorMessage() {
        return getElementText(driver, UserRegisterPUI.EMAIL_ERROR_MESSAGE);

    }

    public String getPasswordErrorMessage() {
        return getElementText(driver, UserRegisterPUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getConfirmPasswordErrorMessage() {
        return getElementText(driver, UserRegisterPUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public String getEmailExsitErrorMessage() {
        return getElementText(driver, UserRegisterPUI.EMAIL_EXIST_ERROR_MESSAGE);
    }


}
