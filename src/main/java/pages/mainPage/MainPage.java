package pages.mainPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class MainPage implements MainPageLocators {

    private final SelenideElement loginBTN = $(SIGN_IN_BTN);



}
