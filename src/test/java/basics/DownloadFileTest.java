package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.DownloadTestBase;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DownloadFileTest extends DownloadTestBase {

    @Test
    public void downloadFile() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        int length1 = downloadFolder.listFiles().length;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(".btn-secondary")).click();
        wait.until(l -> downloadFolder.listFiles().length > length1);
        int length2 = downloadFolder.listFiles().length;
        Assert.assertEquals(length2, length1 + 1);

        File[] tables = downloadFolder.listFiles();
        List<String> files = new ArrayList<String>();
        for (File file : tables) {
            files.add(file.getName());
        }
        Thread.sleep(1000);
        Assert.assertTrue(files.contains("test-file-to-download.xlsx"));
    }
}
