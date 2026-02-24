package pageObjects.user.sidebarMyAccount;

import org.openqa.selenium.WebDriver;
import pageUIs.user.sidebarMyAccount.UserAddressesPUI;
import pageUIs.user.sidebarMyAccount.UserCustomerInfoPUI;

import java.util.List;

public class UserAddressesPO extends UserMyAccountPO {
    private WebDriver driver;

    public UserAddressesPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddNewButton() {
        waitForElementClickable(driver, UserAddressesPUI.ADD_NEW_BUTTON);
        clickToElement(driver, UserAddressesPUI.ADD_NEW_BUTTON);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserAddressesPUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserAddressesPUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, UserAddressesPUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPUI.EMAIL_TEXTBOX, email);
    }

    public void enterToCompanyTextbox(String company) {
        waitForElementVisible(driver, UserAddressesPUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPUI.COMPANY_TEXTBOX, company);
    }

    public void selectCountryDropdown(String country) {
        waitForElementClickable(driver, UserAddressesPUI.COUNTRY_DROPDOWN_PARENT);
        selectItemCustomDropdown(driver, UserAddressesPUI.COUNTRY_DROPDOWN_PARENT, UserAddressesPUI.COUNTRY_DROPDOWN_CHILD, country);
    }

    public void selectStateProvinceDropdown(String province) {
        waitForElementClickable(driver, UserAddressesPUI.STATE_PROVINCE_PARENT);
        selectItemCustomDropdown(driver, UserAddressesPUI.STATE_PROVINCE_PARENT, UserAddressesPUI.STATE_PROVINCE_CHILD, province);
    }

    public void enterToCityTextbox(String city) {
        waitForElementVisible(driver, UserAddressesPUI.CITY_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPUI.CITY_TEXTBOX, city);
    }

    public void enterToAddress1Textbox(String addresses1) {
        waitForElementVisible(driver, UserAddressesPUI.ADDRESS1_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPUI.ADDRESS1_TEXTBOX, addresses1);
    }

    public void enterToAddress2Textbox(String addresses2) {
        waitForElementVisible(driver, UserAddressesPUI.ADDRESS2_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPUI.ADDRESS2_TEXTBOX, addresses2);
    }

    public void enterToZipPostalCodeTextbox(String zipPostalCode) {
        waitForElementVisible(driver, UserAddressesPUI.ZIP_POSTAL_CODE_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPUI.ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
    }

    public void enterToPhoneNumberTextbox(String phoneNumber) {
        waitForElementVisible(driver, UserAddressesPUI.PHONE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
    }

    public void enterToFaxNumberTextbox(String faxNumber) {
        waitForElementVisible(driver, UserAddressesPUI.FAX_NUMBER_TEXTBOX);
        sendKeyToElement(driver, UserAddressesPUI.FAX_NUMBER_TEXTBOX, faxNumber);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, UserAddressesPUI.SAVE_BUTTON);
        clickToElement(driver, UserAddressesPUI.SAVE_BUTTON);
    }

    public String getUpdateSuccessMessage() {
        waitForElementVisible(driver, UserAddressesPUI.UPDATE_SUCCESS_MESSAGE);
        return getElementText(driver, UserAddressesPUI.UPDATE_SUCCESS_MESSAGE);
    }

    public List<String> getTextByClass(String name) {
        waitForElementVisible(driver, UserAddressesPUI.ADD_INFORMATION, name);
        return getAllElementText(driver, UserAddressesPUI.ADD_INFORMATION, name);
    }
}
