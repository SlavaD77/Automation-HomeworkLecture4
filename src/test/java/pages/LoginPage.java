package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import utils.General;
//import utils.Properties;

public class LoginPage {

    private WebDriver driver;

    private By emailInput = By.id("email");
    private By passwordInput = By.id("passwd");
    private By loginBtn = By.name("submitLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
/*
    public void open(){
        driver.get(Properties.getBaseAdminUrl());
    }

    public void fillEmailInput(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPasswordInput(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginBtn).click();
    }

    public void executeLogin(){
        open();

        General.waitForLoad(driver);

        (new WebDriverWait(driver,1)).until(ExpectedConditions.presenceOfElementLocated(emailInput));

        fillEmailInput(Properties.getLogin());
        fillPasswordInput(Properties.getPassword());
        clickLoginButton();
    }
*/
}
