package com.nopcommerce.users;

import commons.BasePage;
import commons.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Level_01_Page_Object extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private String firstName, lastName, emailAddress, companyName, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);

        homePage = new HomePageObject(driver);

        firstName = "lan";
        lastName = "nguyen";
        emailAddress = "lan" + generateRandomNumber() + "@gmail.com";
        companyName = "hehhe";
        password = "123456";
    }

    @Test
    public void TC_01_Register(){
        homePage.clickRegisterLink();

        registerPage = new RegisterPageObject(driver);
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
        registerPage.clickToLogoutLink();

        homePage = new HomePageObject(driver);
        homePage.clickToLoginLink();

        loginPage = new LoginPageObject(driver);
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = new HomePageObject(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void TC_03_MyAccont(){
        homePage.clickToMyAccountLink();

        customerInfoPage = new CustomerInfoPageObject(driver);
        Assert.assertTrue(customerInfoPage.isGenderRadioSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(), companyName);

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
