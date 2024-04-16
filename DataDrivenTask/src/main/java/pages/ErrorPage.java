package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class ErrorPage extends PageBase{
    public ErrorPage(WebDriver driver) throws IOException {
        super(driver);
    }
    /********************Locators********************/
    @FindBy(xpath = "//a[@class='link']")
    WebElement HomeBtn;

    /********************Actions********************/
    public void openErrorPage(){
        driver.get(routes.getProperty("baseURL")+routes.getProperty("wrongPath"));
    }
    public void clickOnHome(){
        HomeBtn.click();
    }
}
