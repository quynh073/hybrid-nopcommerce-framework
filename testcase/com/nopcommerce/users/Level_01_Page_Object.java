package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.users.*;


public class Level_01_Page_Object extends BaseTest {
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private String firstName, lastName, emailAddress, companyName, password;

    private UserAddressPO addressPageObject;
    private UserOrderPO orderPageObject;
    private UserRewardPointPO rewardPointPageObject;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);

        homePage = PageGenerator.getUserHomePage(driver);

        firstName = "lan";
        lastName = "nguyen";
        emailAddress = "lan" + generateRandomNumber() + "@gmail.com";
        companyName = "fighting";
        password = "123456";
    }

    @Test
    public void TC_01_Register(){
        registerPage = homePage.openRegisterPage();

        registerPage.clickToGenderRadio();
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyNameTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Test
    public void TC_02_Login(){
        homePage = registerPage.clickToLogoutLink();

        loginPage = homePage.openLoginPage();

        homePage = loginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void TC_03_MyAccount(){
        customerInfoPage = homePage.openCustomerInfoPage();

        Assert.assertTrue(customerInfoPage.isGenderRadioSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(), companyName);
    }

    @Test
    public void User_Switch_Page(){
        addressPageObject = customerInfoPage.openAddressPage();

        rewardPointPageObject = addressPageObject.openRewardPointPage();

        orderPageObject = rewardPointPageObject.openOrderPage();

        addressPageObject = orderPageObject.openAddressPage();

        customerInfoPage = addressPageObject.openCustomerInfoPage();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
