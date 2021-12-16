package advanced;

import advancedScreens.DragScreen;
import configAdvanced.ConfigAdvanced;
import org.testng.annotations.Test;

public class SwipeTests extends ConfigAdvanced {

    @Test
    public void swipeTest(){
        new DragScreen(driver)
                .selectSwipeScreen()
                .selectSwipeableBasicScreen()
                .swipeToRight();

    }

    @Test
    public void swipeTest2(){
        new DragScreen(driver)
                .selectSwipeScreen()
                .selectSwipeableBasicScreen()
                .swipeToLeft();

    }

    @Test
    public void downSwipeTest(){
        new DragScreen(driver)
                .selectSwipeScreen()
                .selectSwipeableVerticalScreen()
                .downSwipe()
                .clickOkBtn();
    }

    @Test
    public void upSwipeTest(){
        new DragScreen(driver)
                .selectSwipeScreen()
                .selectSwipeableVerticalScreen()
                .upSwipe()
                .clickOkBtn();
    }
}
