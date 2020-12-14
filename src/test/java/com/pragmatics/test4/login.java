package com.pragmatics.test4;

import com.github.javafaker.Faker;
import com.pragmatics.test4.pages.addNewEmployeePage;
import com.pragmatics.test4.pages.loginPage;
import com.pragmatics.test4.pages.menuPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class login {

    private ChromeDriver driver;
    private String Username = "Admin";
    private String Password = "Ptl@#321";
    private Faker faker;


    @BeforeClass(groups = {"smoke", "Regression"})
    public void beforeclass()
    {
        WebDriverManager.chromedriver().setup();
        // System.setProperty("webdriver.chrome.driver", "D:\\software\\selenium\\chromedriver.exe");
    }
    @BeforeMethod(groups = {"smoke", "Regression"})
    public void beforemethod()
    {
        //System.setProperty("webdriver.chrome.driver", "D:\\software\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless","--disable-gpu");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://hrm.pragmatictestlabs.com");
        faker = new Faker();
        //navigate(),navigate().to()
    }
    @Test
    public void loginTo()
    {
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        loginPage.clearAndSetUsername(Username).clearAndSetPassword(Password).clickLoginButton();
        loginPage.LoginPageNavigation();
    }
    @Test
    public void navigateMenus() throws InterruptedException {
        menuPage mnuPage = PageFactory.initElements(driver, menuPage.class);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        mnuPage.Menus();

    }
    @Test
    public void AddEmployee() throws InterruptedException {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String username = String.format("%s.%s", firstName, lastName);
        addNewEmployeePage anep = PageFactory.initElements(driver, addNewEmployeePage.class);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        anep.enterName(firstName,lastName);
        anep.getAdditionalLogin(username,"Ptl@#321A");
        anep.save();


    }

    @Test
    public void addNewEmployee() throws InterruptedException {
        loginTo();
        navigateMenus();
        AddEmployee();
    }
    @AfterMethod(groups = {"smoke", "Regression"})
    public void aftermethod()
    {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.close();
        driver.quit();
    }
}
