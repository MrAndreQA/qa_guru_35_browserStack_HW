package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;

import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test
    void successfulSearchTest() {
        step("Open the search and enter 'Appium'", () -> {
            mainPage.clickWikiSearchIcon();
            searchPage.enterSearchQuery("Appium");
        });

        step("Verify content found", searchPage::shouldVisibleResults);
    }

    @Test
    void openAnyArticleTest() {
        step("Open the search and enter 'Selenide'", () -> {
            mainPage.clickWikiSearchIcon();
            searchPage.enterSearchQuery("Selenide");
        });

        step("Open the first article from the results", searchPage::clickFirstResultInSearch);

        step("Verify page is opened", () -> {
            searchPage.shouldVisibleArticleTitle("Selenide");
        });
    }
}