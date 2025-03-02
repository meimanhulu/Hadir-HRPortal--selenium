package com.juaracodingsqa20.kelompok3.definitions;

import java.text.ParseException;

import org.testng.Assert;

import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;
import com.juaracodingsqa20.kelompok3.screens.LaporanKehadiranScreen;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaporanKehadiranDefinition {
    private LaporanKehadiranScreen laporanKehadiranScreen;

    @Before("@LaporanKehadiran")
    public void setup() {
        laporanKehadiranScreen = new LaporanKehadiranScreen();
        UrlHelper.goToLaporanKehadiranUrl();
    }

    @Given("Nama Karyawan {string} di Kolom Pencarian Laporan Kehadiran")
    public void setInputNameLaporanKehadiran(String name) {
        laporanKehadiranScreen.inputName(name);
    }

    @When("Saya Mencari Laporan Kehadiran")
    public void executeSearchLaporanKehadiran() {
        laporanKehadiranScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran Sesuai Nama {string}")
    public void verifySearchResultLaporanKehadiran(String expectedName) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.verifySearchResult(expectedName));
    }

    @Given("Departemen {string} di Kolom Filter Departemen Laporan Kehadiran")
    public void setInputDepartmentLaporanKehadiran(String department) {
        laporanKehadiranScreen.inputDepartment(department);
    }

    @When("Saya Memfilter Departemen Laporan Kehadiran")
    public void executeDepartmentFilterLaporanKehadiran() {
        laporanKehadiranScreen.pressFilterSaveButton();
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran Sesuai Departemen {string}")
    public void verifyDepartmentFilterResultLaporanKehadiran(String expectedDepartment) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.verifyDepartmentFilterResult(expectedDepartment));
    }

    @Given("Tanggal Mulai {string} di Kolom Filter Tanggal Laporan Kehadiran")
    public void setInputFilterStartDateLaporanKehadiran(String startDate) {
        laporanKehadiranScreen.inputFilterStartDate(startDate);
        ;
    }

    @Given("Tanggal Selesai {string} di Kolom Filter Tanggal Laporan Kehadiran")
    public void setInputFilterEndDateLaporanKehadiran(String endDate) {
        laporanKehadiranScreen.inputFilterEndDate(endDate);
    }

    @When("Saya Memfilter Tanggal Laporan Kehadiran")
    public void executeDateFilterLaporanKehadiran() {
        laporanKehadiranScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran dari Tanggal {string}")
    public void verifyStartDateFilterResultLaporanKehadiran(String expectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.verifyStartDateFilterResult(expectedStartDate));
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran Sampai Tanggal {string}")
    public void verifyEndDateFilterResultLaporanKehadiran(String expectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.verifyEndDateFilterResult(expectedEndDate));
    }

    @When("Saya Menekan Tombol Reset di Laporan Kehadiran")
    public void executeResetButtonLaporanKehadiran() {
        laporanKehadiranScreen.pressFilterResetButton();
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran Tidak Berdasarkan Nama {string}")
    public void verifyResetSearchResultLaporanKehadiran(String unexpectedName) {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanKehadiranScreen.verifySearchResult(unexpectedName));
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran Tidak Berdasarkan Departemen {string}")
    public void verifyResetDepartmentResultLaporanKehadiran(String unexpectedDepartment) {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanKehadiranScreen.verifyDepartmentFilterResult(unexpectedDepartment));
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran Tidak Berdasarkan Tanggal Mulai {string}")
    public void verifyResetStartDateFilterResultLaporanKehadiran(String unexpectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanKehadiranScreen.verifyStartDateFilterResult(unexpectedStartDate));
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran Tidak Berdasarkan Tanggal Selesai Sampai {string}")
    public void verifyResetEndDateFilterResultLaporanKehadiran(String unexpectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanKehadiranScreen.verifyEndDateFilterResult(unexpectedEndDate));
    }

    @When("Saya Mengubah Jumlah Tampilan Tabel Laporan Kehadiran Menjadi {int}")
    public void changeRowsPerPageLaporanKehadiran(int rowsPerPage) {
        laporanKehadiranScreen.changeRowsPerPage(rowsPerPage);
    }

    @Then("Aplikasi Menampilkan {int} Laporan Kehadiran Teratas")
    public void verifyRowsPerPageLaporanKehadiran(int expectedRows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(laporanKehadiranScreen.getNumberOfTableRows(), expectedRows);
    }

    @When("Saya Berpindah Ke Laporan Kehadiran Halaman Selanjutnya")
    public void navigateToNextPageLaporanKehadiran() {
        laporanKehadiranScreen.pressNextPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran Halaman Kedua")
    public void verifyCurrentPageNumberIsSecondPageLaporanKehadiran() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.isSecondPage());
    }

    @When("Saya Berpindah Ke Laporan Kehadiran Halaman Sebelumnya")
    public void navigateToPreviousPageLaporanKehadiran() {
        laporanKehadiranScreen.pressPreviousPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran Halaman Pertama")
    public void verifyCurrentPageNumberIsFirstPageLaporanKehadiran() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.isFirstPage());
    }

    @When("Saya Berpindah Ke Laporan Kehadiran Halaman Terakhir")
    public void navigateToLastPageLaporanKehadiran() {
        laporanKehadiranScreen.pressLastPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Kehadiran Halaman Terakhir")
    public void verifyCurrentPageNumberIsLastPageLaporanKehadiran() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.isLastPage());
    }

    @When("Saya Berpindah Ke Laporan Kehadiran Halaman Pertama")
    public void navigateToFirstPageLaporanKehadiran() {
        SleepHelper.SleepLong();
        laporanKehadiranScreen.pressFirstPageButton();
    }

    @When("Saya Membuka Laporan Kehadiran")
    public void openLaporanKehadiranLaporanKehadiran() {
        laporanKehadiranScreen.open();
    }

    @Then("Aplikasi Menampilkan Semua Laporan Kehadiran Teratas")
    public void verifyDataShowedLaporanKehadiran() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.isDataShowed());
    }

    @When("Saya Menekan Tombol Export Laporan Kehadiran")
    public void pressExportButtonLaporanKehadiran() {
        laporanKehadiranScreen.pressFirstExportButton();
    }

    @Then("Aplikasi Menampilkan Dialog Export")
    public void verifyExportDialogIsDisplayed() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.isExportDialogClosed());
    }

    @When("Saya Mengkonfirmasi Export Laporan Kehadiran")
    public void pressSecondExportButtonLaporanKehadiran() {
        laporanKehadiranScreen.pressSecondExportButton();
    }

    @Then("Aplikasi Memproses Export Laporan Kehadiran")
    public void verifyExportProcessIsCompleted() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.isCorrectlyExported());
    }

    @When("Saya Menekan Tombol Batal Laporan Kehadiran")
    public void pressCancelExportButtonLaporanKehadiran() {
        laporanKehadiranScreen.pressCancelExportButton();
    }

    @Then("Aplikasi Menutup Dialog Export")
    public void verifyExportDialogIsClosed() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanKehadiranScreen.isExportDialogClosed());
    }

}

