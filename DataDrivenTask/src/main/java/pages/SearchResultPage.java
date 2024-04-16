package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

public class SearchResultPage extends PageBase{
    public SearchResultPage(WebDriver driver) throws IOException {
        super(driver);
    }

    /********************Locators********************/
    @FindBy(xpath = "(//p[@id='mainText'])[1]")
    WebElement firstItem;
    @FindBy(xpath = "//button[@class='add-to-cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//button[@class='cart-btn']")
    WebElement cartBtn;

    /********************Actions********************/

    public void addFirstItemToCart() throws InterruptedException {
        waitElementVisible(3, firstItem);
        moveToElement(firstItem);
        waitElementToBeClickable(10, addToCartBtn);
        addToCartBtn.click();
        Thread.sleep(2000);
    }

    /********************Assertions********************/
    public void checkNumberOfItemsInCart(String number){
       String actualResult = cartBtn.getText();
        Assert.assertEquals(actualResult, number, "number of items in cart is true");
    }
}
