package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CommonLibrary {
    public static WebDriver driver;
    String filePath = new File("src/main/screenShots").getAbsolutePath();
    String propertiesFile = new File("src/main/data/testData.properties").getAbsolutePath();

    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public void closeBrowser() {
        driver.quit();
    }

    public void takeScreenShots(String fileName) throws Exception {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File virtualFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File actualFile = new File(filePath + fileName);

        FileUtils.copyFile(virtualFile, actualFile);
    }

    public String getProperties(String key) throws Exception {

        String value;
        FileInputStream fileInputStream = new FileInputStream(propertiesFile);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        value = properties.getProperty(key);
        return value;
    }
}
