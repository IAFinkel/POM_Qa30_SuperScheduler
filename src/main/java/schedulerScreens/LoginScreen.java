package schedulerScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    AndroidElement emailEditText;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']" )
    MobileElement okbtn;


    public LoginScreen fillEmail(String email) {
        should(emailEditText,20);
        type(emailEditText, email);
        return this;//нет перехода на новую страницу, поэтому возращаем экземпляр данного класса

    }

    public LoginScreen fillPassword(String password) {
        type(passwordEditText, password);
        return this;
    }

    public WizardScreen clickLoginBtn(){
        hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);//происходит переход на новый экран=>требуется вернуть экз нового класса
    }

    public WizardScreen clickLoginBtnPositive(Auth auth){
        should(emailEditText,20);
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());
        hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }
    public LoginScreen clickLoginBtnNegative(Auth auth){
        should(emailEditText,20);
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());
        hideKeyboard();
        loginButton.click();
        return new LoginScreen(driver);
    }

    public boolean isLoginBtnPresent(){
        return isDisplayedWithExp(loginButton);
    }

    public LoginScreen checkErrorMessage(String text){
        shouldHave(errorMessage,text,10);
        return this;

    }
    public LoginScreen confirmErrorMessage(){
        okbtn.click();
        return this;
    }


}
