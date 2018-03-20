package myproject.automation.hwlecture4;

import myproject.automation.hwlecture4.model.ProductData;
import myproject.automation.hwlecture4.pages.DashboardPage;
import myproject.automation.hwlecture4.pages.LoginPage;
import myproject.automation.hwlecture4.pages.ProductsPage;
import myproject.automation.hwlecture4.utils.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        // DONE implement logging in to Admin Panel
        LoginPage loginPage = new LoginPage(driver);

        driver.navigate().to(Properties.getBaseAdminUrl());

        loginPage.fillEmailInput(login);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();
    }

    public void createProduct(ProductData productData) {
        // TODO implement product creation scenario ----DONE
        DashboardPage dashboardPage = new DashboardPage(driver);

        //dashboardPage.hoverCatalogMenuItem();
        //dashboardPage.clickProductsCatalogSubtabItem();

        dashboardPage.clickCatalogMenuItem();

        waitForContentLoad();

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.clickAddNewProductButton();

        waitForContentLoad();

        productsPage.fillProductNameInput(productData.getName());

        productsPage.fillProductQuantityInput(productData.getQty().toString());

        productsPage.scrollToElementIntoView(driver.findElement(productsPage.getProductPriceInput()));

        productsPage.fillProductPriceInput(productData.getPrice());

        productsPage.scrollToElementIntoView(driver.findElement(productsPage.getProductActiveCheckbox()));

        productsPage.switchProductActiveCheckbox();

        productsPage.closeMessageBox();

        productsPage.clickSaveButton();
        //productsPage.clickElementWithJavaScript(driver.findElement(productsPage.getSaveButton()));

        productsPage.closeMessageBox();
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
        // DONE implement generic method to wait until page content is loaded
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
    }

}
