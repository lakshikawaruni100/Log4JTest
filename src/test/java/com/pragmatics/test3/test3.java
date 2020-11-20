package com.pragmatics.test3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class test3 {
    public static final Logger LOGGER = LogManager.getLogger(test3.class);

    WebDriver driver;
    @BeforeClass
    public void beforeclass()
    {
        LOGGER.info("I'm In Info Codding");
        WebDriverManager.chromedriver().setup();
        LOGGER.debug("Chrome driver setup is completed");
        // System.setProperty("webdriver.chrome.driver", "D:\\software\\selenium\\chromedriver.exe");
    }
    @BeforeMethod
    public void beforemethod()
    {
        //System.setProperty("webdriver.chrome.driver", "D:\\software\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless","--disable-gpu");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        LOGGER.debug("Chrome driver instance created");
        driver.manage().window().maximize();
        driver.get("http://hrm.pragmatictestlabs.com");
        LOGGER.debug("Chrome browser launched");
        //navigate(),navigate().to()
    }
    @Test
    public void testing()
    {
        LOGGER.info("Test case started");
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("Ptl@#321");
        driver.findElement(By.name("txtPassword")).submit();
        boolean welcome = driver.findElement(By.id("welcome")).isDisplayed();
        if (welcome= true)
        {
            System.out.println("logged successfully");
        }
        else
        {
            System.out.println("NOT logged successfully");
        }
        LOGGER.debug("Test case is completed");
    }
    @AfterMethod
    public void aftermethod()
    {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.close();
        driver.quit();
        LOGGER.debug("Chrome driver instance closed");

    }
}
