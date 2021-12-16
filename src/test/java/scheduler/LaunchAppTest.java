package scheduler;

import config.ConfigurationScheduler;
import org.testng.Assert;
import org.testng.annotations.Test;
import schedulerScreens.SplashScreen;

public class LaunchAppTest extends ConfigurationScheduler {

    @Test(enabled = false)
    public void launchTest(){
        String version = new SplashScreen(driver).getCurrencyVersion();
        Assert.assertEquals(version,"0.0.3");
    }
}
