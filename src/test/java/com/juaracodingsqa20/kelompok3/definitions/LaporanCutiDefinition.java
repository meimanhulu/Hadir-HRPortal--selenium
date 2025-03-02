package com.juaracodingsqa20.kelompok3.definitions;

import java.text.ParseException;
import org.testng.Assert;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;
import com.juaracodingsqa20.kelompok3.screens.LaporanCutiScreen;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaporanCutiDefinition {
    private LaporanCutiScreen laporanCutiScreen;

    @Before("@LaporanCuti")
    public void setup() {
        laporanCutiScreen = new LaporanCutiScreen();
        UrlHelper.goToLaporanCutiUrl();
    }

    @Given("Nama Karyawan {string} di Kolom Pencarian Laporan Cuti")
    public void setInputNameLaporanCuti(String name) {
        laporanCutiScreen.inputName(name);
    }

    @When("Saya Mencari Laporan Cuti")
    public void executeSearchLaporanCuti() {
        laporanCutiScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Cuti Sesuai Nama {string}")
    public void verifySearchResultLaporanCuti(String expectedName) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanCutiScreen.verifySearchResult(expectedName));
    }

    @Given("Departemen {string} di Kolom Filter Departemen Laporan Cuti")
    public void setInputDepartmentLaporanCuti(String department) {
        laporanCutiScreen.inputDepartment(department);
    }

    @When("Saya Memfilter Departemen Laporan Cuti")
    public void executeDepartmentFilterLaporanCuti() {
        laporanCutiScreen.pressFilterSaveButton();
    }

    @Then("Aplikasi Menampilkan Laporan Cuti Sesuai Departemen {string}")
    public void verifyDepartmentFilterResultLaporanCuti(String expectedDepartment) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanCutiScreen.verifyDepartmentFilterResult(expectedDepartment));
    }

    @Given("Tanggal Mulai {string} di Kolom Filter Tanggal Laporan Cuti")
    public void setInputFilterStartDateLaporanCuti(String startDate) {
        laporanCutiScreen.inputFilterStartDate(startDate);
        ;
    }

    @Given("Tanggal Selesai {string} di Kolom Filter Tanggal Laporan Cuti")
    public void setInputFilterEndDateLaporanCuti(String endDate) {
        laporanCutiScreen.inputFilterEndDate(endDate);
    }

    @When("Saya Memfilter Tanggal Laporan Cuti")
    public void executeDateFilterLaporanCuti() {
        laporanCutiScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Cuti dari Tanggal {string}")
    public void verifyStartDateFilterResultLaporanCuti(String expectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanCutiScreen.verifyStartDateFilterResult(expectedStartDate));
    }

    @Then("Aplikasi Menampilkan Laporan Cuti Sampai Tanggal {string}")
    public void verifyEndDateFilterResultLaporanCuti(String expectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanCutiScreen.verifyEndDateFilterResult(expectedEndDate));
    }

    @When("Saya Menekan Tombol Reset di Laporan Cuti")
    public void executeResetButtonLaporanCuti() {
        laporanCutiScreen.pressFilterResetButton();
    }

    @Then("Aplikasi Menampilkan Laporan Cuti Tidak Berdasarkan Nama {string}")
    public void verifyResetSearchResultLaporanCuti(String unexpectedName) {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanCutiScreen.verifySearchResult(unexpectedName));
    }

    @Then("Aplikasi Menampilkan Laporan Cuti Tidak Berdasarkan Departemen {string}")
    public void verifyResetDepartmentResultLaporanCuti(String unexpectedDepartment) {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanCutiScreen.verifyDepartmentFilterResult(unexpectedDepartment));
    }

    @Then("Aplikasi Menampilkan Laporan Cuti Tidak Berdasarkan Tanggal Mulai {string}")
    public void verifyResetStartDateFilterResultLaporanCuti(String unexpectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanCutiScreen.verifyStartDateFilterResult(unexpectedStartDate));
    }

    @Then("Aplikasi Menampilkan Laporan Cuti Tidak Berdasarkan Tanggal Selesai Sampai {string}")
    public void verifyResetEndDateFilterResultLaporanCuti(String unexpectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanCutiScreen.verifyEndDateFilterResult(unexpectedEndDate));
    }

    @When("Saya Mengubah Jumlah Tampilan Tabel Laporan Cuti Menjadi {int}")
    public void changeRowsPerPageLaporanCuti(int rowsPerPage) {
        laporanCutiScreen.changeRowsPerPage(rowsPerPage);
    }

    @Then("Aplikasi Menampilkan {int} Laporan Cuti Teratas")
    public void verifyRowsPerPageLaporanCuti(int expectedRows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(laporanCutiScreen.getNumberOfTableRows(), expectedRows);
    }

    @When("Saya Berpindah Ke Laporan Cuti Halaman Selanjutnya")
    public void navigateToNextPageLaporanCuti() {
        laporanCutiScreen.pressNextPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Cuti Halaman Kedua")
    public void verifyCurrentPageNumberIsSecondPageLaporanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanCutiScreen.isSecondPage());
    }

    @When("Saya Berpindah Ke Laporan Cuti Halaman Sebelumnya")
    public void navigateToPreviousPageLaporanCuti() {
        laporanCutiScreen.pressPreviousPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Cuti Halaman Pertama")
    public void verifyCurrentPageNumberIsFirstPageLaporanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanCutiScreen.isFirstPage());
    }

    @When("Saya Berpindah Ke Laporan Cuti Halaman Terakhir")
    public void navigateToLastPageLaporanCuti() {
        laporanCutiScreen.pressLastPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Cuti Halaman Terakhir")
    public void verifyCurrentPageNumberIsLastPageLaporanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanCutiScreen.isLastPage());
    }

    @When("Saya Berpindah Ke Laporan Cuti Halaman Pertama")
    public void navigateToFirstPageLaporanCuti() {
        SleepHelper.SleepLong();
        laporanCutiScreen.pressFirstPageButton();
    }

    @When("Saya Membuka Laporan Cuti")
    public void openLaporanCutiLaporanCuti() {
        laporanCutiScreen.open();
    }

    @Then("Aplikasi Menampilkan Semua Laporan Cuti Teratas")
    public void verifyDataShowedLaporanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanCutiScreen.isDataShowed());
    }
}
