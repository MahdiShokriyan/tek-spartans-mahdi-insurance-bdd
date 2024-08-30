package tek.bdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseSetup {
    //make a logger variable to be able to log the initialization process
    public static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    //make an instantiated variable of driver
    private static WebDriver driver;
    //make a variable to get access to properties library and use config file
    private Properties properties;

    public BaseSetup() {
        try {
            String configFilePath = System.getProperty("user.dir") +
                    "/src/test/resources/configs/dev-config.properties";
            LOGGER.info("Reading Config file: {}", configFilePath);
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error("Error Reading Config file ", e);
            throw new RuntimeException("Config file is wrong check the config file", e);
        }
    }

    //getter for our WebDriver
    public static WebDriver getDriver() {
        return driver;
    }

    public void setupBrowser() {
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Running on browser: {} and is Headless: {}", browserType, isHeadless);
        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new EdgeDriver(options);
        } else if (browserType.equalsIgnoreCase("safari")) {
            SafariOptions options = new SafariOptions();
            driver = new SafariDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else {
            throw new RuntimeException("Choose correct browser type betweem , Chrome , Fire Fox, Edge , Safari");
        }
        String url = properties.getProperty("ui.url");
        LOGGER.debug("openning following Url: {}", url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //Quit the Browser if the value is not Null
    public void quitBrowser() {
        if (driver != null)
            driver.quit();
    }

}

