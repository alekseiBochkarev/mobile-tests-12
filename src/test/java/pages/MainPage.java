package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    SelenideElement moreButton = $(AppiumBy.accessibilityId("More"));
    SelenideElement donateButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Donate']"));

    @Step
    public void checkDonate() {
        moreButton.shouldBe(Condition.exist, Duration.ofMillis(10000)).click();
        donateButton.shouldBe(Condition.exist, Duration.ofMillis(10000)).click();
        $(AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'com.android.chrome:id/url_bar')]"))
                .shouldBe(Condition.exist, Duration.ofMillis(10000));
    }
}
