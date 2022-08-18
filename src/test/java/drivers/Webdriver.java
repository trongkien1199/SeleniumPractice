package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Webdriver {
    public static WebDriver getDriver(String browserName){
        String path = System.getProperty("user.dir");
        String os = System.getProperty("os.name").replaceAll("\\s","");
        if(browserName.equals("chrome")){
            String chromePath = path + "/driver/" + os + "/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
            //Open browser
            return  new ChromeDriver();
        }else if(browserName.equals("firefox")){
            String firefoxPath = path + "/driver/" + os + "/geckodriver";
            System.setProperty("webdriver.gecko.driver", firefoxPath);
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
