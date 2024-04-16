package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
    }

    /********************Locators********************/
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "submitBtn")
    WebElement submitBtn;

    /********************Actions********************/
    public void enterUsername(String mobileNo){
        username.sendKeys(mobileNo);
    }
    public void enterPassword(String pass){
        password.sendKeys(pass);
    }
    public void clickLogin(){
        waitElementToBeClickable(5, submitBtn);
        submitBtn.click();
    }
}
