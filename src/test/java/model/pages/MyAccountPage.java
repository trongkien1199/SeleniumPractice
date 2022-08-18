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


    public boolean navigationLinkListIsDisplayed()  {
        automation.pauseTime(1500);
        return automation.isElementDisplayed(navigateLinksXpath);
    }
    public void logoutAccount(){
        automation.click(logoutBtn);
    }

}
