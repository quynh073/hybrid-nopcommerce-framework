package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.user.sidebarMyAccount.UserMyAccountPO;
import pageUIs.user.UserProductDetailPUI;

public class UserProductDetailPO extends BasePage {
    private WebDriver driver;

    public UserProductDetailPO(WebDriver driver){
        this.driver = driver;
    }

    public void clickToAddYourReviewLink() {
        waitForElementClickable(driver, UserProductDetailPUI.ADD_REVIEW_LINK);
        clickToElement(driver, UserProductDetailPUI.ADD_REVIEW_LINK);
    }

    public void enterToReviewTitleTextbox(String reviewTitle) {
        waitForElementVisible(driver, UserProductDetailPUI.REVIEW_TITLE_TEXTBOX);
        sendKeyToElement(driver, UserProductDetailPUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
    }

    public void enterToReviewTextTextbox(String reviewText) {
        waitForElementVisible(driver, UserProductDetailPUI.REVIEW_TEXT_TEXTBOX);
        sendKeyToElement(driver, UserProductDetailPUI.REVIEW_TEXT_TEXTBOX, reviewText);

    }

    public void clickToRatingCheckbox(String rating) {
        waitForElementClickable(driver, UserProductDetailPUI.RATE_CHECKBOX, rating);
        clickToElement(driver, UserProductDetailPUI.RATE_CHECKBOX, rating);
    }

    public void clickToSubmitReviewButton() {
        waitForElementClickable(driver, UserProductDetailPUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, UserProductDetailPUI.SUBMIT_REVIEW_BUTTON);
    }



    public UserMyAccountPO openMyAccountPage() {
        waitForElementClickable(driver, UserProductDetailPUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserProductDetailPUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserMyAccountPage(driver);
    }


    public void selectDropdownById(String id, String item) {
        waitForElementClickable(driver, UserProductDetailPUI.DROPDOWN_BY_ID, id);
        selectItemInDropdown(driver, UserProductDetailPUI.DROPDOWN_BY_ID, item, id);
    }

    public void clickToRadioCheckboxByLabel(String labelText) {
        waitForElementVisible(driver, UserProductDetailPUI.RADIO_CHECKBOX_BY_LABEL, labelText);
        checkToCheckBoxRadio(driver, UserProductDetailPUI.RADIO_CHECKBOX_BY_LABEL, labelText);
    }



    public String getProductPriceValue() {
        waitForElementVisible(driver, UserProductDetailPUI.PRICE_VALUE);
        return getElementText(driver, UserProductDetailPUI.PRICE_VALUE);
    }

    public String getQuantityValue(String attributeName) {
        waitForElementVisible(driver, UserProductDetailPUI.QUANTITY_VALUE);
        return getElementAttribute(driver, UserProductDetailPUI.QUANTITY_VALUE, attributeName);
    }

    public void clickAddToCartButton() {
        waitForElementClickable(driver, UserProductDetailPUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, UserProductDetailPUI.ADD_TO_CART_BUTTON);
    }

    public void hoverToShoppingCart() {
        waitForElementVisible(driver, UserProductDetailPUI.SHOPPING_CART);
        scrollToElementOnTopByJS(driver, UserProductDetailPUI.SHOPPING_CART);
        hoverToElement(driver, UserProductDetailPUI.SHOPPING_CART);
    }

    public String getCountMessageOnCart() {
        waitForElementVisible(driver, UserProductDetailPUI.COUNT_MESSAGE_ON_CART);
        return getElementText(driver, UserProductDetailPUI.COUNT_MESSAGE_ON_CART);
    }

    public String getProductNameOnCart() {
        waitForElementVisible(driver, UserProductDetailPUI.PRODUCT_NAME_ON_CART);
        return getElementText(driver, UserProductDetailPUI.PRODUCT_NAME_ON_CART);
    }

    public String getAttributesOnCart() {
        waitForElementVisible(driver, UserProductDetailPUI.ATTRIBUTES_ON_CART);
        return getElementText(driver, UserProductDetailPUI.ATTRIBUTES_ON_CART);
    }

    public String getUnitPriceOnCart() {
        waitForElementVisible(driver, UserProductDetailPUI.PRICE_ON_CART);
        return getElementText(driver, UserProductDetailPUI.PRICE_ON_CART);
    }

    public String getQuantityOnCart() {
        waitForElementVisible(driver, UserProductDetailPUI.QUANTITY_ON_CART);
        return getElementText(driver, UserProductDetailPUI.QUANTITY_ON_CART);
    }

    public String getSubTotalOnCart() {
        waitForElementVisible(driver, UserProductDetailPUI.TOTALS_ON_CART);
        return getElementText(driver, UserProductDetailPUI.TOTALS_ON_CART);
    }



}
