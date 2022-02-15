package test_base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DownloadTestBase {
    protected WebDriver driver;
    protected File downloadFolder;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        downloadFolder = new File("src/main/resources/downloads");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", downloadFolder.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
