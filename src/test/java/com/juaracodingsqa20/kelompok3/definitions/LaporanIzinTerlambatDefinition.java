package com.juaracodingsqa20.kelompok3.definitions;

import java.text.ParseException;
import org.testng.Assert;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;
import com.juaracodingsqa20.kelompok3.screens.LaporanIzinTerlambatScreen;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaporanIzinTerlambatDefinition {
    private LaporanIzinTerlambatScreen laporanIzinTerlambatScreen;

    @Before
    public void setup() {
        laporanIzinTerlambatScreen = new LaporanIzinTerlambatScreen();
        UrlHelper.goToLaporanIzinTerlambatUrl();
    }

    @Given("Nama Karyawan {string} di Kolom Pencarian Laporan Izin Terlambat")
    public void setInputNameLaporanIzinTerlambat(String name) {
        laporanIzinTerlambatScreen.inputName(name);
    }

    @When("Saya Mencari Laporan Izin Terlambat")
    public void executeSearchLaporanIzinTerlambat() {
        laporanIzinTerlambatScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Nama {string}")
    public void verifySearchResultLaporanIzinTerlambat(String expectedName) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.verifySearchResult(expectedName));
    }

    @Given("Departemen {string} di Kolom Filter Departemen Laporan Izin Terlambat")
    public void setInputDepartmentLaporanIzinTerlambat(String department) {
        laporanIzinTerlambatScreen.inputDepartment(department);
    }

    @When("Saya Memfilter Departemen Laporan Izin Terlambat")
    public void executeDepartmentFilterLaporanIzinTerlambat() {
        laporanIzinTerlambatScreen.pressFilterSaveButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Departemen {string}")
    public void verifyDepartmentFilterResultLaporanIzinTerlambat(String expectedDepartment) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.verifyDepartmentFilterResult(expectedDepartment));
    }

    @Given("Tanggal Mulai {string} di Kolom Filter Tanggal Laporan Izin Terlambat")
    public void setInputFilterStartDateLaporanIzinTerlambat(String startDate) {
        laporanIzinTerlambatScreen.inputFilterStartDate(startDate);
        ;
    }

    @Given("Tanggal Selesai {string} di Kolom Filter Tanggal Laporan Izin Terlambat")
    public void setInputFilterEndDateLaporanIzinTerlambat(String endDate) {
        laporanIzinTerlambatScreen.inputFilterEndDate(endDate);
    }

    @When("Saya Memfilter Tanggal Laporan Izin Terlambat")
    public void executeDateFilterLaporanIzinTerlambat() {
        laporanIzinTerlambatScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat dari Tanggal {string}")
    public void verifyStartDateFilterResultLaporanIzinTerlambat(String expectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.verifyStartDateFilterResult(expectedStartDate));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Sampai Tanggal {string}")
    public void verifyEndDateFilterResultLaporanIzinTerlambat(String expectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.verifyEndDateFilterResult(expectedEndDate));
    }

    @When("Saya Menekan Tombol Reset di Laporan Izin Terlambat")
    public void executeResetButtonLaporanIzinTerlambat() {
        laporanIzinTerlambatScreen.pressFilterResetButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Nama {string}")
    public void verifyResetSearchResultLaporanIzinTerlambat(String unexpectedName) {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinTerlambatScreen.verifySearchResult(unexpectedName));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Departemen {string}")
    public void verifyResetDepartmentResultLaporanIzinTerlambat(String unexpectedDepartment) {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinTerlambatScreen.verifyDepartmentFilterResult(unexpectedDepartment));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Tanggal Mulai {string}")
    public void verifyResetStartDateFilterResultLaporanIzinTerlambat(String unexpectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinTerlambatScreen.verifyStartDateFilterResult(unexpectedStartDate));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Tanggal Selesai Sampai {string}")
    public void verifyResetEndDateFilterResultLaporanIzinTerlambat(String unexpectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinTerlambatScreen.verifyEndDateFilterResult(unexpectedEndDate));
    }

    @When("Saya Mengubah Jumlah Tampilan Tabel Laporan Izin Terlambat Menjadi {int}")
    public void changeRowsPerPageLaporanIzinTerlambat(int rowsPerPage) {
        laporanIzinTerlambatScreen.changeRowsPerPage(rowsPerPage);
    }

    @Then("Aplikasi Menampilkan {int} Laporan Izin Terlambat Teratas")
    public void verifyRowsPerPageLaporanIzinTerlambat(int expectedRows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(laporanIzinTerlambatScreen.getNumberOfTableRows(), expectedRows);
    }

    @When("Saya Berpindah Ke Laporan Izin Terlambat Halaman Selanjutnya")
    public void navigateToNextPageLaporanIzinTerlambat() {
        laporanIzinTerlambatScreen.pressNextPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Halaman Kedua")
    public void verifyCurrentPageNumberIsSecondPageLaporanIzinTerlambat() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.isSecondPage());
    }

    @When("Saya Berpindah Ke Laporan Izin Terlambat Halaman Sebelumnya")
    public void navigateToPreviousPageLaporanIzinTerlambat() {
        laporanIzinTerlambatScreen.pressPreviousPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Halaman Pertama")
    public void verifyCurrentPageNumberIsFirstPageLaporanIzinTerlambat() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.isFirstPage());
    }

    @When("Saya Berpindah Ke Laporan Izin Terlambat Halaman Terakhir")
    public void navigateToLastPageLaporanIzinTerlambat() {
        laporanIzinTerlambatScreen.pressLastPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Terlambat Halaman Terakhir")
    public void verifyCurrentPageNumberIsLastPageLaporanIzinTerlambat() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.isLastPage());
    }

    @When("Saya Berpindah Ke Laporan Izin Terlambat Halaman Pertama")
    public void navigateToFirstPageLaporanIzinTerlambat() {
        SleepHelper.SleepLong();
        laporanIzinTerlambatScreen.pressFirstPageButton();
    }

    @When("Saya Membuka Laporan Izin Terlambat")
    public void openLaporanIzinTerlambatLaporanIzinTerlambat() {
        laporanIzinTerlambatScreen.open();
    }

    @Then("Aplikasi Menampilkan Semua Laporan Izin Terlambat Teratas")
    public void verifyDataShowedLaporanIzinTerlambat() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinTerlambatScreen.isDataShowed());
    }
}
