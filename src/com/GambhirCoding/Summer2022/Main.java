package com.GambhirCoding.Summer2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
	//this app works with chrome version 94.0

        NJITAutoJobApp.invokeBrowser();
        NJITAutoJobApp.useCredsToLogIn();

    }
}
