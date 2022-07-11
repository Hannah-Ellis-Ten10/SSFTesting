package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    static {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;
    private int refCount=0;

    public WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        refCount++;
        return driver;
    }

    private void setDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void dropDriver(){
        refCount--;
        if(refCount==0){
            driver.quit();
            driver = null ;
        }
    }

}
