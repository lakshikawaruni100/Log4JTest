package com.pragmatics.test4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class menuPage {

    @FindBy( xpath = "//b[text()='PIM']")
    WebElement mainMenuItem;
    @FindBy( xpath = "//a[text()='Add Employee']")
    WebElement subMenuItem;




    //Actions

    public menuPage Menus() throws InterruptedException {
        mainMenuItem.click();
        Thread.sleep(100);
        subMenuItem.click();
        Thread.sleep(100);
        return this;
    }
}
