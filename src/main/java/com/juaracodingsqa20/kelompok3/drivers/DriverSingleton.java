package com.juaracodingsqa20.kelompok3.drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import com.juaracodingsqa20.kelompok3.drivers.strategies.DriverStrategyImplementer;
import com.juaracodingsqa20.kelompok3.drivers.utils.BrowserType;

public class DriverSingleton {
    public static WebDriver driver;

    public static WebDriver getDriver() {
   
        if (driver == null) {
            driver = new DriverStrategyImplementer().setStrategy(System.getProperty("testBrowser", BrowserType.CHROME));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
