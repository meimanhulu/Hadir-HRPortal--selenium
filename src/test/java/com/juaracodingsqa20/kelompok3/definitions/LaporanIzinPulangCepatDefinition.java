package com.juaracodingsqa20.kelompok3.definitions;

import java.text.ParseException;
import org.testng.Assert;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;
import com.juaracodingsqa20.kelompok3.screens.LaporanIzinPulangCepatScreen;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaporanIzinPulangCepatDefinition {
    private LaporanIzinPulangCepatScreen laporanIzinPulangCepatScreen;

    @Before("@LaporanIzinPulangCepat")
    public void setup() {
        laporanIzinPulangCepatScreen = new LaporanIzinPulangCepatScreen();
        UrlHelper.goToLaporanIzinPulangCepatUrl();
    }

    @Given("Nama Karyawan {string} di Kolom Pencarian Laporan Izin Pulang Cepat")
    public void setInputNameLaporanIzinPulangCepat(String name) {
        laporanIzinPulangCepatScreen.inputName(name);
    }

    @When("Saya Mencari Laporan Izin Pulang Cepat")
    public void executeSearchLaporanIzinPulangCepat() {
        laporanIzinPulangCepatScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat Sesuai Nama {string}")
    public void verifySearchResultLaporanIzinPulangCepat(String expectedName) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinPulangCepatScreen.verifySearchResult(expectedName));
    }

    @Given("Departemen {string} di Kolom Filter Departemen Laporan Izin Pulang Cepat")
    public void setInputDepartmentLaporanIzinPulangCepat(String department) {
        laporanIzinPulangCepatScreen.inputDepartment(department);
    }

    @When("Saya Memfilter Departemen Laporan Izin Pulang Cepat")
    public void executeDepartmentFilterLaporanIzinPulangCepat() {
        laporanIzinPulangCepatScreen.pressFilterSaveButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat Sesuai Departemen {string}")
    public void verifyDepartmentFilterResultLaporanIzinPulangCepat(String expectedDepartment) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinPulangCepatScreen.verifyDepartmentFilterResult(expectedDepartment));
    }

    @Given("Tanggal Mulai {string} di Kolom Filter Tanggal Laporan Izin Pulang Cepat")
    public void setInputFilterStartDateLaporanIzinPulangCepat(String startDate) {
        laporanIzinPulangCepatScreen.inputFilterStartDate(startDate);
        ;
    }

    @Given("Tanggal Selesai {string} di Kolom Filter Tanggal Laporan Izin Pulang Cepat")
    public void setInputFilterEndDateLaporanIzinPulangCepat(String endDate) {
        laporanIzinPulangCepatScreen.inputFilterEndDate(endDate);
    }

    @When("Saya Memfilter Tanggal Laporan Izin Pulang Cepat")
    public void executeDateFilterLaporanIzinPulangCepat() {
        laporanIzinPulangCepatScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat dari Tanggal {string}")
    public void verifyStartDateFilterResultLaporanIzinPulangCepat(String expectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinPulangCepatScreen.verifyStartDateFilterResult(expectedStartDate));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat Sampai Tanggal {string}")
    public void verifyEndDateFilterResultLaporanIzinPulangCepat(String expectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinPulangCepatScreen.verifyEndDateFilterResult(expectedEndDate));
    }

    @When("Saya Menekan Tombol Reset di Laporan Izin Pulang Cepat")
    public void executeResetButtonLaporanIzinPulangCepat() {
        laporanIzinPulangCepatScreen.pressFilterResetButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Nama {string}")
    public void verifyResetSearchResultLaporanIzinPulangCepat(String unexpectedName) {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinPulangCepatScreen.verifySearchResult(unexpectedName));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Departemen {string}")
    public void verifyResetDepartmentResultLaporanIzinPulangCepat(String unexpectedDepartment) {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinPulangCepatScreen.verifyDepartmentFilterResult(unexpectedDepartment));
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Tanggal Mulai {string}")
    public void verifyResetStartDateFilterResultLaporanIzinPulangCepat(String unexpectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinPulangCepatScreen.isStartDateFilled());
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Tanggal Selesai Sampai {string}")
    public void verifyResetEndDateFilterResultLaporanIzinPulangCepat(String unexpectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertFalse(laporanIzinPulangCepatScreen.isEndDateFilled());
    }

    @When("Saya Mengubah Jumlah Tampilan Tabel Laporan Izin Pulang Cepat Menjadi {int}")
    public void changeRowsPerPageLaporanIzinPulangCepat(int rowsPerPage) {
        laporanIzinPulangCepatScreen.changeRowsPerPage(rowsPerPage);
    }

    @Then("Aplikasi Menampilkan {int} Laporan Izin Pulang Cepat Teratas")
    public void verifyRowsPerPageLaporanIzinPulangCepat(int expectedRows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(laporanIzinPulangCepatScreen.getNumberOfTableRows(), expectedRows);
    }

    @When("Saya Berpindah Ke Laporan Izin Pulang Cepat Halaman Selanjutnya")
    public void navigateToNextPageLaporanIzinPulangCepat() {
        laporanIzinPulangCepatScreen.pressNextPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat Halaman Kedua")
    public void verifyCurrentPageNumberIsSecondPageLaporanIzinPulangCepat() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinPulangCepatScreen.isSecondPage());
    }

    @When("Saya Berpindah Ke Laporan Izin Pulang Cepat Halaman Sebelumnya")
    public void navigateToPreviousPageLaporanIzinPulangCepat() {
        laporanIzinPulangCepatScreen.pressPreviousPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat Halaman Pertama")
    public void verifyCurrentPageNumberIsFirstPageLaporanIzinPulangCepat() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinPulangCepatScreen.isFirstPage());
    }

    @When("Saya Berpindah Ke Laporan Izin Pulang Cepat Halaman Terakhir")
    public void navigateToLastPageLaporanIzinPulangCepat() {
        laporanIzinPulangCepatScreen.pressLastPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Izin Pulang Cepat Halaman Terakhir")
    public void verifyCurrentPageNumberIsLastPageLaporanIzinPulangCepat() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinPulangCepatScreen.isLastPage());
    }

    @When("Saya Berpindah Ke Laporan Izin Pulang Cepat Halaman Pertama")
    public void navigateToFirstPageLaporanIzinPulangCepat() {
        SleepHelper.SleepLong();
        laporanIzinPulangCepatScreen.pressFirstPageButton();
    }

    @When("Saya Membuka Laporan Izin Pulang Cepat")
    public void openLaporanIzinPulangCepatLaporanIzinPulangCepat() {
        laporanIzinPulangCepatScreen.open();
    }

    @Then("Aplikasi Menampilkan Semua Laporan Izin Pulang Cepat Teratas")
    public void verifyDataShowedLaporanIzinPulangCepat() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanIzinPulangCepatScreen.isDataShowed());
    }
}
