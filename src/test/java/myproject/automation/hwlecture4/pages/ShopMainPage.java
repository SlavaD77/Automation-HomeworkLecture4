package myproject.automation.hwlecture4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopMainPage extends BasicPage {

    public ShopMainPage(WebDriver driver){
        this.driver = driver;
    }

    private By allProductsLink = By.cssSelector("a.all-product-link.pull-xs-left.pull-md-right.h4");  //all-product-link pull-xs-left pull-md-right h4
    public By getAllProductsLink(){
        return allProductsLink;
    }

    private By nextProductsLinkEnabled = By.cssSelector("a.next.js-search-link"); //next js-search-link
    public By getNextProductsLinkEnabled(){
        return nextProductsLinkEnabled;
    }

    private By nextProductsLinkDisabled = By.cssSelector("a.next.disabled.js-search-link"); //next disabled js-search-link
    public By getNextProductsLinkDisabled(){
        return nextProductsLinkDisabled;
    }

    private By productNameLocator = By.cssSelector("h1[itemprop='name']");
    public By getProductNameLocator(){
        return productNameLocator;
    }

    private By productPriceLocator = By.cssSelector("span[itemprop='price']");
    public By getProductPriceLocator(){
        return productPriceLocator;
    }


    private By productQuantityLocator = By.cssSelector("#product-details > div.product-quantities > span");
    public By getProductQuantityLocator(){
        return productQuantityLocator;
    }

    public void clickAllProductsLink(){
        (driver.findElement(allProductsLink)).click();
    }
}
