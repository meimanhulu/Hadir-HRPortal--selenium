package com.juaracodingsqa20.kelompok3;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.juaracodingsqa20.kelompok3.drivers.DriverSingleton;
import com.juaracodingsqa20.kelompok3.drivers.utils.BrowserType;

public class HookTest {
    @BeforeTest
    public void init() {
        DriverSingleton.getDriver(BrowserType.CHROME);
    }

    @AfterTest
    public void teardown() {
        DriverSingleton.quitDriver();
    }
}
