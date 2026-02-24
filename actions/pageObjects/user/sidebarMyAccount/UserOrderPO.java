package pageObjects.user.sidebarMyAccount;

import org.openqa.selenium.WebDriver;

public class UserOrderPO extends UserMyAccountPO {
    private WebDriver driver;

    public UserOrderPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
