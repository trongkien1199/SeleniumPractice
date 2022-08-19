package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Webdriver {
    public static WebDriver getDriver(String browserName){
        String path = System.getProperty("user.dir");
        String os = System.getProperty("os.name").replaceAll("\\s","");
        if(browserName.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            //Open browser
            return  new ChromeDriver(options);
        }else if(browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return  new FirefoxDriver();
        }else if(browserName.equals("edge")){
            String edgePath = path + "/driver/" + os + "/msedgedriver";
            System.setProperty("webdriver.edge.driver", edgePath);
            return new EdgeDriver();
        }else{
            return new SafariDriver();
        }
    }

}
