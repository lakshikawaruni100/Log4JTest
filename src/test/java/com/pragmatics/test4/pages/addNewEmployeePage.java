package com.pragmatics.test4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addNewEmployeePage {
    //Elements
    @FindBy( id = "firstName")
    WebElement fname;
    @FindBy( id = "middleName")
    WebElement mname;
    @FindBy( id = "lastName")
    WebElement lname;
    @FindBy( id = "chkLogin")
    WebElement adLoginDetails;
    @FindBy( id = "user_name")
    WebElement uname;
    @FindBy( id = "user_password")
    WebElement password;
    @FindBy( id = "re_password")
    WebElement repassword;
    @FindBy( id = "btnSave")
    WebElement addEmpSave;

    //actions
    public void enterName(String first,String last)
    {
        fname.sendKeys(first);
        //mname.sendKeys(middle);
        lname.sendKeys(last);
    }
    public void getAdditionalLogin(String user,String pwd)
    {
        adLoginDetails.click();
        uname.sendKeys(user);
        password.sendKeys(pwd);
        repassword.sendKeys(pwd);
    }
    public void save()
    {
        addEmpSave.click();
    }

}
