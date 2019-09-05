package com.template.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Accessors(fluent = true)
class BasePage {
    private SelenideElement menuIcon = $("button[aria-label='Menu']");
    private SelenideElement searchField = $("input[aria-label='Search']");
    private SelenideElement searchButton = $("button[aria-label='Perform Search']");
    private SelenideElement groceryIcon = $("a[data-uid='Ck5pMBh7']");
    private SelenideElement accountIcon = $("button[data-uid='BkZXF-83']");
    private SelenideElement storesIcon = $("button[data-uid='NjA8H2h-']");
    private SelenideElement cartIcon = $("a[data-uid='Y4khnDFy']");
    private SelenideElement cartTooltip = $("div[data-tl-id='header-cart-tooltip']");

    @Step
    public void searchFor(String key) {
        searchField.setValue(key);
        searchButton.click();
    }

    @Step
    public void openCart() {
        cartIcon.click();
    }
}
