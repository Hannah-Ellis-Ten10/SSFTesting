package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NameOfCardHolderTrigger implements Trigger{
    private static final By CARD_HOLDER_NAME_INPUT = By.cssSelector("input[name=name]");
    private static final By TYPE_INPUT = By.cssSelector("select[name=requestType]");

    String name;
    TriggerRequestType type;
    public NameOfCardHolderTrigger(String name,TriggerRequestType type){
        this.name = name;
        this.type = type;
    }
    @Override
    public String selectionText() {
        return "Realex: Name of card holder";
    }

    @Override
    public void populateTriggerData(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(CARD_HOLDER_NAME_INPUT)).sendKeys(name);
        Select typeSelection = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(TYPE_INPUT)));
        typeSelection.selectByVisibleText(TriggerRequestType.getSelectionText(type));
    }
}
