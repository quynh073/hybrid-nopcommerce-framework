package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.user.*;
import pageObjects.user.footer.UserSearchPO;
import pageObjects.user.sidebarMyAccount.*;

public class PageGenerator {
    public static UserHomePO getUserHomePage(WebDriver driver){
        return new UserHomePO(driver);
    }

    public static UserLoginPO getUserLoginPage(WebDriver driver){
        return new UserLoginPO(driver);
    }

    public static UserRegisterPO getUserRegisterPage(WebDriver driver){
        return new UserRegisterPO(driver);
    }

    public static UserMyAccountPO getUserMyAccountPage(WebDriver driver){
        return new UserMyAccountPO(driver);
    }

    public static UserAddressesPO getUserAddressPage(WebDriver driver){
        return new UserAddressesPO(driver);
    }

    public static UserOrderPO getUserOrderPage(WebDriver driver){
        return new UserOrderPO(driver);
    }


    public static UserRewardPointPO getUserRewardPointPage(WebDriver driver){
        return new UserRewardPointPO(driver);
    }

    public static AdminLoginPO getAdminLoginPage(WebDriver driver){
        return new AdminLoginPO(driver);
    }

    public static AdminDashboardPO getAdminDasboardPage(WebDriver driver){
        return new AdminDashboardPO(driver);
    }

    public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
        return new UserCustomerInfoPO(driver);
    }

    public static UserChangePasswordPO getUserChangePasswordPage(WebDriver driver) {
        return new UserChangePasswordPO(driver);
    }

    public static UserMyProductReviewsPO getUserMyProductReviewsPage(WebDriver driver) {
        return new UserMyProductReviewsPO(driver);
    }

    public static UserSearchPO getUserProductListSearchPage(WebDriver driver) {
        return new UserSearchPO(driver);
    }

    public static UserProductDetailPO getUserProductDetailPage(WebDriver driver) {
        return new UserProductDetailPO(driver);
    }

    public static UserSearchPO getUserSearchPage(WebDriver driver) {
        return new UserSearchPO(driver);
    }

    public static UserProductListPO getUserProductListPage(WebDriver driver) {
        return new UserProductListPO(driver);
    }
}
