package step_definitions;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.net.MalformedURLException;
import java.time.Duration;

public class Hooks {

    public static RemoteWebDriver driver;
    public static WebDriverWait wait;
    public static WebDriver webdriver;
    Duration duration = Duration.ofSeconds(10);

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, duration);
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
