package com.GambhirCoding.Summer2022;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class NJITAutoJobApp {

    public static void invokeBrowser(){
        try{
            //TODO: Give a relative path
            System.setProperty("webdriver.chrome.driver","C:\\Users\\dmirashi\\Downloads\\chromedriver_win32\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
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
            //TODO: Handle I/o Eoors
        }

        System.out.println(user);
    }
}
