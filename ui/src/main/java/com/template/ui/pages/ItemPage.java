package com.template.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Accessors(fluent = true)
public class ItemPage extends BasePage{
    private SelenideElement title = $("h1");
    private SelenideElement quantitySelector = $("select[aria-label='Quantity']");
    private SelenideElement addToCartButton = $("button[data-tl-id='ProductPrimaryCTA-cta_add_to_cart_button']");

    @Step
    public void addItemToCart(int count) {
        if (count > 1)
            quantitySelector.selectOption(count-1);

        addToCartButton.click();
    }
}
