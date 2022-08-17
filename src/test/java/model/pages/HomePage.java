package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    private By navigateLinksXpath = By.xpath("//li[contains(@class,'navigation-link')]");

    public boolean navigationLinkListIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        return automation.isElementDisplayed(navigateLinksXpath);
    }
}
