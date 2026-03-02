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
import pageObjects.user.*;
import pageObjects.user.footer.UserSearchPO;
import pageObjects.user.sidebarMyAccount.*;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class User_03_My_Account extends BaseTest {
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserAddressesPO addressesPage;
    private UserChangePasswordPO changePasswordPage;
    private UserMyProductReviewsPO myProductReviewsPage;
    private UserMyAccountPO myAccountPage;
    private UserSearchPO productListSearchPage;
    private UserProductDetailPO productDetailPage;

    private String firstName, lastName, email, password;
    private String newFirstName, newLastName, newEmail, newPassword;
    private String firstNameAddress, lastNameAddress, emailAddress, company, country, state, city, address1, address2, zipPostalCode, phoneNumber, faxNumber;
    private String keyWord, product, reviewTitle, reviewText, rating;
    private String browserName;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl){
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGenerator.getUserHomePage(driver);

        this.browserName = browserName;
        firstName = "Huong";
        lastName = "Le";
        email = "lehuong" + generateRandomNumber() + "@gmail.com";
        password = "le123456#";

        //customer info
        newFirstName = "Linh";
        newLastName = "Nguyen";
        newEmail = "linhnguyen" + generateRandomNumber() + "@gmail.com";
        
        //addresses
        firstNameAddress = "Hoa";
        lastNameAddress = "Dang";
        emailAddress = "hoa@gmail.com";
        company = "HOADANG";
        country = "Vietnam";
        state = "Hà Nội";
        city = "Hà Nội";
        address1 = "Hoà Bình";
        address2 = "Đà Nẵng";
        zipPostalCode = "33000";
        phoneNumber = "0896745231";
        faxNumber = "0789456123";

        //change password
        newPassword = "1234567";

        //my product review
        keyWord = "lenovo";
        product = "Lenovo IdeaCentre";
        reviewTitle = "good";
        reviewText = "I like it";
        rating = "4";


        //pre-condition
        //Register
        registerPage = homePage.openRegisterPage();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(email);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
        homePage = registerPage.clickToLogoutLink();
        //Login
        loginPage = homePage.openLoginPage();
        loginPage.enterToEmailTextbox(email);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void My_Account_01_Customer_Info(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "My_Account_01_Customer_Info");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open My Account - Customer info page");
        myAccountPage = homePage.openMyAccountPage();
        customerInfoPage = (UserCustomerInfoPO) myAccountPage.openSidebarLinkByName("Customer info");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Update information");
        customerInfoPage.clickToGenderRadio("gender-male");
        customerInfoPage.enterToFirstNameTextbox(newFirstName);
        customerInfoPage.enterToLastNameTextbox(newLastName);
        customerInfoPage.enterToEmailTextbox(newEmail);

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click to save button");
        customerInfoPage.clickToSaveButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify update success message and information");
        Assert.assertEquals(customerInfoPage.getUserSuccessMessage(driver), "The customer info has been updated successfully.");
        Assert.assertTrue(customerInfoPage.isGenderRadioSelected("gender-male"));
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), newFirstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), newLastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), newEmail);

    }

    @Test
    public void My_Account_02_Addresses(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "My_Account_02_Addresses");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open addresses page");
        addressesPage = (UserAddressesPO) customerInfoPage.openSidebarLinkByName("Addresses");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Click to add button");
        addressesPage.clickToAddNewButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Enter address information");
        addressesPage.enterToFirstNameTextbox(firstNameAddress);
        addressesPage.enterToLastNameTextbox(lastNameAddress);
        addressesPage.enterToEmailTextbox(emailAddress);
        addressesPage.enterToCompanyTextbox(company);
        addressesPage.selectCountryDropdown(country);
        addressesPage.selectStateProvinceDropdown(state);
        addressesPage.enterToCityTextbox(city);
        addressesPage.enterToAddress1Textbox(address1);
        addressesPage.enterToAddress2Textbox(address2);
        addressesPage.enterToZipPostalCodeTextbox(zipPostalCode);
        addressesPage.enterToPhoneNumberTextbox(phoneNumber);
        addressesPage.enterToFaxNumberTextbox(faxNumber);

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Click to save button");
        addressesPage.clickToSaveButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Verify address added successfully");
        Assert.assertEquals(addressesPage.getUserSuccessMessage(driver), "The new address has been added successfully.");
        Assert.assertTrue(addressesPage.getTextByClass("name").contains(firstNameAddress + " " + lastNameAddress));
        Assert.assertTrue(addressesPage.getTextByClass("email").contains("Email: " + emailAddress));
        Assert.assertTrue(addressesPage.getTextByClass("phone").contains("Phone number: " + phoneNumber));
        Assert.assertTrue(addressesPage.getTextByClass("fax").contains("Fax number: " + faxNumber));
        Assert.assertTrue(addressesPage.getTextByClass("company").contains(company));
        Assert.assertTrue(addressesPage.getTextByClass("country").contains(country));
        Assert.assertTrue(addressesPage.getTextByClass("stateprovince").contains(state));
        Assert.assertTrue(addressesPage.getTextByClass("city").contains(city));
        Assert.assertTrue(addressesPage.getTextByClass("address1").contains(address1));
        Assert.assertTrue(addressesPage.getTextByClass("address2").contains(address2));
        Assert.assertTrue(addressesPage.getTextByClass("zippostalcode").contains(zipPostalCode));

    }

    @Test
    public void My_Account_03_Change_Password(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "My_Account_03_Change_Password");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open change password page");
        changePasswordPage = (UserChangePasswordPO) addressesPage.openSidebarLinkByName("Change password");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter old password and new password");
        changePasswordPage.enterToOldPasswordTextbox(password);
        changePasswordPage.enterToNewPasswordTextbox(newPassword);
        changePasswordPage.enterToConfirmNewPasswordTextbox(newPassword);

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click to change password button");
        changePasswordPage.clickToChangePasswordButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify success message");
        Assert.assertEquals(changePasswordPage.getUserSuccessMessage(driver), "Password was changed");
        changePasswordPage.clickToCloseIcon(driver);
        changePasswordPage.waitForNotificationBarInvisible(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Click to logout link");
        homePage = changePasswordPage.clickToLogoutLink();

        ExtentManager.getTest().log(Status.INFO, "STEP 06: Open login page");
        loginPage = homePage.openLoginPage();

        ExtentManager.getTest().log(Status.INFO, "STEP 07: Login with old password");
        loginPage.enterToEmailTextbox(newEmail);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 08: Verify login unsuccess message");
        Assert.assertEquals(loginPage.getLoginUnsuccessMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        ExtentManager.getTest().log(Status.INFO, "STEP 09: Login with new password");
        loginPage.enterToEmailTextbox(newEmail);
        loginPage.enterToPasswordTextbox(newPassword);
        loginPage.clickToLoginButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 10: Verify home page displayed");
        homePage = PageGenerator.getUserHomePage(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void My_Account_04_My_Product_Reviews(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "My_Account_04_My_Product_Reviews");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Search product by name");
        homePage.enterToSearchTextbox(keyWord);
        homePage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Open product detail page");
        productListSearchPage = PageGenerator.getUserProductListSearchPage(driver);
        productDetailPage = productListSearchPage.clickToProduct(product);

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click to add your review link");
        productDetailPage.clickToAddYourReviewLink();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Enter review title and text");
        productDetailPage.enterToReviewTitleTextbox(reviewTitle);
        productDetailPage.enterToReviewTextTextbox(reviewText);

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Click to rating checkbox");
        productDetailPage.clickToRatingCheckbox(rating);

        ExtentManager.getTest().log(Status.INFO, "STEP 06: Click to submit review button");
        productDetailPage.clickToSubmitReviewButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 07: Verify success message");
        Assert.assertEquals(productDetailPage.getUserSuccessMessage(driver), "Product review is successfully added.");
        productDetailPage.clickToCloseIcon(driver);
        productDetailPage.waitForNotificationBarInvisible(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 08: Click to my account link");
        myAccountPage = productDetailPage.openMyAccountPage();

        ExtentManager.getTest().log(Status.INFO, "STEP 09: Open my product reviews page");
        myProductReviewsPage = (UserMyProductReviewsPO) myAccountPage.openSidebarLinkByName("My product reviews");

        ExtentManager.getTest().log(Status.INFO, "STEP 10: Verify review displayed");
        Assert.assertTrue(myProductReviewsPage.getReviewTitle().contains(reviewTitle));
        Assert.assertTrue(myProductReviewsPage.getReviewText().contains(reviewText));
        Assert.assertTrue(myProductReviewsPage.getReviewInfo().contains(product));

    }


    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
