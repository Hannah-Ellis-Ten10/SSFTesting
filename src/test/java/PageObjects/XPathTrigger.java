package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XPathTrigger implements Trigger{
    private static final By XPATH_INPUT = By.cssSelector("input[name=xpath]");
    private String xpath;
    XPathTrigger(String xpath){
        this.xpath = xpath;
    }
    public String getXPath(){
        return xpath;
    }

    @Override
    public String selectionText() {
        return "XML: XPath";
    }

    @Override
    public void populateTriggerData(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(XPATH_INPUT)).sendKeys(xpath);
    }
}
