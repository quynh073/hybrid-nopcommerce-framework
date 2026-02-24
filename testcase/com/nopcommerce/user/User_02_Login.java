package com.nopcommerce.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.user.UserHomePO;
import pageObjects.user.UserLoginPO;
import pageObjects.user.UserRegisterPO;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class User_02_Login extends BaseTest {
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;

    private String firstName, lastName, emailAddress, password;
    private String browserName;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl){
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGenerator.getUserHomePage(driver);

        this.browserName = browserName;
        firstName = "Huong";
        lastName = "Le";
        emailAddress = "lehuong" + generateRandomNumber() + "@gmail.com";
        password = "le123456#";

        //Pre-condition
        //Register
        registerPage = homePage.openRegisterPage();
        registerPage.clickToGenderRadio("gender-female");
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
        homePage = registerPage.clickToLogoutLink();

    }

    @Test
    public void Login_01_Empty_Data(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Login_01_Empty_Data");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open login page");
        loginPage = homePage.openLoginPage();

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Click to login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Verify error message at email");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");

    }

    @Test
    public void Login_02_Invalid_Email(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Login_02_Invalid_Email");
        loginPage.refreshCurrentPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 01: Enter to invalid email");
        loginPage.enterToEmailTextbox("aaa");
        loginPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Click to login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Verify error message at email");
        Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter a valid email address.");

    }

    @Test
    public void Login_03_Unregistered_Email(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Login_03_Unregistered_Email");
        loginPage.refreshCurrentPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 01: Enter to unregistered email");
        loginPage.enterToEmailTextbox("abc@gmail.com");
        loginPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Click to login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Verify login unsuccess message");
        Assert.assertEquals(loginPage.getLoginUnsuccessMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void Login_04_Empty_Password(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Login_04_Empty_Password");
        homePage.openLoginPage();

        ExtentManager.getTest().log(Status.INFO, "STEP 01: Enter to correct email and empty password");
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox("");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Click to login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Verify login unsuccess message");
        Assert.assertEquals(loginPage.getLoginUnsuccessMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }

    @Test
    public void Login_05_Wrong_Password(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Login_05_Wrong_Password");
        homePage.openLoginPage();

        ExtentManager.getTest().log(Status.INFO, "STEP 01: Enter to correct email and wrong password");
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox("111");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Click to login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Verify login unsuccess message");
        Assert.assertEquals(loginPage.getLoginUnsuccessMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }


    @Test
    public void Login_06_Valid_Data(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Login_06_Valid_Data");
        homePage.openLoginPage();

        ExtentManager.getTest().log(Status.INFO, "STEP 01: Enter to email with value - " + emailAddress);
        loginPage.enterToEmailTextbox(emailAddress);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter to password with value - " + password);
        loginPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click to login button");
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify home page displayed");
        homePage = PageGenerator.getUserHomePage(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}

