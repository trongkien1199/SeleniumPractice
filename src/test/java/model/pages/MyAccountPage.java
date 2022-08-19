package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase{

    public MyAccountPage(WebDriver driver)
    {
        super(driver);
    }
    private By navigateLinksXpath = By.xpath("//li[contains(@class,'navigation-link')]");
    private By logoutBtn = By.xpath("//a[contains(text(),'Sign out')]");
    private By welcomeText = By.xpath("//div[contains(@class,'MyAccount-content')]//p[1]");
    private By dashboardContentText = By.xpath("//div[contains(@class,'MyAccount-content')]//p[2]");
    private By dashboardNavLink = By.xpath("//a[text()='Dashboard']");
    private By ordersNavLink = By.xpath("//a[contains(@href,'orders')]");
    private By downloadNavLink = By.xpath("//a[contains(@href,'download')]");
    private By addressNavLink = By.xpath("//a[contains(@href,'edit-address')]");
    private By accountDetailsNavLink = By.xpath("//a[contains(@href,'edit-account')]");
    private By logoutNavLink = By.xpath("//a[contains(@href,'customer-logout')]");
    private By messageInfo = By.xpath("//div[contains(@class,'Message--info')]");

    public boolean navigationLinkListIsDisplayed()  {
        automation.pauseTime(1500);
        return automation.isElementDisplayed(navigateLinksXpath);
    }
    public void logoutAccount(){
        automation.click(logoutBtn);
        automation.pauseTime(500);
    }
    public String getWelcomeText(){
        return automation.getText(welcomeText);
    }
    public String getDashboardContentText(){
        return automation.getText(dashboardContentText);
    }
    public void goToAccountDetails(){
        automation.click(accountDetailsNavLink);
    }
    public void goToOrders(){
        automation.click(ordersNavLink);
    }
    public void goToDashboard(){
        automation.click(dashboardNavLink);
    }
    public String getMessageInfoText(){
        return automation.getText(messageInfo);
    }
}
