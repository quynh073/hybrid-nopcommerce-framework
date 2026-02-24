package pageObjects.user.footer;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.user.UserProductDetailPO;
import pageUIs.user.footer.UserSearchPUI;

public class UserSearchPO extends BasePage {
    private WebDriver driver;

    public UserSearchPO(WebDriver driver){
        this.driver = driver;
    }


    public UserProductDetailPO clickToProduct(String product) {
        waitForElementClickable(driver, UserSearchPUI.PRODUCT_LINK, product);
        clickToElement(driver, UserSearchPUI.PRODUCT_LINK, product);
        return PageGenerator.getUserProductDetailPage(driver);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, UserSearchPUI.SEARCH_BUTTON);
        clickToElement(driver, UserSearchPUI.SEARCH_BUTTON);
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, UserSearchPUI.ERROR_MESSAGE);
        return getElementText(driver, UserSearchPUI.ERROR_MESSAGE);
    }

    public void enterToSearchTextbox(String keyWord) {
        waitForElementVisible(driver, UserSearchPUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, UserSearchPUI.SEARCH_TEXTBOX, keyWord);
    }

    public String getNoResultMessage() {
        waitForElementVisible(driver, UserSearchPUI.NO_RESULT_MESSAGE);
        return getElementText(driver, UserSearchPUI.NO_RESULT_MESSAGE);
    }

    public Integer getResultItemCount() {
        waitForElementVisible(driver, UserSearchPUI.PRODUCT_COUNT);
        return getListElementNumber(driver, UserSearchPUI.PRODUCT_COUNT);
    }

    public boolean isProductNameDisplay(String productName) {
        waitForElementVisible(driver, UserSearchPUI.PRODUCT_LINK, productName);
        return isElementDisplayed(driver, UserSearchPUI.PRODUCT_LINK, productName, productName);
    }

    public void checkAdvancedSearchCheckbox() {
        waitForElementClickable(driver, UserSearchPUI.ADVANCED_SEARCH_CHECKBOX);
        checkToCheckBoxRadio(driver, UserSearchPUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void selectCategoryDropdown(String categoryName) {
        waitForElementClickable(driver, UserSearchPUI.CATEGORY_DROPDOWN_PARENT);
        selectItemInDropdown(driver, UserSearchPUI.CATEGORY_DROPDOWN_PARENT, categoryName);
    }

    public void uncheckSearchSubCheckbox() {
        waitForElementClickable(driver, UserSearchPUI.SEARCH_SUB_CHECKBOX);
        uncheckToCheckBoxRadio(driver, UserSearchPUI.SEARCH_SUB_CHECKBOX);
    }

    public void checkSearchSubCheckbox() {
        waitForElementClickable(driver, UserSearchPUI.SEARCH_SUB_CHECKBOX);
        checkToCheckBoxRadio(driver, UserSearchPUI.SEARCH_SUB_CHECKBOX);

    }

    public void selectManufacturerDropdown(String manufacturerName) {
        waitForElementClickable(driver, UserSearchPUI.MANUFACTURER_DROPDOWN_PARENT);
        selectItemInDropdown(driver, UserSearchPUI.MANUFACTURER_DROPDOWN_PARENT, manufacturerName);

    }
}
