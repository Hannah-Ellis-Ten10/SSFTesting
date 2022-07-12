package Tests;

import PageObjects.AnyTrigger;
import PageObjects.BehaviourPage;
import PageObjects.ConfigurationPage;
import PageObjects.CustomTextResponse;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static Tests.TestSuite.driverFactory;

public class Configuration {

    private static WebDriver driver = driverFactory.getDriver();
    private static final String ip = "http://35.177.16.31";
    private static final int port = 8080;


    private static ConfigurationPage homepage = new ConfigurationPage(driver,ip,port);
    private static BehaviourPage behaviourPage = new BehaviourPage(driver,ip,port);
    @Before
    public void setUp(){
        homepage.goTo();
        homepage.clearAllBehaviours();
    }

    @Test
    public void userCanAddNewBehaviour(){
        //check that there are no existing behaviours - this is a precondition
        Assert.assertEquals(homepage.getNumberOfBehavioursSet(),0);
        homepage.addNewBehaviour();
        behaviourPage.setBehaviours(new AnyTrigger(),new CustomTextResponse("This is a description","This is my response...."));
        behaviourPage.save();
        //expect there to be a new behaviour in the table
        Assert.assertEquals(homepage.getNumberOfBehavioursSet(),1);
    }

    @Test
    public void userCanRemoveABehaviour(){
        homepage.addNewBehaviour();
        behaviourPage.setBehaviours(new AnyTrigger(),new CustomTextResponse("This is a description","This is my response...."));
        behaviourPage.save();
        //check that there is 1 existing behaviours - this is a precondition
        Assert.assertEquals(homepage.getNumberOfBehavioursSet(),1);
        homepage.clearAllBehaviours();
        //check that there is now 0 existing behaviours
        Assert.assertEquals(homepage.getNumberOfBehavioursSet(),0);
    }

    @After
    public void tearDown(){

    }

    @AfterClass
    public static void globalTearDown(){
        driverFactory.dropDriver();
    }
}
