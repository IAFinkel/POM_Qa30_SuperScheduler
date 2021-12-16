package advancedScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeableBasicScreen extends BaseScreen {
    public SwipeableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='android:id/text1']")
    List<MobileElement> list;

    public int listQuantity(){
        return list.size();
    }

    public SwipeableBasicScreen swipeToRight() {
        MobileElement element = list.get(0);
        Rectangle rect = element.getRect();
        System.out.println(rect.getWidth());

        int xfrom = rect.getX()+(rect.getWidth()/10)*2;
        int y = rect.getY()+rect.getHeight()/2;

        int xto = rect.getX()+(rect.getWidth()/10)*9;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xfrom,y))
                .moveTo(PointOption.point(xto,y))
                .release()
                .perform();

        return this;
    }

    public SwipeableBasicScreen swipeToLeft() {
        MobileElement element = list.get(3);
        Rectangle rect = element.getRect();
        System.out.println(rect.getWidth());

        int xfrom = rect.getX()+(rect.getWidth()-20);
        int y = rect.getY()+rect.getHeight()/2;

        int xto = rect.getX()+(rect.getWidth()/10)*2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xfrom,y))
                .moveTo(PointOption.point(xto,y))
                .release()
                .perform();

        return this;
    }
}
