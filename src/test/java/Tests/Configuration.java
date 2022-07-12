package Tests;

import PageObjects.*;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static Tests.TestSuite.driverFactory;

public class Configuration {

    private static WebDriver driver = driverFactory.getDriver();
    private static final String ip = "http://18.134.130.35";
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
        /***************************
         This is testcase TC_002 for more details see https://docs.google.com/spreadsheets/d/1soyGJr5iF8xhKIVguclqZ68rI2IGdrIJz9fHYuiqjwY/edit#gid=817349775
         ***************************/

        //check that there are no existing behaviours - this is a precondition
        Assert.assertEquals(0,homepage.getNumberOfBehavioursSet());
        homepage.addNewBehaviour();
        behaviourPage.setBehaviours(new AnyTrigger(),new CustomTextResponse("This is a description","This is my response...."));
        behaviourPage.save();
        //expect there to be a new behaviour in the table
        Assert.assertEquals(1,homepage.getNumberOfBehavioursSet());
    }

    @Test
    public void userCanRemoveABehaviour(){
        /***************************
         This is testcase TC_003 for more details see https://docs.google.com/spreadsheets/d/1soyGJr5iF8xhKIVguclqZ68rI2IGdrIJz9fHYuiqjwY/edit#gid=817349775
         ***************************/
        homepage.addNewBehaviour();
        behaviourPage.setBehaviours(new AnyTrigger(),new CustomTextResponse("This is a description","This is my response...."));
        behaviourPage.save();
        //check that there is 1 existing behaviours - this is a precondition
        Assert.assertEquals(1,homepage.getNumberOfBehavioursSet());
        homepage.clearAllBehaviours();
        //check that there is now 0 existing behaviours
        Assert.assertEquals(0,homepage.getNumberOfBehavioursSet());
    }

    @Test @Ignore
    public void userShouldNotBeAbleToAddTextForACardNumberTrigger(){
        /***************************
         This is testcase TC_004 for more details see https://docs.google.com/spreadsheets/d/1soyGJr5iF8xhKIVguclqZ68rI2IGdrIJz9fHYuiqjwY/edit#gid=817349775
         ***************************/
        homepage.addNewBehaviour();
        behaviourPage.setBehaviours(new CardNumberTrigger("aaaaaaaaaaaaa", TriggerRequestType.ANY),
                new CustomTextResponse("This is a description",
                        "This is my response...."));
        behaviourPage.save();
        //we expect some sort of validation will stop us from adding a new behavaiour,
        //so we expect the number of behaviours to stay at 0
        Assert.assertEquals(0,homepage.getNumberOfBehavioursSet());
    }

    @Test @Ignore
    public void cardNumbersOver20ShouldNotBeAllowed(){
        /***************************
         This is testcase TC_023 for more details see https://docs.google.com/spreadsheets/d/1soyGJr5iF8xhKIVguclqZ68rI2IGdrIJz9fHYuiqjwY/edit#gid=817349775
         ***************************/
        homepage.addNewBehaviour();
        behaviourPage.setBehaviours(new CardNumberTrigger(StringUtils.repeat('1',21), TriggerRequestType.ANY),
                new CustomTextResponse("This is a description",
                        "This is my response...."));
        behaviourPage.save();
        //we expect some sort of validation will stop us from adding a new behavaiour,
        //so we expect the number of behaviours to stay at 0
        Assert.assertEquals(0,homepage.getNumberOfBehavioursSet());
    }

    @Test @Ignore
    public void numberOfCharactersShouldBeLimited(){
        /***************************
         This is testcase TC_024 for more details see https://docs.google.com/spreadsheets/d/1soyGJr5iF8xhKIVguclqZ68rI2IGdrIJz9fHYuiqjwY/edit#gid=817349775
         ***************************/
        homepage.addNewBehaviour();
        behaviourPage.setBehaviours(new CardNumberTrigger(StringUtils.repeat('a',31), TriggerRequestType.ANY),
                new CustomTextResponse("This is a description",
                        "This is my response...."));
        behaviourPage.save();
        //we expect some sort of validation will stop us from adding a new behavaiour,
        //so we expect the number of behaviours to stay at 0
        Assert.assertEquals(0,homepage.getNumberOfBehavioursSet());
    }
    @Test @Ignore
    public void shouldNotBeAbleToInputJustNumbersInTheNameSection(){
        /***************************
         This is testcase TC_025 for more details see https://docs.google.com/spreadsheets/d/1soyGJr5iF8xhKIVguclqZ68rI2IGdrIJz9fHYuiqjwY/edit#gid=817349775
         ***************************/
        homepage.addNewBehaviour();
        behaviourPage.setBehaviours(new NameOfCardHolderTrigger("00000000000000000000", TriggerRequestType.ANY),
                new CustomTextResponse("This is a description",
                        "This is my response...."));
        behaviourPage.save();
        //we expect some sort of validation will stop us from adding a new behavaiour,
        //so we expect the number of behaviours to stay at 0
        Assert.assertEquals(0,homepage.getNumberOfBehavioursSet());
    }

    @AfterClass
    public static void globalTearDown(){
        driverFactory.dropDriver();
    }
}
