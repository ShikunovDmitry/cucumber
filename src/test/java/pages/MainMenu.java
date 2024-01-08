package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utils.WebDriverRunner;

public class MainMenu {
    private String ITEM_PATTERN = "//span[contains(@class,'main-navigation') and contains(text(), '%s')]";

    Logger logger = Logger.getLogger(this.getClass());

    public void clickOnItem(String itemName) {
        WebDriverRunner.getDriver().findElement(By.xpath(String.format(ITEM_PATTERN, itemName))).click();
    }

    public void hoverOverItem(String itemName) {
        logger.debug(String.format("Hold on the item %s by locator %s", itemName, String.format(ITEM_PATTERN, itemName)));
        Actions action = new Actions(WebDriverRunner.getDriver());
        action.moveToElement(WebDriverRunner.getDriver().findElement(By.xpath(String.format(ITEM_PATTERN, itemName))))
                .build().perform();
    }
}
