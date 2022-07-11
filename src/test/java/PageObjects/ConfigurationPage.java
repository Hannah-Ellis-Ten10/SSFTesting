package PageObjects;

import org.openqa.selenium.WebDriver;

public class ConfigurationPage extends BasePage{
    public ConfigurationPage(WebDriver driver,String ip,int port){
        super(driver,ip,port);
    }

    public void goTo(){
        driver.get(baseURL);
    }
}
