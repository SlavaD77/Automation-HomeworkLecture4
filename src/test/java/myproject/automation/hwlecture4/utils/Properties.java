package myproject.automation.hwlecture4.utils;

/**
 * Help class to get passed parameters from environment for further usage in the automation project
 */
public class Properties {
    private static final String DEFAULT_BASE_URL = "!!!-----------http://prestashop-automation.qatestlab.com.ua/";
    private static final String DEFAULT_BASE_ADMIN_URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private static final String DEFAULT_BASE_BROWSER = "chrome";

    /**
     * Get address of website frontend (webstore)
     * @return Website frontend.
     */
    public static String getBaseUrl() {
        return System.getProperty(EnvironmentVariables.BASE_URL.toString(), DEFAULT_BASE_URL);
    }

    /**
     * Get address of admin panel
     * @return Website backend (ULR of the Admin Panel.)
     */
    public static String getBaseAdminUrl() {
        return System.getProperty(EnvironmentVariables.BASE_ADMIN_URL.toString(), DEFAULT_BASE_ADMIN_URL);
    }

    /**
     *  Get browser type to run tests
     * @return Browser type
     */
    public static String getBrowser(){
        return System.getProperty(EnvironmentVariables.BASE_BROWSER.toString(), DEFAULT_BASE_BROWSER);
    }

    /**
     * Get login for AdminPage
     * @return login to admin page
     */
    public static String getAdminLogin(){
        return System.getProperty(EnvironmentVariables.ADMIN_LOGIN.toString());
    }

    /**
     *
     * @return password to Login page;
     */
    public static String getAdminPassword(){
        return System.getProperty(EnvironmentVariables.ADMIN_PASSWORD.toString());
    }

}

/**
 * All parameters that are passed to automation project
 */
enum EnvironmentVariables {
    BASE_URL("env.url"),
    BASE_ADMIN_URL("env.admin.url"),
    BASE_BROWSER("env.browser"),
    ADMIN_LOGIN("env.login"),
    ADMIN_PASSWORD("env.password");

    private String value;
    EnvironmentVariables(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}