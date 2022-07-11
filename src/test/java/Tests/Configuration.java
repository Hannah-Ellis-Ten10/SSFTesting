package Tests;

import PageObjects.ConfigurationPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static Tests.TestSuite.driverFactory;

public class Configuration {

    public static WebDriver driver = driverFactory.getDriver();

    public static ConfigurationPage homepage = new ConfigurationPage(driver,"http://35.177.16.31",8080);
    /**
     * This should make sure we are on the correct page, i.e. set up each test case so we can be sure that they run
     */
    @Before
    public void globalSetUp(){
        homepage.goTo();
    }

    @Test
    public void test(){
        System.out.println("Got Here");
    }

    @After
    public void individualTearDown(){

    }

    @AfterClass
    public static void mainTearDown(){
        driverFactory.dropDriver();
    }
}
