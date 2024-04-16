package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class PageBase {
    /********************Define Variables********************/
    WebDriver driver;
    Actions action;
    JavascriptExecutor js;
    Properties routes = selectPropFile();

    /********************Helpful methods********************/
    public PageBase (WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void hovering(WebElement ele){
        action = new Actions(driver);
        action.moveToElement(ele).perform();
    }
    protected void jsClick(WebElement ele){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", ele);
    }
    protected void jsScroll (WebElement ele){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", ele);
    }
    protected void moveToElement(WebElement ele){
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).click().perform();
    }
    protected void waitElementVisible(int seconds, WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    protected void waitUrlChange(int seconds, String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.urlContains(url));
    }
    protected void waitElementToBeClickable(int seconds, WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }
    private static Properties selectPropFile () throws IOException {
        FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+"\\Routes.properties");
        Properties testProp = new Properties();
        testProp.load(propFile);
        propFile.close();
        return testProp;
    }
}