package com.juaracodingsqa20.kelompok3.drivers;

import org.openqa.selenium.WebDriver;
import com.juaracodingsqa20.kelompok3.drivers.strategies.DriverStrategyImplementer;
import com.juaracodingsqa20.kelompok3.drivers.utils.BrowserType;

public class DriverSingleton {
    public static WebDriver driver;
    private static String browserName = BrowserType.CHROME;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new DriverStrategyImplementer().setStrategy(browserName);
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
