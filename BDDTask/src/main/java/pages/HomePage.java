package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class HomePage extends PageBase{
    public HomePage (WebDriver driver) throws IOException {
        super(driver);
    }
    /********************Locators********************/
    @FindBy(xpath = "//img[@src='assets/icon-center/profile.svg']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[@class='onetrust-close-btn-handler banner-close-button ot-close-icon']")
    WebElement closePopupBtn;

    @FindBy(xpath = "(//div[@class='product-display-name'])[1]")
    WebElement firstItem;
    @FindBy(xpath = "(//div[@class='product-display-name'])[2]")
    WebElement secondItem;
    @FindBy(xpath = "//button[@class='add-to-cart']")
    WebElement addToCartBtn;

    @FindBy(id = "searchInput")
    WebElement searchFld;

    @FindBy(xpath = "(//div[@class='category-result'])[1]")
    WebElement firstSearchResult;

    /********************Actions********************/
    public void openLoginPage(){
        loginBtn.click();
    }
    public void closePopup(){
        waitElementVisible(3, closePopupBtn);
        closePopupBtn.click();
    }
    public void addFirstItemToCart() throws InterruptedException {
        waitElementVisible(3, firstItem);
        moveToElement(firstItem);
        firstItem.click();
        waitElementToBeClickable(10, addToCartBtn);
        addToCartBtn.click();
        driver.navigate().back();
    }
    public void addSecondItemToCart(){
        moveToElement(secondItem);
        waitElementToBeClickable(10, addToCartBtn);
        addToCartBtn.click();
        driver.navigate().back();
    }

    public void searchForItem(String searchKeyword) throws InterruptedException {
        searchFld.sendKeys(searchKeyword);
        waitElementToBeClickable(5, firstSearchResult);
        firstSearchResult.click();
        waitUrlChange(5, "/list");
    }
}
