package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.UserSidebarPUI;

public class UserSidebarPO extends BasePage {
    private WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

//    public UserAddressPO openAddressPage() {
//        waitForElementVisible(driver, UserSidebarPageUI.ADDRESS_LINK);
//        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
//        return PageGenerator.getUserAddressPage(driver);
//    }
//
//
//    public UserRewardPointPO openRewardPointPage() {
//        waitForElementVisible(driver, UserSidebarPageUI.REWARD_POINT_LINK);
//        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
//        return PageGenerator.getUserRewardPointPage(driver);
//    }
//
//
//    public UserOrderPO openOrderPage() {
//        waitForElementVisible(driver, UserSidebarPageUI.ORDER_LINK);
//        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
//        return PageGenerator.getUserOrderPage(driver);
//    }
//
//    public UserCustomerInfoPO openCustomerInfoPage() {
//        waitForElementVisible(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
//        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
//        return PageGenerator.getUserCustomerInfoPage(driver);
//    }

    public UserSidebarPO openSidebarLinkByName(String pageName){
        waitForElementVisible(driver, UserSidebarPUI.DYNAMIC_LINK_PAGE_NAME, pageName);
        clickToElement(driver, UserSidebarPUI.DYNAMIC_LINK_PAGE_NAME, pageName);
        switch (pageName){
            case "Customer info":
                return PageGenerator.getUserCustomerInfoPage(driver);
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
            case "Reward points":
                return PageGenerator.getUserRewardPointPage(driver);
            default:
                throw new RuntimeException("Page name is not valid!!!");
        }
    }

    public void openSidebarLinkByNames(String pageName){
        waitForElementVisible(driver, UserSidebarPUI.DYNAMIC_LINK_PAGE_NAME, pageName);
        clickToElement(driver, UserSidebarPUI.DYNAMIC_LINK_PAGE_NAME, pageName);
    }
}
