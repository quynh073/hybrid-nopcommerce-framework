package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserProductListPUI;
import pageUIs.user.footer.UserSearchPUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserProductListPO extends UserHomePO{
    private WebDriver driver;

    public UserProductListPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void selectSortNamebyText(String sortName) {
        waitForElementClickable(driver, UserProductListPUI.SORT_BY_DROPDOWN);
        selectItemInDropdown(driver, UserProductListPUI.SORT_BY_DROPDOWN, sortName);
        sleepInSeconds(2);
    }

    public boolean isProductNameSortedAscending() {
        List<String> actualList = getAllElementText(driver, UserProductListPUI.PRODUCT_NAME);
        List<String> expectedList = new ArrayList<>(actualList);
        Collections.sort(expectedList);
        return actualList.equals(expectedList);
    }

    public boolean isProductNameSortedDescending() {
        List<String> actualList = getAllElementText(driver, UserProductListPUI.PRODUCT_NAME);
        List<String> expectedList = new ArrayList<>(actualList);
        Collections.sort(expectedList, Collections.reverseOrder());
        return actualList.equals(expectedList);
    }

    public boolean isPriceSortedAscending() {
        List<String> priceTextList = getAllElementText(driver, UserProductListPUI.PRICE);
        List<Double> actualList = new ArrayList<>();

        for (String priceText : priceTextList) {
            priceText = priceText.replace("$", "")
                    .replace(",", "")
                    .trim();
            Double priceNumber = Double.parseDouble(priceText);
            actualList.add(priceNumber);
        }

        List<Double> expectedList = new ArrayList<>(actualList);
        Collections.sort(expectedList);
        return actualList.equals(expectedList);
    }

    public boolean isPriceSortedDescending() {
        List<String> priceTextList = getAllElementText(driver, UserProductListPUI.PRICE);
        List<Double> actualList = new ArrayList<>();

        for (String priceText : priceTextList) {
            priceText = priceText.replace("$", "")
                    .replace(",", "")
                    .trim();
            Double priceNumber = Double.parseDouble(priceText);
            actualList.add(priceNumber);
        }

        List<Double> expectedList = new ArrayList<>(actualList);

        Collections.sort(expectedList, Collections.reverseOrder());

        return actualList.equals(expectedList);
    }

    public void selectDisplayByText(String displayName) {
        waitForElementClickable(driver, UserProductListPUI.DISPLAY_DROPDOWN);
        selectItemInDropdown(driver, UserProductListPUI.DISPLAY_DROPDOWN, displayName);
        sleepInSeconds(2);
    }

    public int getResultProductCount() {
        waitForElementVisible(driver, UserProductListPUI.PRODUCT_COUNT);
        return getListElementNumber(driver, UserProductListPUI.PRODUCT_COUNT);
    }

    public String getCurrentPageIndex() {
        waitForElementVisible(driver, UserProductListPUI.CURRENT_PAGE_NUMBER);
        return getElementText(driver, UserProductListPUI.CURRENT_PAGE_NUMBER);
    }

    public boolean isNextIconDisplayed() {
        waitForElementVisible(driver, UserProductListPUI.NEXT_PAGE_ICON);
        return isElementDisplayed(driver, UserProductListPUI.NEXT_PAGE_ICON);
    }

    public void clickToPageNumber(String number) {
        waitForElementVisible(driver, UserProductListPUI.PAGE_NUMBER, number);
        clickToElement(driver, UserProductListPUI.PAGE_NUMBER, number);
        sleepInSeconds(3);
    }

    public boolean isPreviousIconDisplayed() {
        waitForElementVisible(driver, UserProductListPUI.PREVIOUS_PAGE_ICON);
        return isElementDisplayed(driver, UserProductListPUI.PREVIOUS_PAGE_ICON);
    }

    public boolean isPageIconUndisplayed() {
        return getListElement(driver, UserProductListPUI.NEXT_PAGE_ICON).isEmpty();
    }
}
