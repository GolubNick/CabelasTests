package models;

import elements.*;

public class LoginPage extends PageObject {

    private static LoginPage instance;

    private Input login;
    private Input password;
    private Button loginButton;

    public static LoginPage get(){
        if (instance == null){
            instance = new LoginPage().init();
        }
        return instance;
    }

    private LoginPage init(){
        super.pageLocator = new Page("//*[@id = 'accountLoginTemplate']");
        login = new Input("//input[@id = 'userName']");
        password = new Input("//input[@id = 'password']");
        loginButton = new Button("//input[@id = 'logInBtn']");
        return this;
    }

    public void setLogin(String value){
        login.setText(value);
    }

    public void setPassword(String value){
        password.setText(value);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
