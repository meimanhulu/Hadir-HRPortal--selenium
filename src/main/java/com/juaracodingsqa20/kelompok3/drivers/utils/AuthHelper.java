package com.juaracodingsqa20.kelompok3.drivers.utils;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.juaracodingsqa20.kelompok3.drivers.DriverSingleton;

public class AuthHelper {
    public static WebDriver driver = DriverSingleton.getDriver();

    public static void executeLogin() {
        UrlHelper.goToAdminLoginUrl();
        WebElement emailInputFieldElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
        emailInputFieldElement.sendKeys("admin@hadir.com");
        WebElement passwordInputFieldElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        passwordInputFieldElement.sendKeys("admin@hadir");
        WebElement submitButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submitButtonElement.click();
    }

    public static void executeLogout() {
        UrlHelper.goToDashboardUrl();
        WebElement profileButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/header/div/button[3]")));
        profileButtonElement.click();
        WebElement logoutButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[3]/ul/div/button[2]")));
        logoutButtonElement.click();
    }
}
