package commons;

public class GlobalConstant {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String JAVA_VERSION = System.getProperty("java.version");


    public static final String DEV_USER_URL = "http://demo.nopcommerce";

    public static final String DEV_ADMIN_URL = "http://demo.nopcommerce/admin";

    public static final String ADMIN_USERNAME = "quynh@gmail.com";
    public static final String ADMIN_PASSWORD = "123456";

    public static final long SHORT_TIME = 10;
    public static final long LONG_TIME = 30;

    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;


}
