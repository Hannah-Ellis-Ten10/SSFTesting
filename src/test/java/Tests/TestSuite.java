package Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by jack.forman on 22/10/2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Configuration.class})
public class TestSuite {

    static DriverFactory driverFactory = new DriverFactory();

    @BeforeClass
    public static void suiteSetUp(){
    }


    @AfterClass
    public static void tearDown(){
        driverFactory.getDriver().quit();
    }

}
