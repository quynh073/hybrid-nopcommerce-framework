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
import pageObjects.user.UserProductListPO;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class User_05_Sort_Display extends BaseTest {
    private WebDriver driver;
    private UserHomePO homePage;
    private UserProductListPO productListPage;

    private String browserName;

    @Parameters({"browser","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl){
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGenerator.getUserHomePage(driver);

        this.browserName = browserName;

        homePage.hoverToHeaderMenuByText("Computers");
        homePage.clickToSubMenuByText("Computers","Notebooks");
        productListPage = PageGenerator.getUserProductListPage(driver);
    }

    @Test
    public void Sort_01_Name_A_To_Z(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_01_Name_A_To_Z");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select sort by name A to Z");
        productListPage.selectSortNamebyText("Name: A to Z");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify product name sorted A to Z");
        Assert.assertTrue(productListPage.isProductNameSortedAscending());

    }

    @Test
    public void Sort_02_Name_Z_To_A(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_02_Name_Z_To_A");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select sort product by name Z to A");
        productListPage.selectSortNamebyText("Name: Z to A");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify product name sorted Z to A");
        Assert.assertTrue(productListPage.isProductNameSortedDescending());

    }

    @Test
    public void Sort_03_Price_Low_To_High(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_03_Price_Low_To_High");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select sort product by price low to high");
        productListPage.selectSortNamebyText("Price: Low to High");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify price low to high");
        Assert.assertTrue(productListPage.isPriceSortedAscending());
    }

    @Test
    public void Sort_04_Price_High_To_Low(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_04_Price_High_To_Low");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select sort product by price high to low");
        productListPage.selectSortNamebyText("Price: Low to High");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify price high to low");
        Assert.assertTrue(productListPage.isPriceSortedDescending());
    }

    @Test
    public void Sort_05_Display_3_Products_Per_Page(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_05_Display_3_Products_Per_Page");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select mode display with 3 products");
        productListPage.selectDisplayByText("3");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify product count is less 3");
        Assert.assertTrue(productListPage.getResultProductCount() <= 3);

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Verify current page index is 1");
        Assert.assertEquals(productListPage.getCurrentPageIndex(), "1");

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify next icon displayed");
        Assert.assertTrue(productListPage.isNextIconDisplayed());

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Click to page 2");
        productListPage.clickToPageNumber("2");

        ExtentManager.getTest().log(Status.INFO, "STEP 06: Verify current page index is 2");
        Assert.assertEquals(productListPage.getCurrentPageIndex(), "2");

        ExtentManager.getTest().log(Status.INFO, "STEP 07: Verify previous icon displayed");
        Assert.assertTrue(productListPage.isPreviousIconDisplayed());


    }

    @Test
    public void Sort_06_Display_6_Products_Per_Page(Method method) {
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_06_Display_6_Products_Per_Page");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select mode display with 6 products");
        productListPage.selectDisplayByText("6");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify product count is less 6");
        Assert.assertTrue(productListPage.getResultProductCount() <= 6);

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify next icon undisplayed");
        Assert.assertTrue(productListPage.isPageIconUndisplayed());
    }

    @Test
    public void Sort_07_Display_9_Products_Per_Page(Method method) {
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_07_Display_9_Products_Per_Page");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select mode display with 9 products");
        productListPage.selectDisplayByText("9");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify product count is less 9");
        Assert.assertTrue(productListPage.getResultProductCount() <= 9);

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify next icon undisplayed");
        Assert.assertTrue(productListPage.isPageIconUndisplayed());
    }


    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
