package com.juaracodingsqa20.kelompok3.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriverInfo;

import com.juaracodingsqa20.kelompok3.drivers.managers.ChromeDriverManager;
import com.juaracodingsqa20.kelompok3.drivers.managers.EdgeDriverManager;
import com.juaracodingsqa20.kelompok3.drivers.managers.FirefoxDriverManager;
import com.juaracodingsqa20.kelompok3.drivers.utils.BrowserType;

public class DriverStrategyImplementer implements IDriverStrategy {
    @Override
    public WebDriver setStrategy(String strategy) {
        switch (strategy) {
            case BrowserType.CHROME:
                return ChromeDriverManager.make();
            case BrowserType.EDGE:
                return EdgeDriverManager.make();
            case BrowserType.FIREFOX:
                return FirefoxDriverManager.make();
            default:
                return ChromeDriverManager.make();

        }
    }
}
