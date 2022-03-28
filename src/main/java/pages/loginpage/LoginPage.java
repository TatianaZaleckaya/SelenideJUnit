package pages.loginpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPage implements LoginPageLocators {

    private final SelenideElement loginField = $(LOGIN_FIELD);
    private final SelenideElement passwordField = $(PASSWORD_FIELD);
    private final SelenideElement signInBtn = $(SIGN_IN_BTN);


    public void login(String login, String password) {
        loginField.shouldBe(Condition.visible).click();
        loginField.sendKeys(login);
        passwordField.shouldBe(Condition.visible).click();
        passwordField.sendKeys(password);
        signInBtn.shouldBe(Condition.visible).click();
    }
}
