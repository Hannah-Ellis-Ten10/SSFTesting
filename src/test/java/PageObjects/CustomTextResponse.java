package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomTextResponse implements Response{
    private static final By DESCRIPTION_INPUT = By.cssSelector("input[name=description]");
    private static final By RESPONSE_TEXTAREA = By.cssSelector("textarea[name=response]");
    String description;
    String responseText ;

    public CustomTextResponse(String description, String responseText){
        this.description = description;
        this.responseText = responseText;
    }


    @Override
    public String selectionText() {
        return "Custom text response";
    }

    @Override
    public void populateResponseData(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(DESCRIPTION_INPUT)).sendKeys(description);
        wait.until(ExpectedConditions.elementToBeClickable(RESPONSE_TEXTAREA)).sendKeys(responseText);
    }
}
