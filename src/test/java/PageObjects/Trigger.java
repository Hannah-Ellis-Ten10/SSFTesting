package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Trigger {
    public String selectionText();
    public void populateTriggerData(WebDriver driver, WebDriverWait wait);
}
