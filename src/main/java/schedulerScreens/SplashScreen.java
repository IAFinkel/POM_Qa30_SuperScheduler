package schedulerScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen {

    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/app_version_res']")
    MobileElement versionTextView; //описание элемента

    public String getCurrencyVersion(){
        return versionTextView.getText();
    }

    public LoginScreen checkVersion(String text){
        shouldHave(versionTextView,text,10);
        return new LoginScreen(driver);
    }
}
