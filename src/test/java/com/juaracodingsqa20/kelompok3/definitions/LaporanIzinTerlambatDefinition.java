package com.juaracodingsqa20.kelompok3.definitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracodingsqa20.kelompok3.drivers.DriverSingleton;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;
import com.juaracodingsqa20.kelompok3.screens.LaporanIzinTerlambatScreen;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaporanIzinTerlambatDefinition {
    private LaporanIzinTerlambatScreen laporanIzinTerlambatScreen;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver();
        laporanIzinTerlambatScreen = new LaporanIzinTerlambatScreen(driver);
        UrlHelper.goToLaporanIzinTerlambatUrl();
    }

    @Given("Nama Karyawan {string}.")
    public void setInputNama(String name) {
        laporanIzinTerlambatScreen.inputNama(name);
    }

    @When("Saya Mencari Laporan Izin Terlambat.")
    public void executeSearch() {
        laporanIzinTerlambatScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Nama {string}.")
    public void verifySearchResult(String expectedName) {
        Assert.assertTrue(laporanIzinTerlambatScreen.verifySearchResult(expectedName));
    }

    @Given("Departemen {string}.")
    public void setInputDepartemen(String department) {
        laporanIzinTerlambatScreen.inputDepartment(department);
    }

    @When("Saya Memfilter Departemen Laporan Izin Terlambat.")
    public void executeFilter() {
        laporanIzinTerlambatScreen.pressFilterSaveButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Departemen {string}.")
    public void verifyFilterResult(String expectedDepartment) {
        Assert.assertTrue(laporanIzinTerlambatScreen.verifyDepartmentFilterResult(expectedDepartment));
    }
}
