package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;

public class AccountPage extends PageBase {
    public AccountPage(WebDriver driver)
    {
        super(driver);
    }

    private By myAccountMenuItemXpath = By.xpath("//a[text()='My Account']");
    private By regEmailXpath = By.xpath("//input[(@id='reg_email')]");
    private By regPasswordXpath = By.xpath("//input[(@id='reg_password')]");
    private By regPasswordHint = By.xpath("//div[contains(@class,'password-strength')]");
    private By regBtn = By.xpath("//input[@name='register']");
    private By usernameXpath = By.xpath("//input[@id='username']");
    private By passwordXpath = By.xpath("//input[@id='password']");
    private By loginBtn = By.xpath("//input[@name='login']");
    private By errorMessageXpath = By.xpath("//ul[contains(@class, 'error')]//li");

    public void goToAccountPageByClickMenuItem(){
        automation.click(myAccountMenuItemXpath);
    }
    public void register(String email, String password) throws InterruptedException {
        automation.enter(regEmailXpath, email);
        automation.enter(regPasswordXpath, password);
        Thread.sleep(2000);
        automation.click(regBtn);
    }
    public void clearRegEmailAndPass(){
        automation.clear(regEmailXpath);
        automation.clear(regPasswordXpath);
    }
    public void registerWithEmptyEmailAndPass(){
        automation.click(regBtn);
    }
    public void login(String username, String password) throws InterruptedException {
        automation.enter(usernameXpath, username);
        automation.enter(passwordXpath, password);
        automation.click(loginBtn);
    }
    public String getErrorMessage(){
        return automation.getText(this.errorMessageXpath);
    }
    public String getMyAccountPageUrl(){
        return automation.getCurrentURL();
    }
    public String getColorMyAccountMenuItem() throws InterruptedException {
        Thread.sleep(1000);
        return automation.getCssColor(myAccountMenuItemXpath,"color");
    }
    public String getMyAccountPageTitle(){
        return automation.getTitle();
    }
}
