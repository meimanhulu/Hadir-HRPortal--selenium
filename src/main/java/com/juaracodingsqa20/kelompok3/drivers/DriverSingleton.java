package com.juaracodingsqa20.kelompok3.drivers;

import org.openqa.selenium.WebDriver;
import com.juaracodingsqa20.kelompok3.drivers.strategies.DriverStrategyImplementer;

public class DriverSingleton {
    public static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            driver = new DriverStrategyImplementer().setStrategy(browser);
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
