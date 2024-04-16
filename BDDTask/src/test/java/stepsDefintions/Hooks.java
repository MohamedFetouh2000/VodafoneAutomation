package stepsDefintions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    protected static WebDriver driver;
    protected static Properties testData;

    static {
        try {
            testData = selectPropFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Hooks() throws IOException {}

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void cleanUpEnvironment() throws InterruptedException {
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
