package pages.loginpage;

import org.openqa.selenium.By;

public interface LoginPageLocators {

    By LOGIN_FIELD = By.xpath("//input[@name='login']");
    By PASSWORD_FIELD = By.xpath("//input[@name='password']");
    By SIGN_IN_BTN = By.xpath("//input[@name='commit']");
}
