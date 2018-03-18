package myproject.automation.hwlecture4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import myproject.automation.hwlecture4.utils.Properties;

public class LoginPage {

    private WebDriver driver;

    private By emailInputLocator = By.id("email");

    public By getEmailInputLocator() {
        return emailInputLocator;
    }

    private By passwordInputLocator = By.id("passwd");

    public By getPasswordInputLocator() {
        return passwordInputLocator;
    }

    private By loginBtnLocator = By.name("submitLogin");

    public By getLoginBtnLocator() {
        return loginBtnLocator;
    }


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }



    public void open(String address){
        driver.get(address);
    }

    public void fillEmailInput(String email){
        driver.findElement(emailInputLocator).sendKeys(email);
    }

    public void fillPasswordInput(String password){
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginBtnLocator).click();
    }

    public void executeLogin(String address, String login, String password){

        open(address);
        fillEmailInput(login);
        fillPasswordInput(password);
        clickLoginButton();
    }

}
