package scheduler;

import config.ConfigurationScheduler;
import config.MyDataProvider;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import schedulerScreens.LoginScreen;
import schedulerScreens.SplashScreen;

import java.lang.reflect.Method;

public class LoginTest extends ConfigurationScheduler {

    @BeforeMethod
    public void startTest(Method m){
    logger.info("Start test-->"+m.getName());
    }

    @AfterMethod
    public void finishTest(Method m){
        logger.info("Finish the Test-->"+m.getName());
    }

    @Test
    public void loginSuccessTest() {
        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();
        Assert.assertTrue(isFabPresent);
    }

    @Test
    public void loginStartLoginScreen() {
        boolean fabAddPresent = new LoginScreen(driver)
                .fillEmail("your2@gmail.com")
                .fillPassword("Yy123456$")
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();
        Assert.assertTrue(fabAddPresent);

    }



    @Test(dataProvider = "loginDtoPos", dataProviderClass = MyDataProvider.class)
    public void loginComplexTestPositive(Auth auth) {

        logger.info("Test loginDtoPos starts with email -"+auth.getEmail());
        logger.info("Test loginDtoPos starts with password -"+auth.getPassword());

        boolean fabAddPresent = new LoginScreen(driver)
                .clickLoginBtnPositive(auth)
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(fabAddPresent);


    }

    @Test(dataProvider = "loginDtoNeg", dataProviderClass = MyDataProvider.class)
    public void loginComplexTestNegative(Auth auth){
        logger.info("Test loginDtoNeg starts with email -"+auth.getEmail());
        logger.info("Test loginDtoNeg starts with password -"+auth.getPassword());

        boolean isLoginBtnPresent = new LoginScreen(driver)
                .clickLoginBtnNegative(auth)
                .checkErrorMessage("Wrong email or password")
                .confirmErrorMessage()
                .isLoginBtnPresent();

        Assert.assertTrue(isLoginBtnPresent);


    }

    @Test(dataProvider = "loginFromFilePos", dataProviderClass = MyDataProvider.class)
    public void loginFromFileTestPositive(Auth auth) {

        logger.info("Test loginFromFilePos starts with email -" + auth.getEmail());
        logger.info("Test loginFromFilePos starts with password -" + auth.getPassword());

        boolean fabAddPresent = new LoginScreen(driver)
                .clickLoginBtnPositive(auth)
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(fabAddPresent);


    }

    @Test(dataProvider = "loginFromFileNeg", dataProviderClass = MyDataProvider.class)
    public void loginFromFileTestNegative(Auth auth){

        logger.info("Test loginFromFileNeg starts with email -"+auth.getEmail());
        logger.info("Test loginFromFileNeg starts with password -"+auth.getPassword());

        boolean isLoginBtnPresent = new LoginScreen(driver)
                .clickLoginBtnNegative(auth)
                .checkErrorMessage("Wrong email or password")
                .confirmErrorMessage()
                .isLoginBtnPresent();

        Assert.assertTrue(isLoginBtnPresent);


    }
}
