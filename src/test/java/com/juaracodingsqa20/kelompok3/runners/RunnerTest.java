package com.juaracodingsqa20.kelompok3.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                // "src/test/resources/features/Persegi.feature", contohnya seperti ini
                "src/test/resources/features/LaporanIzinTerlambat.feature"
        },
        glue = {
                "com.juaracodingsqa20.kelompok3.definitions",
        },
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}