package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserCustomerInfoPUI;

public class UserCustomerInfoPO extends UserSidebarPO {
    private WebDriver driver;

    public UserCustomerInfoPO(WebDriver driver){
        super(driver);
        this.driver =driver;
    }

    public boolean isGenderRadioSelected() {
        waitForElementSelected(driver, UserCustomerInfoPUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPUI.GENDER_MALE_RADIO);
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
}
