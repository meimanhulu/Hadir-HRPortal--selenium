package com.juaracodingsqa20.kelompok3.definitions;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracodingsqa20.kelompok3.drivers.DriverSingleton;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;
import com.juaracodingsqa20.kelompok3.screens.LaporanIzinTerlambatScreen;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

    @Given("Nama Karyawan {string}")
    public void setInputName(String name) {
        laporanIzinTerlambatScreen.inputName(name);
    }

    @When("Saya Mencari Laporan Izin Terlambat")
    public void executeSearch() {
        laporanIzinTerlambatScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Nama {string}")
    public void verifySearchResult(String expectedName) {
        Assert.assertTrue(laporanIzinTerlambatScreen.verifySearchResult(expectedName));
    }

    @Given("Departemen {string}")
    public void setInputDepartment(String department) {
        laporanIzinTerlambatScreen.inputDepartment(department);
    }

    @When("Saya Memfilter Departemen Laporan Izin Terlambat")
    public void executeDepartmentFilter() {
        laporanIzinTerlambatScreen.pressFilterSaveButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Departemen {string}")
    public void verifyDepartmentFilterResult(String expectedDepartment) {
        Assert.assertTrue(laporanIzinTerlambatScreen.verifyDepartmentFilterResult(expectedDepartment));
    }

    @Given("Tanggal Mulai {string}")
    public void setInputFilterStartDate(String startDate) {
        laporanIzinTerlambatScreen.inputFilterStartDate(startDate);
        ;
    }

    @And("Tanggal Selesai {string}")
    public void setInputFilterEndDate(String endDate) {
        laporanIzinTerlambatScreen.inputFilterEndDate(endDate);
    }

    @When("Saya Memfilter Tanggal Laporan Izin Terlambat")
    public void executeDateFilter() {
        laporanIzinTerlambatScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat dari Tanggal {string}")
    public void verifyStartDateFilterResult(String expectedStartDate) throws ParseException {
        Assert.assertTrue(laporanIzinTerlambatScreen.verifyStartDateFilterResult(expectedStartDate));
    }

    @And("Sampai Tanggal {string}")
    public void verifyEndDateFilterResult(String expectedEndDate) throws ParseException {
        Assert.assertTrue(laporanIzinTerlambatScreen.verifyEndDateFilterResult(expectedEndDate));
    }
}
