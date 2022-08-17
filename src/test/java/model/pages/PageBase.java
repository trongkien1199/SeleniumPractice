package model.pages;

import automation.Automation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PressKey;

public class PageBase {
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Automation automation;
    public PageBase(WebDriver driver)
    {
        Actions builder = new Actions(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
        automation = new Automation(driver);
    }
}
