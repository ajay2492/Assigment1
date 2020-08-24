package comm.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBaseTest {
    private static TestBasePage testBasePage;
    private static String browserValue;
    public static WebDriver driver;

    private static String OSValue;
    private static String CHROME_PATH;

    public static void initialSetup(String inputUrlKey){
        testBasePage = new TestBasePage();
        OSValue = OperatingSystemDetector.operatingSystem();
        getChromeDriverPath();
        browserValue = testBasePage.getConfigValue(Constants.BROWSER);
        webDriverInitialization();
        testBasePage.initializeDriverinTestBasePAge(driver);
        testBasePage.javaScriptExecutor();
        testBasePage.setExplicitWait();
        testBasePage.actionsClass();
        getWebsite(inputUrlKey);
    }

    public static void getChromeDriverPath(){
        if(OSValue.contains("windows")){
            CHROME_PATH = testBasePage.getConfigValue("WINDOW_CHROMEDRIVER_PATH");
        } else if(OSValue.contains("mac")){
            CHROME_PATH = testBasePage.getConfigValue("MAC_CHROMEDRIVER_PATH");
        } else if(OSValue.contains("lin")){
            CHROME_PATH = testBasePage.getConfigValue("LINUX_CHROMEDRIVER_PATH");
        }
    }
    public static void webDriverInitialization(){

        if(browserValue.equalsIgnoreCase(Constants.CHROME)){
            Logger.info("Initializing the WebDriver with selected brower as " + Constants.CHROME + " Browser");
            Logger.info("The Chrome path is " + CHROME_PATH);
            System.setProperty(Constants.CHROME_KEY, CHROME_PATH);
            ChromeOptions chromeOptions = new ChromeOptions();
            Logger.info("Chrome driver version is " + chromeOptions.getVersion());
            driver = new ChromeDriver();
        }
    }

    public static WebDriver getdriver(){
        return driver;
    }

    public static void getWebsite(String inputUrlKey){
        Logger.info("Opening the WebSite for testing");
        driver.get(testBasePage.getConfigValue(inputUrlKey));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
}
