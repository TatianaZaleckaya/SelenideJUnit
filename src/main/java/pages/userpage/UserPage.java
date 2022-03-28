package pages.userpage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class UserPage implements UserPageLocators {

    private final SelenideElement userMenuBTN = $(USER_MENU_BTN);
    private final SelenideElement userAccordionTitle = $(USER_ACCORDION_TITLE);
}
