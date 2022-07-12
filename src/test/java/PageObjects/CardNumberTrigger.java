package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardNumberTrigger implements Trigger {
    private static final By CARD_NUMBER_INPUT = By.cssSelector("input[name=number]");
    private static final By TYPE_INPUT = By.cssSelector("select[name=requestType]");

    String cardNumber ;
    CardNumberTriggerType type;
    public CardNumberTrigger(String cardNumber, CardNumberTriggerType type){
        this.cardNumber = cardNumber;
        this.type = type;
    }
    @Override
    public String selectionText() {
        return "Realex: Card number";
    }

    @Override
    public void populateTriggerData(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(CARD_NUMBER_INPUT)).sendKeys(cardNumber);
        Select typeSelection = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(TYPE_INPUT)));
        typeSelection.selectByVisibleText(CardNumberTriggerType.getSelectionText(type));
    }
}
