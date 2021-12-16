package scheduler;

import config.ConfigurationScheduler;
import models.Auth;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import schedulerScreens.HomeScreen;
import schedulerScreens.LoginScreen;
import schedulerScreens.SplashScreen;

public class EventTest extends ConfigurationScheduler {

    @BeforeMethod
    public void precondition(){
        new LoginScreen(driver)
                .clickLoginBtnPositive(Auth.builder().email("your2@gmail.com").password("Yy123456$").build())
                .skipWizard()
                .isFabAddPresent();
    }

    @Test
    public void createNewEventTest(){
        boolean fabAddPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder().title("Event").type("new").breaks(2).wage(50).build())
                .isFabAddPresent();

        Assert.assertTrue(fabAddPresent);


    }

    @Test(enabled = false)
    public void createEventComplex(){
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .clickLoginBtnPositive(Auth.builder().email("your2@gmail.com").password("Yy123456$").build())
                .skipWizard()
                .initCreationEvent()
                .createNewEvent(Event.builder().title("Event").type("new").breaks(2).wage(50).build())
                .isFabAddPresent();
    }

    @AfterMethod
    public LoginScreen logOutAfterMethod(){
        if(!new LoginScreen(driver).isLoginBtnPresent()){
            new HomeScreen(driver)
                    .logOut();
        }
        return new LoginScreen(driver);
    }
}
