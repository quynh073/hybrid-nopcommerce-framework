package pageObjects.user.sidebarMyAccount;

import org.openqa.selenium.WebDriver;
import pageUIs.user.sidebarMyAccount.UserCustomerInfoPUI;

public class UserCustomerInfoPO extends UserMyAccountPO {
    private WebDriver driver;

    public UserCustomerInfoPO(WebDriver driver){
        super(driver);
        this.driver =driver;
    }

    public boolean isGenderRadioSelected(String gender) {
        waitForElementSelected(driver, UserCustomerInfoPUI.GENDER_RADIO, gender);
        return isElementSelected(driver, UserCustomerInfoPUI.GENDER_RADIO, gender);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPUI.COMPANY_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPUI.COMPANY_NAME_TEXTBOX, "value");
    }

    public void clickToGenderRadio(String gender) {
        waitForElementClickable(driver, UserCustomerInfoPUI.GENDER_RADIO, gender);
        clickToElement(driver, UserCustomerInfoPUI.GENDER_RADIO, gender);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserCustomerInfoPUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserCustomerInfoPUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserCustomerInfoPUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserCustomerInfoPUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, UserCustomerInfoPUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserCustomerInfoPUI.EMAIL_TEXTBOX, email);
    }

    public void enterToCompanyNameTextbox(String companyName) {
        waitForElementVisible(driver, UserCustomerInfoPUI.COMPANY_NAME_TEXTBOX);
        sendKeyToElement(driver, UserCustomerInfoPUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserCustomerInfoPUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserCustomerInfoPUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, UserCustomerInfoPUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserCustomerInfoPUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, UserCustomerInfoPUI.SAVE_BUTTON);
        clickToElement(driver, UserCustomerInfoPUI.SAVE_BUTTON);
    }


}
