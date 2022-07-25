package tests.hometask;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.OnboardingPage;
import tests.TestBase;

public class MainPageTests extends TestBase {
    OnboardingPage onboardingPage = new OnboardingPage();
    MainPage mainPage = new MainPage();

    @Test
    @AllureId("11631")
    void checkDonate () {
        onboardingPage.skipAndCheck();
        mainPage.checkDonate();
    }
}
