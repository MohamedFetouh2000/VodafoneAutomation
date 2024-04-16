package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    WebDriver driver;
    Properties testData = selectPropFile();

    public TestBase() throws IOException {}

    @BeforeTest
    public void setUpEnvironment() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void clearEnv() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    private static Properties selectPropFile () throws IOException {
        FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+"\\TestData.properties");
        Properties testProp = new Properties();
        testProp.load(propFile);
        propFile.close();
        return testProp;
    }
}
