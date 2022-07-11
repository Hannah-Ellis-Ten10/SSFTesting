package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BehaviourPage extends BasePage{
    private static final By TRIGGER_TYPE_SELECT = By.cssSelector("select[ng-model*=trigger]");
    private static final By RESPONSE_TYPE_SELECT = By.cssSelector("select[ng-model*=response]");
    private static final By SAVE_BUTTON = By.id("save-button");
    private static final By CANCEL_BUTTON = By.id("cancel-button");
    public BehaviourPage(WebDriver driver, String ip, int port){
        super(driver,ip,port);
    }
    public void setBehaviours(Trigger trigger,Response response){
        Select triggerType = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(TRIGGER_TYPE_SELECT)));
        triggerType.selectByVisibleText(trigger.selectionText());
        trigger.populateTriggerData(driver,wait);

        Select responseType = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(RESPONSE_TYPE_SELECT)));
        responseType.selectByVisibleText(response.selectionText());
        response.populateResponseData(driver,wait);
    }
    public void save(){
        waitAndClick(SAVE_BUTTON);
    }
    public void cancel(){
        waitAndClick(CANCEL_BUTTON);
    }
}
