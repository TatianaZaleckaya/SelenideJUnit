package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.loginpage.LoginPage;
import pages.mainPage.MainPage;
import pages.userpage.UserPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;


public class GitHubTest {
    private static final LoginPage loginPage = new LoginPage();

    @BeforeAll
    static void setUp() {
        open("https://github.com");
        WebDriverRunner.driver().getWebDriver().manage().window().maximize();

    }

    @Test
    @Order(1)
    @DisplayName("Go to GitHub")
    void checkOpenLoginPage() {
        MainPage mainPage = new MainPage();
        mainPage.getLoginBTN().shouldBe(Condition.visible);
        mainPage.getLoginBTN().click();
        LoginPage loginPage = new LoginPage();
        loginPage.getLoginField().shouldBe(Condition.visible);
    }

    @ParameterizedTest(name = "{arguments} test")
    @Order(2)
    @MethodSource("getDataLogin")
    @DisplayName("Invalid Data for Login Page")
    void negativeLogin(String login, String password, SelenideElement el) {
        loginPage.login(login, password);
        el.shouldBe(Condition.visible);
    }

    @Test
    @Order(3)
    @DisplayName("Open User Page with valid Data")
    void checkOpenUserPage() {
        UserPage userPage = new UserPage();
        loginPage.getLoginField().shouldBe(Condition.visible).clear();
        loginPage.login("", "");
        System.out.println();
        userPage.getUserMenuBTN().click();
        userPage.getUserAccordionTitle().shouldBe(Condition.visible);
    }

    static Stream<Arguments> getDataLogin() {
        return Stream.of(
                Arguments.of("  ", , loginPage.getLoginField()),
                Arguments.of("", "  ", loginPage.getLoginField())
        );
    }
}
