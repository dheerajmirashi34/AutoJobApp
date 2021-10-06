package com.GambhirCoding.Summer2022;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class NJITAutoJobApp {
    static WebDriver driver;

    public static void invokeBrowser(){
        try{
            //TODO: Give a relative path
            System.setProperty("webdriver.chrome.driver","C:\\Users\\dmirashi\\Downloads\\chromedriver_win32\\chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            driver.get("https://my.njit.edu/");

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean isLoginPage()
    {
        throw new NotImplementedException("not implemented yet");
    }

    public static void useCredsToLogIn()
    {
        File configFile = new File("src\\config.properties");
        String user="", password="";
        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);

            user = props.getProperty("user");
            password = props.getProperty("password");

            reader.close();
        } catch (FileNotFoundException ex) {
            //TODO: handle File not found
        } catch (IOException ex) {
            //TODO: Handle I/o Errors
        }

        driver.findElement(By.id("username")).sendKeys(user);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/form/div[3]/button")).click();

        driver.findElement(By.id("accept")).click();
        driver.findElement(By.id("submitbtn")).click();

    }

    public static void goTOCornerStore()
    {

        driver.get("https://portal.njit.edu/web/home-community/student-services");
        driver.get("https://myhub.njit.edu/see/");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a")).click();
        //driver.findElement(By.xpath("//*[@id=\"collapse7\"]/div/ul/li[1]/a")).click();
        driver.get("https://njit.csod.com/samldefault.aspx?ouid=2");

        //driver.findElement(By.xpath("//*[@id=\"collapse8\"]/div/ul/li[1]/a")).click();

        if(driver.findElement(By.xpath("//*[@id=\"CloseButton\"]")).isDisplayed())
        {
            driver.findElement(By.xpath("//*[@id=\"CloseButton\"]")).click();
        }

        driver.findElement(By.xpath("/html/body/form/div[4]/div/nav/ul/li[3]/a")).click();

    }


}
