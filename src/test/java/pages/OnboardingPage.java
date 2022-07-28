package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OnboardingPage {
    SelenideElement pageText = $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"));
    SelenideElement secondScreen = $(AppiumBy.xpath("//android.widget.HorizontalScrollView[@content-desc=\"Page 1 of 4\"]" +
            "/android.widget.LinearLayout/android.widget.LinearLayout[2]"));
    SelenideElement thirdScreen = $(AppiumBy.xpath("//android.widget.HorizontalScrollView[@content-desc=\"Page 2 of 4\"]" +
            "/android.widget.LinearLayout/android.widget.LinearLayout[3]"));
    SelenideElement fourthScreen = $(AppiumBy.xpath("//android.widget.HorizontalScrollView[@content-desc=\"Page 3 of 4\"]" +
            "/android.widget.LinearLayout/android.widget.LinearLayout[4]"));
    SelenideElement skipButton = $(AppiumBy.xpath("//android.widget.Button[@text='SKIP']"));
    SelenideElement continueButton = $(AppiumBy.xpath("//android.widget.Button[@text='CONTINUE']"));

    @Step
    public void checkTextOnPage(String text) {
        pageText.shouldHave(text(text));
    }

    @Step
    public void openSecondScreen() {
        secondScreen.click();
    }

    @Step
    public void openThirdScreen() {
        thirdScreen.click();
    }

    @Step
    public void openFourthScreen() {
        fourthScreen.click();
    }

    @Step
    public void skipAndCheck() {
        skipButton.shouldBe(exist, Duration.ofMillis(10000)).click();
        $(AppiumBy.xpath("//android.widget.ImageView[contains(@resource-id, 'org.wikipedia.alpha:id/main_toolbar_wordmark')]"))
                .shouldBe(exist, Duration.ofMillis(10000));
    }

    @Step
    public void checkContinue() {
        continueButton.shouldBe(exist, Duration.ofMillis(10000)).click();
    }

    @Step
    public void checkAddOrEditLanguages() {
        $(AppiumBy.xpath("//android.widget.LinearLayout[contains(@resource-id, 'org.wikipedia.alpha:id/addLangContainer')]"))
                .shouldBe(exist, Duration.ofMillis(10000)).click();
        $(AppiumBy.xpath("//android.widget.TextView[@text='Wikipedia languages']")).shouldBe(exist, Duration.ofMillis(10000));
    }
}
