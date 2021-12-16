package advancedScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeableVerticalScreen extends BaseScreen {
    public SwipeableVerticalScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='android:id/text1']")
    List<MobileElement> list;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okBtn;


    public SwipeableVerticalScreen downSwipe() {
        MobileElement element = list.get(1);
        Rectangle rect = element.getRect();
        System.out.println(rect.getWidth());

        int x = rect.getX()+(rect.getWidth()/2);
        int yfrom = rect.getY()+rect.getHeight()/2;

        int yto = rect.getY()+(rect.getHeight()/10)*9;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(x,yfrom))
                .moveTo(PointOption.point(x,yto))
                .release()
                .perform();

        return this;
    }

    public SwipeableVerticalScreen upSwipe() {
        MobileElement element = list.get(4);
        Rectangle rect = element.getRect();
        System.out.println(rect.getWidth());

        int x = rect.getX()+(rect.getWidth()/2);
        int yfrom = rect.getY()+rect.getHeight()-20;

        int yto = rect.getY()+(rect.getHeight()/10)*1;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(x,yfrom))
                .moveTo(PointOption.point(x,yto))
                .release()
                .perform();

        return this;
    }

    public void clickOkBtn(){
        pause(2000);
       if(isDisplayedWithExp(okBtn)){
           okBtn.click();
       }
    }
}
