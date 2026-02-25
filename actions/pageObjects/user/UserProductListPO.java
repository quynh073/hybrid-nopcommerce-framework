package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageUIs.user.UserProductListPUI;

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
        waitForElementClickable(driver, UserProductListPUI.SORT_NAME);
        selectItemInDropdown(driver, UserProductListPUI.SORT_NAME, sortName);
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
}
