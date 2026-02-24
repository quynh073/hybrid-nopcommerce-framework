package pageObjects.user.sidebarMyAccount;

import org.openqa.selenium.WebDriver;

public class UserRewardPointPO extends UserMyAccountPO {
    private WebDriver driver;

    public UserRewardPointPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
