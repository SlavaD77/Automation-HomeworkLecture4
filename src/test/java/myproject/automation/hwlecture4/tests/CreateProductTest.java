package myproject.automation.hwlecture4.tests;

import myproject.automation.hwlecture4.GeneralActions;
import myproject.automation.hwlecture4.model.ProductData;
import myproject.automation.hwlecture4.pages.ShopMainPage;
import myproject.automation.hwlecture4.utils.Properties;
import myproject.automation.hwlecture4.utils.logging.CustomReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import myproject.automation.hwlecture4.BaseTest;

import java.util.List;
import java.util.regex.Pattern;

public class CreateProductTest extends BaseTest {

    private ProductData productData;

    private GeneralActions actions;

    @DataProvider
    private Object[][] passProductData(){
        return new Object[][]{
                {productData,null}
        };
    }

    /**
     * Method to create new product
     * @param login
     * @param password
     */
    @Test(dataProvider = "getLoginPassword")
    public void createNewProduct(String login, String password) {
        // TODO implement test for product creation -- DONE

        actions = new GeneralActions(driver);

        actions.login(login, password);

        actions.waitForContentLoad();

        productData = ProductData.generate();

        CustomReporter.logAction("Product generated: " + productData.getString() );

        actions.createProduct(productData);
    }
    /**
     *
     * @param productData
     */
    @Test(dependsOnMethods = {"createNewProduct"},dataProvider = "passProductData")
    public void checkNewProductCreated (ProductData productData, Object stub) {
        // TODO implement logic to check product visibility on website

        ShopMainPage shopMainPage = new ShopMainPage(driver);

        driver.navigate().to(Properties.getBaseUrl());

        actions.waitForContentLoad();

        shopMainPage.clickAllProductsLink();

        List<WebElement> listProductLinks = driver.findElements(By.partialLinkText(productData.getName()));

        Assert.assertTrue(!listProductLinks.isEmpty(), "Product name was not found (search by partial link text");

        WebElement productLink = listProductLinks.get(0);

        productLink.click();

        String productName = driver.findElement(shopMainPage.getProductNameLocator()).getText();
        Assert.assertEquals(productName, productData.getName().toUpperCase());
        CustomReporter.log("Product name assert passed");

        String productPrice = driver.findElement(shopMainPage.getProductPriceLocator()).getText();
        productPrice = productPrice.substring(0, productPrice.length()-1).trim();
        Assert.assertEquals(productPrice, productData.getPrice());
        CustomReporter.log("Product price assert passed");

        shopMainPage.waitForElementPresence(shopMainPage.getProductQuantityLocator());
        String productQuantity = driver.findElement(shopMainPage.getProductQuantityLocator()).getText();

        Pattern pattern = Pattern.compile("\\d+");
        java.util.regex.Matcher m = pattern.matcher(productQuantity);
        m.find(0);
        productQuantity = m.group();

        Assert.assertEquals(productQuantity, productData.getQty().toString());
        CustomReporter.log("Product qty assert passed");

    }





}

