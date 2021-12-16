package advanced;

import advancedScreens.DragScreen;
import configAdvanced.ConfigAdvanced;
import org.testng.annotations.Test;

public class DragTest extends ConfigAdvanced {

    @Test
    public void dragDownTest(){
        new DragScreen(driver)
                .selectDraggableBasic()
                //.dragDown(4);
                .dragDownWindow();
    }

    @Test
    public void dragUpTest(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .drugUp();
    }
}
