package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverRunner {
    private static WebDriver driver;

   private static final String serverURL = "http://192.168.100.18:4444/wd/hub";

    public static void initDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL(serverURL), new FirefoxOptions());
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
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
