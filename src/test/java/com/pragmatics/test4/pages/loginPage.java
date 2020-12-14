package com.pragmatics.test4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
    //Elements
    @FindBy( id = "txtUsername")
    WebElement txtUsername;

    @FindBy( id = "txtPassword")
    WebElement txtPassword;

    @FindBy( id = "btnLogin")
    WebElement btnLogin;

    @FindBy( id = "spanMessage")
    WebElement spanMessage;

    @FindBy( id = "welcome")
    WebElement welcome;


    //Actions


    public loginPage clearAndSetUsername(String Username) {
        txtUsername.clear();
        txtUsername.sendKeys(Username);
        return this;
    }
    public loginPage clearAndSetPassword(String Password) {
        txtPassword.clear();
        txtPassword.sendKeys(Password);
        return this;
    }
    public loginPage clickLoginButton() {
        btnLogin.click();
        return this;
    }
    public String getErrorMessage() {
        return spanMessage.getText();
    }
    public void LoginPageNavigation() {
        boolean x = welcome.isDisplayed();
        if(x)
        {
            System.out.println("Logged successfully");
        }
        else
        {
            System.err.print("Logging Error");
        }
    }
}
