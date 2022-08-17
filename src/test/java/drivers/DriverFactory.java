package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private WebDriver webDriver;


    //Singleton Design Pattern
    WebDriver getWebDriver(String browserName) {
        if(webDriver == null){
            webDriver = Webdriver.getDriver(browserName);
        }
        return webDriver;
    }
    void quitDriver(){
        if (webDriver!=null){
            webDriver.quit();
            webDriver = null;
        }
    }
}
