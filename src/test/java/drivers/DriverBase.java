package drivers;

import automation.Automation;
import data.Data;
import model.pages.AccountPage;
import model.pages.MyAccountPage;
import model.pages.Navigate;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class DriverBase {
    protected WebDriver driver;
    private DriverFactory driverFactory;
    protected Navigate navigateURL;
    protected AccountPage accountPage;
    protected MyAccountPage myAccountPage;
    protected Automation automation;
    private static List<DriverFactory> webdriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverThread;

    @BeforeSuite(alwaysRun = true)
    public static void initWebdriverObject(){
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webdriverThread = new DriverFactory();
            webdriverThreadPool.add(webdriverThread);
            return webdriverThread;
        });
    }
    @BeforeSuite
    public static void clearScreenShotFolder(ITestContext iTestContext){
        String suiteName = iTestContext.getCurrentXmlTest().getSuite().getName();
        String folderLocation = System.getProperty("user.dir").concat("/screenshot/" + suiteName);
        File file = new File(folderLocation);
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (int i = 0; i < myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }
    public static WebDriver getDriver(String browserName){
        return driverThread.get().getWebDriver(browserName);
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeMethod(String browserName) throws AWTException {
        driver = getDriver(browserName);
        navigateURL = new Navigate(driver);
        accountPage = new AccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
        automation = new Automation(driver);
        automation.pauseTime(500);
        if (!automation.getCurrentURL().equals(Data._SITE)) {navigateURL.open(Data._SITE);}
    }

    @AfterMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void afterMethod(ITestContext iTestContext, ITestResult result, String browserName) {
//        getDriver().manage().deleteAllCookies();
        //Get screenShot
        if (result.getStatus() == ITestResult.FAILURE) {
            //0. Get current suite name
            String suiteName = iTestContext.getCurrentXmlTest().getSuite().getName();
            //1. Get the test method name
            String testMethod = result.getName();
            //2.Declare file location
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            String takenTime = y + "-" + (month + 1) + "-" + date + "-" + hr + "-" + min + "-" + sec;
            String fileLocation = System.getProperty("user.dir").concat("/screenshot/" +suiteName + "/" + testMethod + takenTime + ".png");
            System.out.println(fileLocation);
//            3.Save screenshot in System
            File screenShot = ((TakesScreenshot) driverThread.get().getWebDriver(browserName)).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShot, new File(fileLocation));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        for(DriverFactory driver : webdriverThreadPool){
            driver.quitDriver();
        }
    }

}
