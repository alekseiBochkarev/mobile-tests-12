package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

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

    @Step
    public void checkTextOnPage(String text){
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
    public void openFourthScreen () {
        fourthScreen.click();
    }


}
