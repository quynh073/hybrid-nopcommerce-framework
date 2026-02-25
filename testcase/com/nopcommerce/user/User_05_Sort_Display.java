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

    @Test(priority = 1)
    public void Sort_01_Name_A_To_Z(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_01_Name_A_To_Z");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select sort by name A to Z");
        productListPage.selectSortNamebyText("Name: A to Z");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify product name sorted A to Z");
        Assert.assertTrue(productListPage.isProductNameSortedAscending());

    }

    @Test(priority = 2)
    public void Sort_02_Name_Z_To_A(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_02_Name_Z_To_A");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select sort by name Z to A");
        productListPage.selectSortNamebyText("Name: Z to A");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify product name sorted Z to A");
        Assert.assertTrue(productListPage.isProductNameSortedDescending());

    }

    @Test(priority = 3)
    public void Sort_03_Price_Low_To_High(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_03_Price_Low_To_High");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select sort by price low to high");
        productListPage.selectSortNamebyText("Price: Low to High");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify price low to high");
        Assert.assertTrue(productListPage.isPriceSortedAscending());
    }

    @Test(priority = 4)
    public void Sort_04_Price_High_To_Low(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Sort_04_Price_High_To_Low");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Select sort by price high to low");
        productListPage.selectSortNamebyText("Price: Low to High");

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Verify price high to low");
        Assert.assertTrue(productListPage.isPriceSortedDescending());
    }

    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
