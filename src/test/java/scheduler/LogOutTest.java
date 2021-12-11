package scheduler;

import config.ConfigurationScheduler;
import config.MyDataProvider;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import schedulerScreens.LoginScreen;

import java.lang.reflect.Method;

public class LogOutTest extends ConfigurationScheduler {

    @BeforeMethod
    public void startTest(Method m) {
        logger.info("Start test-->" + m.getName());
    }

    @AfterMethod
    public void finishTest(Method m) {
        logger.info("Finish the Test-->" + m.getName());
    }

    @Test(dataProvider = "loginFromFilePos", dataProviderClass = MyDataProvider.class)
    public void logOut(Auth auth) {

        logger.info("Test logOut starts with email -" + auth.getEmail());
        logger.info("Test logOut starts with password -" + auth.getPassword());

        boolean loginBtnPresent = new LoginScreen(driver)
                .clickLoginBtnPositive(auth)
                .skipWizard()
                .logOut()
                .isLoginBtnPresent();

        Assert.assertTrue(loginBtnPresent);


    }
}
