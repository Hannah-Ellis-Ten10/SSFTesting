package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ConfigurationPage extends BasePage{
    private static final By ADD_BEHAVIOUR_BUTTON = By.id("new-behaviour-button");
    private static final By BEHAVIOUR_TABLE = By.id("behaviours");
    private static final By REMOVE_BUTTON = By.id("delete-behaviour-button");
    private static final By CONFIRM_DELETE_BUTTON = By.cssSelector("div.modal-footer > button.btn-primary");
    public ConfigurationPage(WebDriver driver,String ip,int port){
        super(driver,ip,port);
    }

    public void goTo(){
        driver.get(baseURL);
    }

    public void addNewBehaviour(){
        waitAndClick(ADD_BEHAVIOUR_BUTTON);
    }

    private List<WebElement> getBehaviourTableRows(){
        final WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(BEHAVIOUR_TABLE));
        return table.findElements(By.tagName("tr"));
    }
    public int getNumberOfBehavioursSet(){
        return getBehaviourTableRows().size();
    }

    public void clearAllBehaviours(){
        try {
            final List<WebElement> tableRows = getBehaviourTableRows();
            if(tableRows.size() != 0) {
                tableRows.forEach(row -> {
                    row.click();
                    waitAndClick(REMOVE_BUTTON);
                    waitAndClick(CONFIRM_DELETE_BUTTON);
                });
            }
        }
        catch( NoSuchElementException e){
            //don't really care maybe just a little warning message
            System.out.println("WARNING no existing behaviours found");
        }
    }
}
