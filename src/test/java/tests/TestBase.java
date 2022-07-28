package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestBase {
    static String env;

    @BeforeAll
    public static void setup() {
        env = System.getProperty("env", "local");
        if (env.equals("local")) {
            Configuration.browser = LocalMobileDriver.class.getName();
        } else if (env.equals("browserstack")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else {
            System.out.println("I don't know this ENVIRONMENT");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (env.equals("browserstack")) {
            Attach.video(Attach.sessionId());
        }
        step("Close driver", Selenide::closeWebDriver);
    }
}
