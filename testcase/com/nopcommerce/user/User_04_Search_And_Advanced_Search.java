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
import pageObjects.user.footer.UserSearchPO;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class User_04_Search_And_Advanced_Search extends BaseTest {
    private WebDriver driver;
    private UserHomePO homePage;
    private UserSearchPO searchPage;

    private String firstName, lastName, email, password;
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

        //Pre-condition
        registerAndLoginAccount(firstName, lastName, email, password);

    }

    @Test(priority = 1)
    public void Search_01_Empty_Data(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Search_01_Empty_Data");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open search page");
        homePage.clickToFooterLink(driver, "Search");
        searchPage = PageGenerator.getUserSearchPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Click to search button");
        searchPage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Verify error message displayed");
        Assert.assertEquals(searchPage.getErrorMessage(), "Search term minimum length is 3 characters");

    }

    @Test(priority = 2)
    public void Search_02_Data_Not_Exist(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Search_02_Data_Not_Exist");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open search page");
        searchPage.clickToFooterLink(driver, "Search");
        searchPage = PageGenerator.getUserSearchPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter a keyword that doesn't exist");
        searchPage.enterToSearchTextbox("Macbook 2030");


        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click to search button");
        searchPage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify error message displayed");
        Assert.assertEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");

    }

    @Test(priority = 3)
    public void Search_03_Relative_Product_Name(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Search_03_Relative_Product_Name");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open search page");
        searchPage.clickToFooterLink(driver, "Search");
        searchPage = PageGenerator.getUserSearchPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter a keyword with relative product name");
        searchPage.enterToSearchTextbox("Lenovo");


        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click to search button");
        searchPage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify 2 products displayed");
        Assert.assertEquals(searchPage.getResultProductCount(), 2);
        Assert.assertTrue(searchPage.isProductNameDisplay("Lenovo IdeaCentre"));
        Assert.assertTrue(searchPage.isProductNameDisplay("Lenovo Thinkpad Carbon Laptop"));

    }

    @Test(priority = 4)
    public void Search_04_Absolute_Product_Name(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Search_04_Absolute_Product_Name");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open search page");
        searchPage.clickToFooterLink(driver, "Search");
        searchPage = PageGenerator.getUserSearchPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter a keyword with absolute product name");
        searchPage.enterToSearchTextbox("Lenovo IdeaCentre");


        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click to search button");
        searchPage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify 1 products displayed");
        Assert.assertEquals(searchPage.getResultProductCount(), 1);
        Assert.assertTrue(searchPage.isProductNameDisplay("Lenovo IdeaCentre"));

    }

    @Test(priority = 5)
    public void Advanced_Search_05_Parent_Categories(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Advanced_Search_05_Parent_Categories");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open search page");
        searchPage.clickToFooterLink(driver, "Search");
        searchPage = PageGenerator.getUserSearchPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter a keyword");
        searchPage.enterToSearchTextbox("Apple Macbook Pro");

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Check advanced search checkbox");
        searchPage.checkAdvancedSearchCheckbox();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Select category");
        searchPage.selectCategoryDropdown("Computers");

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Uncheck search sub checkbox");
        searchPage.uncheckSearchSubCheckbox();

        ExtentManager.getTest().log(Status.INFO, "STEP 06: Click to search button");
        searchPage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 07: Verify error message");
        Assert.assertEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");

    }

    @Test(priority = 6)
    public void Advanced_Search_06_Sub_Categories(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Advanced_Search_06_Sub_Categories");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open search page");
        searchPage.clickToFooterLink(driver, "Search");
        searchPage = PageGenerator.getUserSearchPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter a keyword");
        searchPage.enterToSearchTextbox("Apple Macbook Pro");

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Check advanced search checkbox");
        searchPage.checkAdvancedSearchCheckbox();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Select category");
        searchPage.selectCategoryDropdown("Computers");

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Check search sub checkbox");
        searchPage.checkSearchSubCheckbox();

        ExtentManager.getTest().log(Status.INFO, "STEP 06: Click to search button");
        searchPage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 07: Verify 1 products displayed");
        Assert.assertEquals(searchPage.getResultProductCount(), 1);
        Assert.assertTrue(searchPage.isProductNameDisplay("Apple MacBook Pro"));

    }

    @Test(priority = 7)
    public void Advanced_Search_07_Incorrect_Manufacturer(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Advanced_Search_07_Incorrect_Manufacturer");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open search page");
        searchPage.clickToFooterLink(driver, "Search");
        searchPage = PageGenerator.getUserSearchPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter a keyword");
        searchPage.enterToSearchTextbox("Apple Macbook Pro");

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Check advanced search checkbox");
        searchPage.checkAdvancedSearchCheckbox();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Select category");
        searchPage.selectCategoryDropdown("Computers");

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Check search sub checkbox");
        searchPage.checkSearchSubCheckbox();

        ExtentManager.getTest().log(Status.INFO, "STEP 06: Select manufacturer");
        searchPage.selectManufacturerDropdown("HP");

        ExtentManager.getTest().log(Status.INFO, "STEP 07: Click to search button");
        searchPage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 08: Verify error message");
        Assert.assertEquals(searchPage.getNoResultMessage(), "No products were found that matched your criteria.");


    }

    @Test(priority = 8)
    public void Advanced_Search_08_Correct_Manufacturer(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Advanced_Search_08_Correct_Manufacturer");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open search page");
        searchPage.clickToFooterLink(driver, "Search");
        searchPage = PageGenerator.getUserSearchPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Enter a keyword");
        searchPage.enterToSearchTextbox("Apple Macbook Pro");

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Check advanced search checkbox");
        searchPage.checkAdvancedSearchCheckbox();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Select category");
        searchPage.selectCategoryDropdown("Computers");

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Check search sub checkbox");
        searchPage.checkSearchSubCheckbox();

        ExtentManager.getTest().log(Status.INFO, "STEP 06: Select manufacturer");
        searchPage.selectManufacturerDropdown("Apple");

        ExtentManager.getTest().log(Status.INFO, "STEP 07: Click to search button");
        searchPage.clickToSearchButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 08: Verify 1 products displayed");
        Assert.assertEquals(searchPage.getResultProductCount(), 1);
        Assert.assertTrue(searchPage.isProductNameDisplay("Apple MacBook Pro"));

    }



    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
