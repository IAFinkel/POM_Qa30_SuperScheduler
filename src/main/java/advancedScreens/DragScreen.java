package advancedScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class DragScreen extends BaseScreen{
    public DragScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button'][2]")
    MobileElement selectDragable;
    @FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Swipe\"]")
    MobileElement swipeBtn;

    public DragableBasicScreen selectDraggableBasic(){
        selectDragable.click();
        return new DragableBasicScreen(driver);

    }
    public SwipeScreen selectSwipeScreen(){
        swipeBtn.click();
        return new SwipeScreen(driver);
    }
}
