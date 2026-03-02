package pageUIs.user;

public class UserProductListPUI {
    public static final String SORT_BY_DROPDOWN = "css=select#products-orderby";
    public static final String DISPLAY_DROPDOWN = "id=products-pagesize";
    public static final String PRODUCT_COUNT = "xpath=//div[@class='product-item']";
    public static final String NEXT_PAGE_ICON = "css=li.next-page>a";
    public static final String PREVIOUS_PAGE_ICON = "css=li.previous-page>a";

    public static final String PRODUCT_NAME = "xpath=//div[@class='product-item']//div[@class='details']//a";
    public static final String PRICE = "css=div.prices>span";
    public static final String PAGE_NUMBER = "xpath=//li[@class='individual-page']//a[text()='%s']";
    public static final String CURRENT_PAGE_NUMBER = "xpath=//li[@class='current-page']//span";
    public static final String PRODUCT_LINK = "xpath=//div[@class='product-item']//a[text()='%s']";







}
