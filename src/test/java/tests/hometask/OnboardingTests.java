package tests.hometask;

import org.junit.jupiter.api.Test;
import pages.OnboardingPage;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

public class OnboardingTests extends TestBase {
    OnboardingPage onboardingPage = new OnboardingPage();

    @Test
    void onboardingPageTest () {
        String firstScreenText = "The Free Encyclopedia …in over 300 languages";
        String secondScreenText = "New ways to explore";
        String thirdScreenText = "Reading lists with sync";
        String fourthScreenText = "Send anonymous data";
        step("Check text on the first screen", () -> {
            onboardingPage.checkTextOnPage(firstScreenText);
        });
        step("Open second screen and check text", () -> {
            onboardingPage.openSecondScreen();
            onboardingPage.checkTextOnPage(secondScreenText);
        });
        step("Open third screen and check text", () -> {
            onboardingPage.openThirdScreen();
            onboardingPage.checkTextOnPage(thirdScreenText);
        });
        step("Open fourth screen and check text", () -> {
            onboardingPage.openFourthScreen();
            onboardingPage.checkTextOnPage(fourthScreenText);
        });
    }

    @Test
    void checkSkipButton () {
        onboardingPage.skipAndCheck();
    }

    @Test
    void checkContinueButton () {
        String secondScreenText = "New ways to explore";
        onboardingPage.checkContinue();
        onboardingPage.checkTextOnPage(secondScreenText);
    }

    @Test
    void checkAddNewLanguage () {
        onboardingPage.checkAddOrEditLanguages();
    }
}
