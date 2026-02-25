package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.user.sidebarMyAccount.UserCustomerInfoPO;
import pageObjects.user.sidebarMyAccount.UserMyAccountPO;
import pageUIs.user.UserHomePUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;

    public UserHomePO(WebDriver driver){
        this.driver = driver;
    }

    public UserRegisterPO openRegisterPage() {
        waitForElementClickable(driver, UserHomePUI.REGISTER_LINK);
        clickToElement(driver, UserHomePUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

    public UserLoginPO openLoginPage() {
        waitForElementClickable(driver, UserHomePUI.LOGIN_LINK);
        clickToElement(driver, UserHomePUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

    public boolean isMyAccountLinkDisplayed() {
        return isElementDisplayed(driver, UserHomePUI.MY_ACCOUNT_LINK);
    }

    public UserMyAccountPO openMyAccountPage() {
        waitForElementClickable(driver, UserHomePUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserMyAccountPage(driver);
    }

    public void enterToSearchTextbox(String keyWord) {
        waitForElementVisible(driver, UserHomePUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, UserHomePUI.SEARCH_TEXTBOX, keyWord);
    }

    public void clickToSearchButton() {
        waitForElementVisible(driver, UserHomePUI.SEARCH_BUTTON);
        clickToElement(driver, UserHomePUI.SEARCH_BUTTON);
    }

    public void hoverToHeaderMenuByText(String topMenuItemName) {
        waitForElementVisible(driver, UserHomePUI.TOP_MENU_LINK, topMenuItemName);
        hoverToElement(driver, UserHomePUI.TOP_MENU_LINK, topMenuItemName);
    }

    public void clickToSubMenuByText(String topMenuItemName, String subMenuItemName) {
        waitForElementVisible(driver, UserHomePUI.SUB_MENU_LINK, topMenuItemName, subMenuItemName);
        clickToElement(driver, UserHomePUI.SUB_MENU_LINK, topMenuItemName, subMenuItemName);
    }
}
