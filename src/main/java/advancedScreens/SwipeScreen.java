package advancedScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeScreen extends BaseScreen {
    public SwipeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button'][2]")
    MobileElement swipeableBasic;
    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button'][5]")
    MobileElement swipeableVertical;


    public SwipeableBasicScreen selectSwipeableBasicScreen(){
        swipeableBasic.click();
        return new SwipeableBasicScreen(driver);
    }

    public SwipeableVerticalScreen selectSwipeableVerticalScreen(){
        swipeableVertical.click();
        return new SwipeableVerticalScreen(driver);
    }






}
