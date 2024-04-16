package stepsDefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ErrorPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultPage;

import java.io.IOException;

public class AddToCartSteps {
    ErrorPage errorPage = new ErrorPage(Hooks.driver);
    HomePage homePage = new HomePage(Hooks.driver);
    LoginPage loginPage = new LoginPage(Hooks.driver);
    SearchResultPage searchResultPage = new SearchResultPage(Hooks.driver);

    public AddToCartSteps() throws IOException {
    }


    @Given("User surfs on home page and login valid mobile and valid password")
    public void openWebsiteAndLogin() throws InterruptedException {
        errorPage.openErrorPage();
        errorPage.clickOnHome();
        homePage.openLoginPage();
        loginPage.enterUsername(Hooks.testData.getProperty("loginMobile"));
        loginPage.enterPassword(Hooks.testData.getProperty("password"));
        Thread.sleep(1000);
        loginPage.clickLogin();
        homePage.closePopup();
    }

    @When("selects item and add it to cart")
    public void addItemToCart() throws InterruptedException {
        homePage.addFirstItemToCart();
    }
    @And("Selects another item and add it to cart")
    public void addSecondItem(){
        homePage.addSecondItemToCart();
    }
    @And("Search for an item and add it to cart")
    public void addItemBySearch() throws InterruptedException {
        homePage.searchForItem(Hooks.testData.getProperty("searchKeyword"));
        searchResultPage.addFirstItemToCart();
    }
    @Then("items in the cart is 3 items")
    public void checkNumberItems(){
        searchResultPage.checkNumberOfItemsInCart("3");
    }
}
