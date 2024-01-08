package forms;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverRunner;

import java.util.List;

public class DropdownMenu {

    private static Logger log = Logger.getLogger(DropdownMenu.class);
    private final String SECTION_PATTERN="//span[contains(text(),'%s') and contains(@class,'b-main-navigation__dropdown-advert-sign')]";

    private By dropdownRoot = By.xpath("//div[contains(@class,'b-main-navigation__dropdown_visible')]");

    public boolean isItemVisible(String section){
        log.debug("Checking if " + section + " menu item is visible");
        List<WebElement> elems =  WebDriverRunner.getDriver().findElements(By.xpath(String.format(SECTION_PATTERN, section)));
        if (elems.isEmpty()) {
            return false;
        }
        return elems.stream().anyMatch(WebElement::isDisplayed);
    }

    public void waitUntilVisible() {
        log.debug("Waiting for element by locator: " + dropdownRoot);
        try {
            new WebDriverWait(WebDriverRunner.getDriver(), 5)
                    .until(ExpectedConditions.presenceOfElementLocated(dropdownRoot));
        } catch (ElementNotVisibleException ex){
            log.error(" Element is not visible " + ex.getMessage() + " by locator " + dropdownRoot + " after 5 seconds");
        }
    }
}
