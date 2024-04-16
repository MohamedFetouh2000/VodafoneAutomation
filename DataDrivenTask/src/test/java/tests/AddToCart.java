package tests;

import org.testng.annotations.Test;
import pages.ErrorPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultPage;

import java.io.IOException;

public class AddToCart extends TestBase{

    public AddToCart() throws IOException {}

    /********************Define Variables********************/
    ErrorPage errorPage;
    HomePage homePage;
    LoginPage loginPage;
    SearchResultPage searchResultPage;

    /********************Tests********************/

    @Test
    public void addItemsToCart() throws IOException, InterruptedException {
        errorPage = new ErrorPage(driver);
        errorPage.openErrorPage();
        errorPage.clickOnHome();
        homePage = new HomePage(driver);
        homePage.closePopup();
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(testData.getProperty("loginMobile"));
        loginPage.enterPassword(testData.getProperty("Password"));
        Thread.sleep(1000);
        loginPage.clickLogin();
        homePage.addFirstItemToCart();
        homePage.addSecondItemToCart();
        homePage.searchForItem(testData.getProperty("searchKeyword"));
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.addFirstItemToCart();
        searchResultPage.checkNumberOfItemsInCart("3");
    }
}
