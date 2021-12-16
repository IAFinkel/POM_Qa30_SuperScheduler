package advanced;

import advancedScreens.DragScreen;
import configAdvanced.ConfigAdvanced;
import org.testng.annotations.Test;

public class TestMy extends ConfigAdvanced {
    @Test
    public void launch(){

        int i = new DragScreen(driver)
                .selectSwipeScreen()
                .selectSwipeableBasicScreen()
                .listQuantity();

        System.out.println("List size is - "+i);

    }
}
