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
import pageObjects.user.UserProductDetailPO;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class User_06_Order extends BaseTest {
    private WebDriver driver;
    private UserHomePO homePage;
    private UserProductDetailPO productDetailPage;

    private String firstName, lastName, email, password;
    private String browserName;
    private String productName, processor, ram, hdd, os, software1, software2, software3;
    private String productPrice, quantity;

    @Parameters({"browser", "userUrl"})
    @BeforeClass()
    public void beforeClass(String browserName, String userUrl){
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGenerator.getUserHomePage(driver);

        this.browserName = browserName;
        firstName = "Huong";
        lastName = "Le";
        email = "lehuong" + generateRandomNumber() + "@gmail.com";
        password = "le123456#";

        productName = "Build your own computer";
        processor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        ram = "8GB [+$60.00]";
        hdd = "400 GB [+$100.00]";
        os = "Vista Premium [+$60.00]";
        software1 = "Microsoft Office [+$50.00]";
        software2 = "Acrobat Reader [+$10.00]";
        software3 = "Total Commander [+$5.00]";

        registerAndLoginAccount(firstName, lastName, email, password);


    }

    @Test
    public void Order_01_Add_Product_To_Cart(Method method){
        ExtentManager.startTest(method.getName() + " - Run on " + browserName, "Order_01_Add_Product_To_Cart");
        ExtentManager.getTest().log(Status.INFO, "STEP 01: Open product detail page");
        homePage.clickToProductByText(productName);
        productDetailPage = PageGenerator.getUserProductDetailPage(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 02: Select product information");
        productDetailPage.selectDropdownById("product_attribute_1", processor);
        productDetailPage.selectDropdownById("product_attribute_2", ram);
        productDetailPage.clickToRadioCheckboxByLabel(hdd);
        productDetailPage.clickToRadioCheckboxByLabel(os);
        productDetailPage.clickToRadioCheckboxByLabel(software1);
        productDetailPage.clickToRadioCheckboxByLabel(software2);
        productDetailPage.clickToRadioCheckboxByLabel(software3);

        productPrice = productDetailPage.getProductPriceValue();
        quantity = productDetailPage.getQuantityValue("value");

        ExtentManager.getTest().log(Status.INFO, "STEP 03: Click add to cart button");
        productDetailPage.clickAddToCartButton();

        ExtentManager.getTest().log(Status.INFO, "STEP 04: Verify success message");
        Assert.assertEquals(productDetailPage.getUserSuccessMessage(driver), "The product has been added to your shopping cart");

        productDetailPage.clickToCloseIcon(driver);
        productDetailPage.waitForNotificationBarInvisible(driver);

        ExtentManager.getTest().log(Status.INFO, "STEP 05: Hover to shopping cart");
        productDetailPage.hoverToShoppingCart();

        ExtentManager.getTest().log(Status.INFO, "STEP 06: Verify count message on cart");
        Assert.assertEquals(productDetailPage.getCountMessageOnCart(), "There are 1 item(s) in your cart.");
        Assert.assertEquals(productDetailPage.getProductNameOnCart(), productName);
        Assert.assertEquals(productDetailPage.getAttributesOnCart(), "Processor: " + processor + "\nRAM: " + ram +
                "\nHDD: " + hdd + "\nOS: " + os + "\nSoftware: " + software1 + "\nSoftware: " + software2 + "\nSoftware: " + software3);

        Assert.assertEquals(productDetailPage.getUnitPriceOnCart(), productPrice);
        Assert.assertEquals(productDetailPage.getQuantityOnCart(), quantity);
//        Assert.assertEquals(productDetailPage.getSubTotalOnCart(), "");

    }


    @AfterClass
    public void afterClass(){
//        closeBrowserDriver();
    }
}
