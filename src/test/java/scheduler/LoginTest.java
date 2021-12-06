package scheduler;

import config.ConfigurationScheduler;
import manager.MyDataProvider;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import schedulerScreens.LoginScreen;
import schedulerScreens.SplashScreen;
import schedulerScreens.WizardScreen;

public class LoginTest extends ConfigurationScheduler {
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

        boolean fabAddPresent = new LoginScreen(driver)
                .clickLoginBtnPositive(auth)
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(fabAddPresent);


    }

    @Test(dataProvider = "loginDtoNeg", dataProviderClass = MyDataProvider.class)
    public void loginComplexTestNegative(Auth auth){

        LoginScreen loginScreen = new LoginScreen(driver)
                .clickLoginBtnNegative(auth);

        Assert.assertTrue(loginScreen.isLoginBtnPresent());

    }
}
