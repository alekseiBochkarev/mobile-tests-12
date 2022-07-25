package tests.hometask;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.OnboardingPage;
import tests.TestBase;

public class MainPageTests extends TestBase {
    OnboardingPage onboardingPage = new OnboardingPage();
    MainPage mainPage = new MainPage();

    @Test
    void checkDonate () {
        onboardingPage.skipAndCheck();
        mainPage.checkDonate();
    }
}
