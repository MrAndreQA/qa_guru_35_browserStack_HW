package pages;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MainPage {
    public void clickWikiSearchIcon() {
        $(accessibilityId("Search Wikipedia")).click();
    }
}