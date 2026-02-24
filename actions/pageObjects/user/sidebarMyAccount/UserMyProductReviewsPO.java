package pageObjects.user.sidebarMyAccount;

import org.openqa.selenium.WebDriver;
import pageUIs.user.sidebarMyAccount.UserMyProductReviewsPUI;

import java.util.List;

public class UserMyProductReviewsPO extends UserMyAccountPO {
    private WebDriver driver;

    public UserMyProductReviewsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<String> getReviewTitle() {
        waitForElementVisible(driver, UserMyProductReviewsPUI.REVIEW_TITLE);
        return getAllElementText(driver, UserMyProductReviewsPUI.REVIEW_TITLE);
    }

    public List<String> getReviewText() {
        waitForElementVisible(driver, UserMyProductReviewsPUI.REVIEW_TEXT);
        return getAllElementText(driver, UserMyProductReviewsPUI.REVIEW_TEXT);
    }

    public List<String> getReviewInfo() {
        waitForElementVisible(driver, UserMyProductReviewsPUI.REVIEW_INFO);
        return getAllElementText(driver, UserMyProductReviewsPUI.REVIEW_INFO);
    }
}
