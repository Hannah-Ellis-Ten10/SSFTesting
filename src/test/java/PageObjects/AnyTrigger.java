package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnyTrigger implements Trigger {
    @Override
    public String selectionText() {
        return "Any";
    }

    @Override
    public void populateTriggerData(WebDriver driver, WebDriverWait wait) {
        //nothing to populate
    }
}
