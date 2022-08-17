package model.pages;

import org.openqa.selenium.WebDriver;

public class Navigate extends PageBase {
    public Navigate(WebDriver driver)
    {
        super(driver);
    }
    public void open(String url)
    {
        automation.navigate(url);
    }
}
