package com.template.ui.steps;

import com.template.ui.pages.AddedToCartPage;
import com.template.ui.pages.ItemPage;
import com.template.ui.pages.SearchPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.back;

public class Steps {
    private static SearchPage searchPage = new SearchPage();
    private static ItemPage itemPage = new ItemPage();
    private static AddedToCartPage addedToCartPage = new AddedToCartPage();

    @Step("Adds item with given index with given count to cart and returns on search page")
    public static void addItemToCartAndReturn(int itemIndex, int count) {
        searchPage.clickOnSearchItem(itemIndex - 1);
        itemPage.addItemToCart(count);
        addedToCartPage.verifySuccessMessage(count);
        back();
        back();
    }
}
