package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverRunner {
    private static WebDriver driver;
    private static final String serverURL = "http://192.168.100.6:4444/wd/hub";

    public static void initDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        driver = new ChromeDriver();
//    driver = new FirefoxDriver();
        // driver = new RemoteWebDriver(new URL(serverURL), new FirefoxOptions());
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                initDriver();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
