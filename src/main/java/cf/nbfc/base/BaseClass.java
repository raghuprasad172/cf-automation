package cf.nbfc.base;

import cf.nbfc.constants.IConstants;
import cf.nbfc.eventListener.WebEventLogListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


/**
 * @author Raghu Prasad
 */
public class BaseClass {

    public static WebDriver driver;
    public static Properties properties;
    public static DesiredCapabilities capabilities;
    public static String platformName;
    public static String browserName;
    public static String browserVersion;
    public static String testURL;
    public static String hubURL;
    public static WebDriverListener listener;

    public static Wait<WebDriver> wait;
    public static Logger log = LogManager.getLogger();
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;


    public BaseClass() {
        try {
            FileInputStream fileInputStream = new FileInputStream(IConstants.envConfigFilePath);
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        try {
            platformName = properties.getProperty(IConstants.platformName);
            browserName = properties.getProperty(IConstants.browserName);
            browserVersion = properties.getProperty(IConstants.browserVersion);
            testURL = properties.getProperty(IConstants.testURL);
            hubURL = properties.getProperty(IConstants.hubURL);
            if (platformName.equalsIgnoreCase("Windows 11")) {
                if (browserName.equalsIgnoreCase("chrome") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    driver.manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                    driver.get(testURL);
                    log.atInfo().log("Navigated to " + testURL);
                } else if (browserName.equalsIgnoreCase("firefox") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    driver.manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                    driver.get(testURL);
                    log.atInfo().log("Navigated to " + testURL);
                } else if (browserName.equalsIgnoreCase("MicrosoftEdge") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    driver.manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                    driver.get(testURL);
                    log.atInfo().log("Navigated to " + testURL);
                }
            }
         else  if (platformName.equalsIgnoreCase("mac")) {
                if (browserName.equalsIgnoreCase("chrome") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    driver.manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                    driver.get(testURL);
                    log.atInfo().log("Navigated to " + testURL);
                } else if (browserName.equalsIgnoreCase("firefox") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    driver.manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                    driver.get(testURL);
                    log.atInfo().log("Navigated to " + testURL);
                } else if (browserName.equalsIgnoreCase("MicrosoftEdge") && browserVersion.equalsIgnoreCase("stable")) {
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
                    capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
                    driver = new RemoteWebDriver(new URL(properties.getProperty(IConstants.hubURL)), capabilities);
                    listener = new WebEventLogListener();
                    driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.EXPLICIT_WAIT));
                    log.atInfo().log(browserName + " browser launched");
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IConstants.PAGE_LOAD_TIMEOUT));
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.IMPLICIT_WAIT));
                    driver.manage().window().maximize();
                    log.atInfo().log(browserName + " maximized");
                    driver.get(testURL);
                    log.atInfo().log("Navigated to " + testURL);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quit() {
        try {
            driver.quit();
            log.atInfo().log(browserName + " browser closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
