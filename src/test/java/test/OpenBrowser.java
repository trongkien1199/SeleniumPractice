package test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OpenBrowser {
    public static void main(String[] args) {
        // Define path
//        String path = System.getProperty("user.dir");
//        String os = System.getProperty("os.name").replaceAll("\\s","");
//        String chromePath = path + "/driver/" + os + "/chromedriver";
//        System.setProperty("webdriver.chrome.driver", chromePath);
        //Open browser
//        WebDriver driver = new ChromeDriver();

        //Firefox
//        String path = System.getProperty("user.dir");
//        String os = System.getProperty("os.name").replaceAll("\\s","");
//        String firefoxPath = path + "/driver/" + os + "/geckodriver";
//        System.setProperty("webdriver.gecko.driver", firefoxPath);
        //open browser
//        WebDriver driver;
//        driver = new FirefoxDriver();

        //Edge
        String path = System.getProperty("user.dir");
        String os = System.getProperty("os.name").replaceAll("\\s","");
        String edgePath = path + "/driver/" + os + "/msedgedriver";
        System.setProperty("webdriver.edge.driver", edgePath);
        //open browser
        WebDriver driver;
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.youtube.com");


    }
}
