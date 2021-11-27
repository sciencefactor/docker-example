package io.github.eroshenkoam;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GithubIssueTest {

    @BeforeEach
    public void initDriver() throws IOException {
        final String url = "http://selenoid:4444/wd/hub";
        URL remoteSelenoid = new URL(url);
        System.out.println("Driver will try to connect to Selenoid with address: " + remoteSelenoid);
        WebDriver driver = new RemoteWebDriver(remoteSelenoid, DesiredCapabilities.chrome());
        driver.manage().window().setSize(new Dimension(1920,1024));
        WebDriverRunner.setWebDriver(driver);
    }

    @Test
    @Issue("AE-2")
    @DisplayName("aawerawer")
    public void testIssue() {
        step("awerawer", () -> {
            open("https://github.com");
        });
        step("RWara", () -> {
            $x("//*[contains(@class, 'header-search-input')]").click();
            $x("//*[contains(@class, 'header-search-input')]").sendKeys("eroshenkoam/allure-example");
            $x("//*[contains(@class, 'header-search-input')]").submit();
            $x("//a[@href='/eroshenkoam/allure-example']").click();
        });
    }

    @AfterEach
    public void stopDriver() {
        Optional.ofNullable(WebDriverRunner.getWebDriver()).ifPresent(WebDriver::quit);
    }

}
