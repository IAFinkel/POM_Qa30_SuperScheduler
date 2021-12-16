package advancedScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DragableBasicScreen extends BaseScreen{
    public DragableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

        @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']")
    List<MobileElement> list;//все элементы с данным локатором помещаем в коллекцию

    public DragableBasicScreen dragDown(){//сместить элемент на один вниз
        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();
        int xFrom = rect.getX()+rect.getWidth()/2;
        int yFrom = rect.getY()+rect.getHeight()/2;//координаты для захвата эдемента

        int xTo = xFrom;
        int yTo = yFrom + rect.getHeight();//координаты для перемещения элемента

        TouchAction<?> touchAction = new TouchAction(driver); //класс actions для моб апликаций
        touchAction.longPress(PointOption.point(xFrom,yFrom))//взять элемент по координатам
                .moveTo(PointOption.point(xTo,yTo))//переместить в точку по координатам
                .release()//перемещение
                .perform();
        return this;
    }

    public DragableBasicScreen dragDown(int count){//сместить элемент на один вниз на опред кол-во ступеней
        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();
        int xFrom = rect.getX()+rect.getWidth()/2;
        int yFrom = rect.getY()+rect.getHeight()/2;//координаты для захвата эдемента

        int xTo = xFrom;
        int yTo = yFrom + rect.getHeight()*count;//координаты для перемещения элемента

        TouchAction<?> touchAction = new TouchAction(driver); //класс actions для моб апликаций
        touchAction.longPress(PointOption.point(xFrom,yFrom))//взять элемент по координатам
                .moveTo(PointOption.point(xTo,yTo))//переместить в точку по координатам
                .release()//перемещение
                .perform();
        return this;
    }

    public DragableBasicScreen dragDownWindow(){//сместить элемент вниз до конца экрана

        Dimension window = driver.manage().window().getSize();//размер экрана


        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();
        int xFrom = rect.getX()+rect.getWidth()/2;
        int yFrom = rect.getY()+rect.getHeight()/2;//координаты для захвата эдемента

        int xTo = xFrom;
        int yTo = window.getHeight()-rect.getHeight()/2;//координаты для перемещения элемента

        TouchAction<?> touchAction = new TouchAction(driver); //класс actions для моб апликаций
        touchAction.longPress(PointOption.point(xFrom,yFrom))//взять элемент по координатам
                .moveTo(PointOption.point(xTo,yTo))//переместить в точку по координатам
                .release()//перемещение
                .perform();
        return this;
    }


    public DragableBasicScreen drugUp() {

        MobileElement el = list.get(5);
        Rectangle rect = el.getRect();
        int x = rect.getX()+rect.getWidth()/2;
        int yfrom = rect.getY()+rect.getHeight()/2;

        int yto = yfrom - rect.getHeight();

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(x,yfrom))
                .moveTo(PointOption.point(x,yto))
                .release()
                .perform();


        return this;
    }
}
