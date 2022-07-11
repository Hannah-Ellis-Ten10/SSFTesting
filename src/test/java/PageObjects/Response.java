package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface Response {
    public String selectionText();
    public void populateResponseData(WebDriver driver, WebDriverWait wait);
}
