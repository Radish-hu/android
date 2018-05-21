package com.Radish.hu.testApp;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.logging.Logger;

public class Action {
    public DesiredCapabilities cap;
    public AndroidDriver driver;
    @BeforeMethod
    public void init() throws Exception{
        cap=new DesiredCapabilities();
        cap.setCapability("deviceName","oppo R11");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","22");
        cap.setCapability("app","D:\\Tools\\android\\ContactManager.apk");
        cap.setCapability("androidPackage","com.example.android.contactmanager");
        cap.setCapability("androidActivity",".ContactManager");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        System.out.println("app start");
    }
    @Test
    public void execute(){
        driver.findElement(By.id("com.example.android.contactmanager:id/showInvisible")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("Radish.hu");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("13539888421");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys("kelun.hu@360gst.com");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();
        Reporter.log("添加成功");
    }
    @AfterMethod
    public void destroy() {
        driver.quit();
    }
}
