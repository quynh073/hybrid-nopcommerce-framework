package com.nopcommerce.users;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.user.*;
import pageObjects.user.sidebarMyAccount.*;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;


public class Level_01_Page_Object extends BaseTest {
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserMyAccountPO myAccountPage;
    private String firstName, lastName, emailAddress, companyName, password;
    private String browserName;

    private UserAddressesPO addressPageObject;
    private UserOrderPO orderPageObject;
    private UserRewardPointPO rewardPointPageObject;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);

        homePage = PageGenerator.getUserHomePage(driver);

        this.browserName = browserName;

        firstName = "lan";
        lastName = "nguyen";
        emailAddress = "lan" + generateRandomNumber() + "@gmail.com";
        companyName = "fighting";
        password = "123456";
    }

    @Test
    public void User_01_Register(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "User_01_Register");
        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 01: Open Register page");
        registerPage = homePage.openRegisterPage();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 02: Click Gender radio button");
        registerPage.clickToGenderRadio("gender-female");

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 03: Enter to FirstName textbox with value: " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 04: Enter to LastName textbox with value: " + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 05: Enter to EmailAddress textbox with value: " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 06: Enter to CompanyName textbox with value: " + companyName);
        registerPage.enterToCompanyNameTextbox(companyName);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 07: Enter to Password textbox with value: " + password);
        registerPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 08: Enter to ConfirmPassword textbox with value: " + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 09: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "User_01_Register - STEP 10: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");


    }

    @Test
    public void User_02_Login(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "User_02_Login");
        ExtentManager.getTest().log(Status.INFO, "User_02_Login - STEP 01: CLick to Logout link");
        homePage = registerPage.clickToLogoutLink();

        ExtentManager.getTest().log(Status.INFO, "User_02_Login - STEP 02: Open Login page");
        loginPage = homePage.openLoginPage();

        ExtentManager.getTest().log(Status.INFO, "User_02_Login - STEP 03: Login to system with email, password: " + emailAddress + " - " + password);
        homePage = loginPage.loginToSystem(emailAddress, password);

        ExtentManager.getTest().log(Status.INFO, "User_02_Login - STEP 04: Verify MyAccount link is displayed");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_MyAccount(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "User_03_MyAccount");

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - STEP 01: Open CustomerInfo page");
        myAccountPage = homePage.openMyAccountPage();

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - STEP 02: Verify Gender radio is selected");
        Assert.assertTrue(customerInfoPage.isGenderRadioSelected("gender-female"));

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - STEP 03: Verify FirstName value: " + firstName);
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - STEP 04: Verify LastName value: " + lastName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - STEP 05: Verify emailAddress value: " + emailAddress);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);

        ExtentManager.getTest().log(Status.INFO, "User_03_MyAccount - STEP 06: Verify CompanyName value: " + companyName);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(), companyName);
    }

    @Test
    public void User_Switch_Page(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "User_Switch_Page");

        ExtentManager.getTest().log(Status.INFO, "User_Switch_Page - STEP 01: Open Address page");
        addressPageObject = (UserAddressesPO) customerInfoPage.openSidebarLinkByName("Addresses");

        ExtentManager.getTest().log(Status.INFO, "User_Switch_Page - STEP 02: Open RewardPoint page");
        rewardPointPageObject = (UserRewardPointPO) addressPageObject.openSidebarLinkByName("Reward points");

        ExtentManager.getTest().log(Status.INFO, "User_Switch_Page - STEP 03: Open Order page");
        orderPageObject = (UserOrderPO) rewardPointPageObject.openSidebarLinkByName("Orders");

        ExtentManager.getTest().log(Status.INFO, "User_Switch_Page - STEP 04: Open Address page");
        addressPageObject = (UserAddressesPO) orderPageObject.openSidebarLinkByName("Addresses");

        ExtentManager.getTest().log(Status.INFO, "User_Switch_Page - STEP 05: Open CustomerInfo page");
        customerInfoPage = (UserCustomerInfoPO) addressPageObject.openSidebarLinkByName("Customer info");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
