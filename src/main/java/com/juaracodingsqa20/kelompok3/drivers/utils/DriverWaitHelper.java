package com.juaracodingsqa20.kelompok3.drivers.utils;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracodingsqa20.kelompok3.drivers.DriverSingleton;

public class DriverWaitHelper {
    public final static WebDriverWait DRIVER_WAIT = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(30));
}
