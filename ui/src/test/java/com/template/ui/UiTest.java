package com.template.ui;

import com.template.ui.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.template.ui.steps.Steps.addItemToCartAndReturn;

public class UiTest extends BaseTest {

    private MainPage mainPage = new MainPage();
    private SearchPage searchPage = new SearchPage();
    private ItemPage itemPage = new ItemPage();
    private AddedToCartPage addedToCartPage = new AddedToCartPage();
    private CartPage cartPage = new CartPage();


    @BeforeMethod
    public void openMainPage(){
        open(baseUrl);
        clearBrowserCookies();
    }

    @Test(description = "Verify success message after adding item to cart")
    public void addedToCartSuccessMessageTest() {
        int itemsCount = 1;

        mainPage.searchFor("marvel action figure");

        // add one item to cart
        searchPage.clickOnSearchItem(0);
        itemPage.addItemToCart(itemsCount);

        // verify correct success message is displayed
        addedToCartPage.verifySuccessMessage(itemsCount);
    }

    @Test(description = "Verify cart tooltip changes after adding items to cart")
    public void cartItemsCountTest() {
        mainPage.searchFor("marvel action figure");

        // add first item to cart with count 1
        int firstItemIndex = 1;
        int firstItemCount = 1;
        addItemToCartAndReturn(firstItemIndex, firstItemCount);

        // check for tooltip updates
        searchPage
                .cartTooltip()
                .shouldBe(visible)
                .shouldHave(text(String.valueOf(firstItemCount)));

        // add second item to cart with count 1
        int secondItemIndex = 1;
        int secondItemCount = 1;
        addItemToCartAndReturn(secondItemIndex, secondItemCount);

        // check for tooltip updates
        searchPage
                .cartTooltip()
                .shouldBe(visible)
                .shouldBe(text(String.valueOf(firstItemCount + secondItemCount)));

        // verify cart contains added items count
        searchPage.openCart();
        cartPage.verifyTotalItemsCount(firstItemCount + secondItemCount);
    }

    @Test(description = "Failed test just to show how it looks in report")
    public void failedTest() {
        mainPage.searchFor("marvel action figure");

        // add 1 item to cart
        searchPage.clickOnSearchItem(1);
        itemPage.addItemToCart(1);

        // check for success message with 2 items added
        addedToCartPage.verifySuccessMessage(2);
    }

}
