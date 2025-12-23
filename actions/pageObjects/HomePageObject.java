package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }

    public boolean isMyAccountLinkDisplayed() {
        return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
    }
}
