package com.juaracodingsqa20.kelompok3.runners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.juaracodingsqa20.kelompok3.drivers.DriverSingleton;
import com.juaracodingsqa20.kelompok3.drivers.utils.AuthHelper;

import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
                "src/test/resources/features/LaporanIzinTerlambat.feature",
                "src/test/resources/features/LaporanIzinPulangCepat.feature",
                "src/test/resources/features/LaporanSemua.feature"
}, glue = {
                "com.juaracodingsqa20.kelompok3.definitions",
}, plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
})
public class RunnerTest extends AbstractTestNGCucumberTests {
    
}