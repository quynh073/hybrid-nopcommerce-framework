package com.nopcommerce.user;

import com.aventstack.extentreports.Status;
import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PageGenerator;
import pageObjects.user.UserHomePO;
import pageObjects.user.UserRegisterPO;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class User_01_Register extends BaseTest {
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;


    private String firstName, lastName, emailAddress, companyName, password;
    private String browserName;
    private String invalidEmail;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl){
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGenerator.getUserHomePage(driver);

        this.browserName = browserName;
        firstName = "Huong";
        lastName = "Le";
        emailAddress = "lehuong" + generateRandomNumber() + "@gmail.com";
        companyName = "QANop";
        password = "le123456#";


    }

    @Test
    public void Register_01_Empty_Data(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Register_01_Empty_Data");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open register page");
        registerPage = homePage.openRegisterPage();

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Click to register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Verify error message at first name");
        Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify error message at last name");
        Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Verify error message at email");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");

        ExtentManager.getTest().log(Status.INFO, "STEP 06: Verify error message at password");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Register_02_Invalid_Email");
        registerPage.refreshCurrentPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 01: Enter to valid information with invalid email");
        registerPage.clickToGenderRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox("555");
        registerPage.enterToCompanyNameTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Click to register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Verify error message at email");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Please enter a valid email address.");


    }

    @Test
    public void Register_03_Valid_Data(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Register_03_Valid_Data");
        registerPage.refreshCurrentPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 01: Click to gender radio");
        registerPage.clickToGenderRadio();

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter to firstname textbox with value - " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Enter to lastname textbox with value - " + lastName);
        registerPage.enterToLastNameTextbox(lastName);

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Enter to email textbox with value - " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Enter to company textbox with value - " + companyName);
        registerPage.enterToCompanyNameTextbox(companyName);

        ExtentManager.getTest().log(Status.INFO, "STEP 06: Enter to password textbox with value - " + password);
        registerPage.enterToPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "STEP 07: Enter to confirm password textbox with value - " + password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "STEP 08: Click to register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 09: Verify success message");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

    }

    @Test
    public void Register_04_Exist_Email(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Register_04_Exist_Email");
        homePage = registerPage.clickToLogoutLink();

        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open register page");
        registerPage = homePage.openRegisterPage();

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter to valid information with exist email - " + emailAddress);
        registerPage.clickToGenderRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyNameTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click to register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify email already exists message");
        Assert.assertEquals(registerPage.getEmailExsitErrorMessage(), "The specified email already exists");
    }

    @Test
    public void Register_05_Short_Password(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Register_05_Short_Password");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open register page");
        homePage.openRegisterPage();

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter to valid information with password less than 6 characters");
        registerPage.clickToGenderRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyNameTextbox(companyName);
        registerPage.enterToPasswordTextbox("111");
        registerPage.enterToConfirmPasswordTextbox("111");

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click to register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify error message at password");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules: must have at least 6 characters and not greater than 64 characters");

    }

    @Test
    public void Register_06_Unmatched_Confirm_Password(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Register_06_Unmatched_Confirm_Password");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open register page");
        homePage.openRegisterPage();

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter to valid information with unmatched confirm password");
        registerPage.clickToGenderRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyNameTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox("123456");

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click to register button");
        registerPage.clickToRegisterButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify error message at confirm password");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");

    }

    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
