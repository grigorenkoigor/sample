package com.template.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$$;

@Getter
@Accessors(fluent = true)
public class SearchPage extends BasePage {
    private ElementsCollection searchItems = $$("ul.search-result-gridview-items > li");

    @Step
    public void clickOnSearchItem(int index) {
        searchItems.get(index).click();
    }
}
