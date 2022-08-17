package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automation {
    private WebDriver driver = null;
    private WebElement element = null;

    public Automation(WebDriver driver)
    {
        this.driver = driver;
    }

    public boolean waitForControl(By locator, long timeout) {
        boolean isExist = false;
        try {
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            driver.findElement(locator);
            isExist = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            isExist = false;
        }
        return isExist;
    }
    public boolean waitForControl(By locator) {

        int timeout = Settings.getObjecWait();
        return waitForControl(locator, timeout);

    }
    public void waitForControlClose(By locator) {
        int timeout = Settings.getObjecWait();

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void waitForControlClose(By locator, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean isPageDisplayed(String pageTitle) {

        boolean isExist = false;
        long timeout = Settings.getObjecWait()*1000;
        try {
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            String title = driver.getTitle();
            long getTickCount = System.currentTimeMillis();
            while (!title.equals(pageTitle)) {
                Thread.sleep(50);
                title = driver.getTitle();
                if ((System.currentTimeMillis()-getTickCount) > timeout) {
                    break;
                }
            }

            if (title.equals(pageTitle)) isExist = true;
        } catch (Exception e) {
            isExist = false;
        }
        return isExist;

    }
    public void type(CharSequence... keys)
    {
        element.sendKeys(keys);

    }
    public void enter(By locator, String value) {
        waitForControl(locator);
        element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value);
    }
    public void clear(By locator){
        waitForControl(locator);
        element = driver.findElement(locator);
        element.clear();
    }
    public boolean isElementExists(By locator)
    {
        return waitForControl(locator);
    }

    public boolean isElementDisplayed(By locator)
    {
        boolean isDisplayed = false;
        boolean isExists = waitForControl(locator);

        if(isExists)
        {
            try {
                isDisplayed = driver.findElement(locator).isDisplayed();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return isDisplayed;
    }
    public void bringIntoView(By locator)
    {
        waitForControl(locator);
        element = driver.findElement(locator);

    }
    public void clickByJS(By locator)
    {
        waitForControl(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(locator));
    }

    public void click(By locator) {
        waitForControl(locator);
        element = driver.findElement(locator);
        try
        {
            element.click();
        }
        catch(ElementNotVisibleException ex)
        {
            clickByJS(locator);
        }
    }

    public WebElement findElement(By locator) {
        waitForControl(locator);
        return driver.findElement(locator);
    }
    public List<WebElement> findElements(By locator) {
        waitForControl(locator);
        return driver.findElements(locator);
    }
    public boolean isChecked(By locator)
    {
        waitForControl(locator);
        element = driver.findElement(locator);
        return element.isSelected();
    }
    public String getText(By locator)
    {
        return findElement(locator).getText();
    }
    public String getAttribute(By locator, String att)
    {
        waitForControl(locator);
        element = driver.findElement(locator);
        return element.getAttribute(att);
    }
    public String getCssColor(By locator, String att){
        waitForControl(locator);
        element = driver.findElement(locator);
        return element.getCssValue(att);
    }
    public WebDriver getDriver()
    {
        return driver;
    }
    public void navigate(String url)
    {
        driver.get(url);
        driver.manage().window().maximize();
    }
    public void close()
    {
        if(driver != null)
        {
            driver.quit();
        }
    }

    public String getCurrentURL(){

        return driver.getCurrentUrl();
    }

    public String getTitle()
    {
        return driver.getTitle();
    }
    public static boolean isTextContains(String strActual, String strExpected){
        if(strExpected.contains(strActual))
            return true;
        return false;
    }
    public void sleep(int second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
