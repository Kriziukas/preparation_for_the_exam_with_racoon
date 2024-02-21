package lt.techin.kristinaglebenkoviene;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;

import java.time.Duration;

import static java.lang.System.getLogger;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BasePageTest {

    WebDriver driver;
    Wait<WebDriver> wait;
    String mainPageURL = "https://practice.expandtesting.com/notes/app";

    private static final Logger log = getLogger(lookup().lookupClass());

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(4))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(TimeoutException.class);
        driver.get(mainPageURL);
        log.info("Navigated to {}", mainPageURL);
        log.info("Test environment initialized");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
//            driver.quit();
            log.info("WebDriver closed");
        }
    }
}



