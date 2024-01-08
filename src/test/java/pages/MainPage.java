package pages;

import enums.MenuEnum;
import forms.DropdownMenu;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

public class MainPage {
    private static Logger log = Logger.getLogger(MenuEnum.class);

    private MainMenu mainMenu = new MainMenu();

    private DropdownMenu dropdownMenu = new DropdownMenu();

    @Step("Show menu item")
    public void showMenuByItem(String menuItem) {
        log.info(" Show menu item " + menuItem);
        mainMenu.hoverOverItem(menuItem);
        dropdownMenu.waitUntilVisible();
    }
    @Step("Show menu by item")
    public void showMenuByItem(MenuEnum menuItem) {
        Allure.description("Item name  " + menuItem);
        mainMenu.hoverOverItem(menuItem.getMenuText());
        dropdownMenu.waitUntilVisible();
    }
    @Step("Is dropdown visible")
    public boolean isDropdownItemVisible(String name) {
        return dropdownMenu.isItemVisible(name);
    }
}
