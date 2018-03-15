package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private WebDriver driver;

    private int milisecExpicitWait = 5000;

    private By catalogMenuItem = By.cssSelector("li[data-submenu='9']");
    private By categoriesSubMenuItem = By.cssSelector("li[data-submenu='11']");
    private By addCategoryButton = By.id("page-header-desc-category-new_category");
    private By categoryNameInput = By.id("name_1");
    private By categoryFormSubmitButton = By.id("category_form_submit_btn");
    private By confirmedCategoryCreationAlert = By.cssSelector(".alert.alert-success>button");
    private By categoryFilterNameInput = By.name("categoryFilter_name");
    private By searchFilterSubmitButton = By.cssSelector("button[id=submitFilterButtoncategory]");

    public By getCatalogMenuItem() {return catalogMenuItem;}
    public By getCategoriesSubMenuItem(){return categoriesSubMenuItem;}
    public By getAddCategoryButton(){return addCategoryButton;}
    public By getCategoryNameInput(){return categoryNameInput;}
    public By getCategoryFormSubmitButton(){return  categoryFormSubmitButton;}
    public By getConfirmedCategoryCreationAlert(){return confirmedCategoryCreationAlert;}
    public By getCategoryFilterNameInput(){return categoryFilterNameInput;}
    public By getSearchFilterSubmitButton(){return searchFilterSubmitButton;}

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void hoverCatalogMenuItem(){
        Actions builder = new Actions(driver);

        waitForElementPresence(catalogMenuItem);

        WebElement catalog = driver.findElement(catalogMenuItem);

        builder.moveToElement(catalog).build().perform();
    }

    public void clickCategoriesSubMenuItem(){
        waitForElementPresence(categoriesSubMenuItem);
        (driver.findElement(categoriesSubMenuItem)).click();
    }

    public void clickAddCategory(){
        waitForElementPresence(addCategoryButton);
        (driver.findElement(addCategoryButton)).click();
    }

    public void fillCategoryName(String name){
        waitForElementPresence(categoryNameInput);
        (driver.findElement(categoryNameInput)).sendKeys(name);
    }

    public void clickCategoryFormSubmitButton(){
        waitForElementPresence(categoryFormSubmitButton);
        (driver.findElement(categoryFormSubmitButton)).click();
    }

    public void checkCategoryCreatedAlert(){
        waitForElementPresence(confirmedCategoryCreationAlert);
        driver.findElement(confirmedCategoryCreationAlert);
    }

    public void fillCategoryNameSearchField(String name){
        waitForElementPresence(categoryFilterNameInput);
        (driver.findElement(categoryFilterNameInput)).sendKeys(name);
    }

    public void clickSearchButton(){
        waitForElementPresence(searchFilterSubmitButton);
        (driver.findElement(searchFilterSubmitButton)).click();
    }

    public void scrollPageDown(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;

        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");
/*
        boolean scrollResult = (boolean)jsExecutor.executeScript("var scrollBefore = $(window).scrollTop();" +
        "window.scrollTo(scrollBefore, document.body.scrollHeight);",
        "return $(window).scrollTop > scrollBefore;");
*/
        //return scrollResult;
    }

    public WebElement getCellWithText(String name){

        String locator = "//td[contains(text(),'" + name + "')]";
        waitForElementPresence(By.xpath(locator));
        WebElement element = driver.findElement(By.xpath(locator));
        return element;
    }

    private void waitForElementPresence(By locator){
        (new WebDriverWait(driver,milisecExpicitWait)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
