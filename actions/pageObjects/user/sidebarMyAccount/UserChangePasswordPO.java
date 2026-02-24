package pageObjects.user.sidebarMyAccount;

import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.user.UserHomePO;
import pageUIs.user.sidebarMyAccount.UserChangePasswordPUI;
import pageUIs.user.sidebarMyAccount.UserCustomerInfoPUI;

public class UserChangePasswordPO extends UserMyAccountPO {
    private WebDriver driver;

    public UserChangePasswordPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToOldPasswordTextbox(String oldPassword) {
        waitForElementVisible(driver, UserChangePasswordPUI.OLD_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserChangePasswordPUI.OLD_PASSWORD_TEXTBOX, oldPassword);
    }

    public void enterToNewPasswordTextbox(String newPassword) {
        waitForElementVisible(driver, UserChangePasswordPUI.NEW_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserChangePasswordPUI.NEW_PASSWORD_TEXTBOX, newPassword);
    }

    public void enterToConfirmNewPasswordTextbox(String confirmNewPassword) {
        waitForElementVisible(driver, UserChangePasswordPUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserChangePasswordPUI.CONFIRM_NEW_PASSWORD_TEXTBOX, confirmNewPassword);

    }

    public void clickToChangePasswordButton() {
        waitForElementClickable(driver, UserChangePasswordPUI.CHANGE_PASSWORD_TEXTBOX);
        clickToElement(driver, UserChangePasswordPUI.CHANGE_PASSWORD_TEXTBOX);
    }

    public String getUpdateSuccessMessage() {
        waitForElementVisible(driver, UserChangePasswordPUI.UPDATE_SUCCESS_MESSAGE);
        return getElementText(driver, UserChangePasswordPUI.UPDATE_SUCCESS_MESSAGE);
    }

    public void clickToCloseIcon() {
        waitForElementClickable(driver, UserChangePasswordPUI.CLOSE_ICON);
        clickToElement(driver, UserChangePasswordPUI.CLOSE_ICON);
    }

    public UserHomePO clickToLogoutLink() {
        waitForElementClickable(driver, UserChangePasswordPUI.LOGOUT_LINK);
        clickToElement(driver, UserChangePasswordPUI.LOGOUT_LINK);
        return PageGenerator.getUserHomePage(driver);
    }

    public void waitForNotificationBarInvisible() {
        waitForElementInvisible(driver, UserChangePasswordPUI.NOTIFICATION_BAR);
    }
}
