package com.nopcommerce.users;

import commons.BaseTest;
import commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.users.UserHomePO;
import pageObjects.users.UserLoginPO;
import pageObjects.users.UserRegisterPO;

public class Level_02_Switch_Site_Url extends BaseTest {
    private WebDriver driver;

    private String firstName, lastName, emailAddress, companyName, password;

    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPO userLoginPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDasboardPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        firstName = "mai";
        lastName = "dang";
        emailAddress = "lan" + generateRandomNumber() + "@gmail.com";
        companyName = "fighting";
        password = "123456";

        driver = getBrowserDriver(browserName, GlobalConstant.DEV_USER_URL);

        userHomePage = PageGenerator.getUserHomePage(driver);
        userRegisterPage = userHomePage.openRegisterPage();

        userRegisterPage.clickToGenderRadio();
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToCompanyNameTextbox(companyName);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox(password);
        userRegisterPage.clickToRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @Test
    public void Role_01_User_Site_To_Admin_Site(){
        userHomePage = userRegisterPage.clickToLogoutLink();
        userLoginPage = userHomePage.openLoginPage();
        userHomePage = userLoginPage.loginToSystem(emailAddress, password);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        userHomePage.openPageUrl(driver, GlobalConstant.DEV_ADMIN_URL);
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
        adminLoginPage.enterToEmailTextbox(GlobalConstant.ADMIN_USERNAME);
        adminLoginPage.enterToPasswordTextbox(GlobalConstant.ADMIN_PASSWORD);
        adminDasboardPage = adminLoginPage.clickToLoginButton();
    }

    @Test
    public void Role_02_Admin_Site_To_User_Site(){
        adminDasboardPage.openPageUrl(driver, GlobalConstant.DEV_USER_URL);
        userHomePage = PageGenerator.getUserHomePage(driver);
        userHomePage.openCustomerInfoPage();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
