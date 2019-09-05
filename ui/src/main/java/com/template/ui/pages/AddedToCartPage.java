package com.template.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Accessors(fluent = true)
public class AddedToCartPage extends BasePage {
    private SelenideElement successMessage = $("h3 span[role='heading']");
    private SelenideElement viewCartButton = $("button[data-tl-id='IPPacViewCartBtn']");
    private SelenideElement checkOutButton = $("button[data-tl-id='CartCheckOutBtnBottom']");

    @Step
    public void verifySuccessMessage(int addedItems) {
        successMessage.shouldHave(Condition.text(String.format("  You just added %d item", addedItems)));
    }
}
