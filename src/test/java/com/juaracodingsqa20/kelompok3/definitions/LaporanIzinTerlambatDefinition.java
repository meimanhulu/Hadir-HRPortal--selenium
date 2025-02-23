package com.juaracodingsqa20.kelompok3.definitions;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracodingsqa20.kelompok3.drivers.DriverSingleton;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
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
        SleepHelper.SleepLong();
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
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.verifyDepartmentFilterResult(expectedDepartment));
    }

    @Given("Tanggal Mulai {string}")
    public void setInputFilterStartDate(String startDate) {
        laporanIzinTerlambatScreen.inputFilterStartDate(startDate);
        ;
    }

    @Given("Tanggal Selesai {string}")
    public void setInputFilterEndDate(String endDate) {
        laporanIzinTerlambatScreen.inputFilterEndDate(endDate);
    }

    @When("Saya Memfilter Tanggal Laporan Izin Terlambat")
    public void executeDateFilter() {
        laporanIzinTerlambatScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat dari Tanggal {string}")
    public void verifyStartDateFilterResult(String expectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.verifyStartDateFilterResult(expectedStartDate));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Sampai Tanggal {string}")
    public void verifyEndDateFilterResult(String expectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.verifyEndDateFilterResult(expectedEndDate));
    }

    @When("Saya Menekan Tombol Reset")
    public void executeResetButton() {
        laporanIzinTerlambatScreen.pressFilterResetButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Nama {string}")
    public void verifyResetSearchResult(String unexpectedName) {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinTerlambatScreen.verifySearchResult(unexpectedName));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Departemen {string}")
    public void verifyResetDepartmentResult(String unexpectedDepartment) {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinTerlambatScreen.verifyDepartmentFilterResult(unexpectedDepartment));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Tanggal Mulai {string}")
    public void verifyResetStartDateFilterResult(String unexpectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinTerlambatScreen.verifyStartDateFilterResult(unexpectedStartDate));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Tanggal Selesai Sampai {string}")
    public void verifyResetEndDateFilterResult(String unexpectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinTerlambatScreen.verifyEndDateFilterResult(unexpectedEndDate));
    }

    @When("Saya Mengubah Jumlah Tampilan Tabel Laporan Izin Terlambat Menjadi {int}")
    public void changeRowsPerPage(int rowsPerPage) {
        laporanIzinTerlambatScreen.changeRowsPerPage(rowsPerPage);
    }

    @Then("Aplikasi Menampilkan {int} Laporan Izin Terlambat Teratas")
    public void verifyRowsPerPage(int expectedRows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(laporanIzinTerlambatScreen.getNumberOfTableRows(), expectedRows);
    }

    @When("Saya Berpindah Ke Laporan Izin Terlambat Halaman Selanjutnya")
    public void navigateToNextPage() {
        laporanIzinTerlambatScreen.pressNextPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Halaman Kedua")
    public void verifyCurrentPageNumberIsSecondPage() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.isSecondPage());
    }
}
