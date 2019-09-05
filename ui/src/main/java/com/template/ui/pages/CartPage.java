package com.template.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Accessors(fluent = true)
public class CartPage extends BasePage {
    private SelenideElement cartTitle = $("h1.cart-list-title.access-title");

    @Step
    public void verifyTotalItemsCount(int expectedCount) {
        cartTitle.shouldHave(Condition.text(String.format("Your cart: %d items", expectedCount)));
    }
}
