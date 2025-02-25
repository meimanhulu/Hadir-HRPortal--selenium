package com.juaracodingsqa20.kelompok3.drivers.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager {
    public static WebDriver make() {
        EdgeOptions options = new EdgeOptions();
        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
        options.addArguments("--start-maximized");
        
        return new EdgeDriver(options);
    }
}
