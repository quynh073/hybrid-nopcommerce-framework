package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.SidebarPageUI;

public class SidebarPageObject extends BasePage {
    private WebDriver driver;

    public SidebarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddressPageObject openAddressPage() {
        waitForElementVisible(driver, SidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, SidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }


    public RewardPointPageObject openRewardPointPage() {
        waitForElementVisible(driver, SidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, SidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPointPage(driver);
    }


    public OrderPageObject openOrderPage() {
        waitForElementVisible(driver, SidebarPageUI.ORDER_LINK);
        clickToElement(driver, SidebarPageUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        waitForElementVisible(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getCustomerInfoPage(driver);
    }
}
