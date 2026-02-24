package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.user.sidebarMyAccount.UserMyAccountPO;
import pageUIs.user.UserHomePUI;
import pageUIs.user.UserProductDetailPUI;
import pageUIs.user.sidebarMyAccount.UserChangePasswordPUI;
import pageUIs.user.sidebarMyAccount.UserCustomerInfoPUI;

public class UserProductDetailPO extends BasePage {
    private WebDriver driver;

    public UserProductDetailPO(WebDriver driver){
        this.driver = driver;
    }

    public void clickToAddYourReviewLink() {
        waitForElementClickable(driver, UserProductDetailPUI.ADD_REVIEW_LINK);
        clickToElement(driver, UserProductDetailPUI.ADD_REVIEW_LINK);
    }

    public void enterToReviewTitleTextbox(String reviewTitle) {
        waitForElementVisible(driver, UserProductDetailPUI.REVIEW_TITLE_TEXTBOX);
        sendKeyToElement(driver, UserProductDetailPUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void enterToReviewTextTextbox(String reviewText) {
        waitForElementVisible(driver, UserProductDetailPUI.REVIEW_TEXT_TEXTBOX);
        sendKeyToElement(driver, UserProductDetailPUI.REVIEW_TEXT_TEXTBOX, reviewText);

    }

    public void clickToRatingCheckbox(String rating) {
        waitForElementClickable(driver, UserProductDetailPUI.RATE_CHECKBOX, rating);
        clickToElement(driver, UserProductDetailPUI.RATE_CHECKBOX, rating);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, UserProductDetailPUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, UserProductDetailPUI.SUBMIT_REVIEW_BUTTON);
    }

    public String getUpdateSuccessMessage() {
        waitForElementVisible(driver, UserProductDetailPUI.UPDATE_SUCCESS_MESSAGE);
        return getElementText(driver, UserProductDetailPUI.UPDATE_SUCCESS_MESSAGE);
    }

    public void clickToCloseIcon() {
        waitForElementClickable(driver, UserProductDetailPUI.CLOSE_ICON);
        clickToElement(driver, UserProductDetailPUI.CLOSE_ICON);
    }

    public UserMyAccountPO openMyAccountPage() {
        waitForElementClickable(driver, UserProductDetailPUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserProductDetailPUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserMyAccountPage(driver);
    }

    public void waitForNotificationBarInvisible() {
        waitForElementInvisible(driver, UserProductDetailPUI.NOTIFICATION_BAR);
    }
}
