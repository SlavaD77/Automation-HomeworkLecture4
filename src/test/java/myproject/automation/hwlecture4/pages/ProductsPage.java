package myproject.automation.hwlecture4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasicPage {

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    private By addNewProductButton = By.id("page-header-desc-configuration-add");
    public By getAddNewProductButton(){
        return addNewProductButton;
    }

    private By productNameInput = By.id("form_step1_name_1");
    public By getProductNameInput(){
        return  productNameInput;
    }

    private By productQuantityInput = By.id("form_step1_qty_0_shortcut");
    public By getProductQuantityInput(){
        return productQuantityInput;
    }

    private By productPriceInput = By.id("form_step1_price_ttc_shortcut");
    public By getProductPriceInput(){
        return productPriceInput;
    }
    //Element is hidden by upper div !!!
    private By productActiveCheckbox = By.id("form_step1_active");
    public By getProductActiveCheckbox(){
        return productActiveCheckbox;
    }

    private By productDivActive = By.className("switch-input");
    public  By getProductDivActive(){
        return productDivActive;
    }

    private By messageBox = By.id("growl growl-notice growl-medium");
    public By getMessageBox(){
        return messageBox;
    }

    private By messageBoxCloseX = By.className("growl-close");
    public By getMessageBoxCloseX(){
        return messageBoxCloseX;
    }

    private By saveButton = By.cssSelector("input.btn.btn-primary.save.uppercase");  //input btn btn-primary save uppercase   input.btn.btn-primary.js-btn-save
    public By getSaveButton(){
        return  saveButton;
    }

    public void clickAddNewProductButton(){
        waitForElementPresence(addNewProductButton);
        (driver.findElement(addNewProductButton)).click();
    }

    public void fillInput (By locator, String data) throws Throwable{
        WebElement input = driver.findElement(locator);
        if (  (input.getTagName() != "input")  || (input.getAttribute("type") != "text") ){
            throw new Throwable("Wrong element type, should be text input");
        }
        input.sendKeys(data);
    }

    public void fillProductNameInput(String productName){

        (driver.findElement(productNameInput)).sendKeys(productName);
    }

    public void fillProductQuantityInput(String quantity){
        WebElement qty = driver.findElement(productQuantityInput);
        qty.sendKeys(Keys.BACK_SPACE);
        qty.sendKeys(quantity);
    }

    public void fillProductPriceInput(String productPrice){
        WebElement price = driver.findElement(productPriceInput);
        price.sendKeys(Keys.BACK_SPACE);
        price.sendKeys(productPrice);
    }

    public void switchProductActiveCheckbox(){
        (driver.findElement(productDivActive)).click();
    }

    public void closeMessageBox(){
        //waitForElementPresence(getMessageBox());
        (driver.findElement(messageBoxCloseX)).click();
    }

    public void clickSaveButton(){
        (driver.findElement(saveButton)).click();
    }

}
