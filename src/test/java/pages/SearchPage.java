package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;

public class SearchPage {
    private final SelenideElement searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));

    public void enterSearchQuery(String query) {
        searchInput.sendKeys(query);
    }

    public void shouldVisibleResults() {
        $$(className("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
    }

    public void clickFirstResultInSearch() {
        $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                .first()
                .click();
    }

    public void shouldVisibleArticleTitle(String expectedTitle) {
        $$(className("android.widget.TextView"))
                .findBy(text(expectedTitle))
                .shouldBe(visible);
    }
}