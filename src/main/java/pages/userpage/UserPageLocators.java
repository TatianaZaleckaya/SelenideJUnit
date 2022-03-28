package pages.userpage;

import org.openqa.selenium.By;

public interface UserPageLocators {

     By USER_MENU_BTN = By.xpath("//summary[@aria-label='View profile and more']");
     By USER_ACCORDION_TITLE = By.xpath("//a[text()='Signed in as ']");
}
