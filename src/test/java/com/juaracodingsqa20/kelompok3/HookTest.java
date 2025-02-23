package com.juaracodingsqa20.kelompok3;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.juaracodingsqa20.kelompok3.drivers.DriverSingleton;
import com.juaracodingsqa20.kelompok3.drivers.utils.AuthHelper;

public class HookTest {
    @BeforeTest
    public void init() {
        DriverSingleton.getDriver();
        AuthHelper.executeLogin();
    }

    @AfterTest
    public void teardown() {
        AuthHelper.executeLogout();
        DriverSingleton.quitDriver();
    }
}
