package com.juaracodingsqa20.kelompok3.definitions;

import java.text.ParseException;

import org.testng.Assert;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;
import com.juaracodingsqa20.kelompok3.screens.LaporanSemuaScreen;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaporanSemuaDefinition {
    private LaporanSemuaScreen laporanSemuaScreen;
    private String filteredStartDate;
    private String filteredEndDate;

    @Before("@LaporanSemua")
    public void setup() {
        laporanSemuaScreen = new LaporanSemuaScreen();
        UrlHelper.goToLaporanAllUrl();
    }

    @Given("Nama Karyawan {string} di Kolom Pencarian Laporan Semua")
    public void setInputNameLaporanSemua(String name) {
        laporanSemuaScreen.inputName(name);
    }

    @When("Saya menekan tombol Search")
    public void executeSearchLaporanSemua() {
        laporanSemuaScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Semua Sesuai {string}")
    public void verifySearchResultLaporanSemua(String expectedName) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanSemuaScreen.verifySearchResult(expectedName));
    }

    @Given("Tanggal Mulai {string} di Kolom Filter Tanggal Laporan Semua")
    public void setInputFilterStartDateLaporanSemua(String startDate) {
        laporanSemuaScreen.inputFilterStartDate(startDate);
        ;
    }

    @Given("Tanggal Selesai {string} di Kolom Filter Tanggal Laporan Semua")
    public void setInputFilterEndDateLaporanSemua(String endDate) {
        laporanSemuaScreen.inputFilterEndDate(endDate);
    }

    @When("Saya Memfilter Tanggal Laporan Semua")
    public void executeDateFilterLaporanSemua() {
        laporanSemuaScreen.pressSearchButton();
        SleepHelper.SleepLong();
        
    }

    @Then("Aplikasi Menampilkan Laporan Semua dari Tanggal {string}")
    public void verifyStartDateFilterResultLaporanSemua(String expectedStartDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanSemuaScreen.verifyStartDateFilterResult(expectedStartDate));
    }

    @Then("Aplikasi Menampilkan Laporan Semua Sampai Tanggal {string}")
    public void verifyEndDateFilterResultLaporanSemua(String expectedEndDate) throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanSemuaScreen.verifyEndDateFilterResult(expectedEndDate));
    }

    @Given("Saya Memasukkan Rentang Tanggal {string} sampai {string} dan Nama Karyawan {string}")
    public void setFilterCriteria(String startDate, String endDate, String name) {
        laporanSemuaScreen.inputFilterStartDate(startDate);
        laporanSemuaScreen.inputFilterEndDate(endDate);
        laporanSemuaScreen.inputName(name);
    }

    @When("Saya Memfilter dan Menekan Tombol Search")
    public void filterAndSearch() {
        laporanSemuaScreen.pressSearchButton();
    }

    @Then("Aplikasi Menampilkan Laporan Semua Sesuai Nama {string} dalam Rentang Tanggal {string} sampai {string}")
    public void verifyFilteredReport(String expectedName, String expectedStartDate, String expectedEndDate)
            throws ParseException {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanSemuaScreen.verifySearchResult(expectedName));
        Assert.assertEquals(laporanSemuaScreen.verifyStartDateFilterResult(expectedStartDate), true,
                "Tanggal mulai tidak sesuai!");
        Assert.assertEquals(laporanSemuaScreen.verifyEndDateFilterResult(expectedEndDate), true,
                "Tanggal selesai tidak sesuai!");

    }

    @Then("Aplikasi hanya menampilkan Laporan dalam rentang tanggal")
    public void verifyOnlyDateRangeResults() throws ParseException {
        SleepHelper.SleepLong();

        // Menggunakan tanggal yang sebelumnya difilter
        boolean isWithinRange = laporanSemuaScreen.verifyStartDateFilterResult(filteredStartDate) &&
                laporanSemuaScreen.verifyEndDateFilterResult(filteredEndDate);

        Assert.assertTrue(isWithinRange, "Hasil pencarian tidak sesuai dengan rentang tanggal!");
    }

    @When("Saya Menghapus Nama Karyawan")
    public void clearEmployeeName() {
        laporanSemuaScreen.inputName(""); // Menghapus nama dengan metode yang sudah ada
    }

    @Then("Aplikasi Menampilkan Laporan Semua Halaman Terakhir")
    public void verifyCurrentPageNumberIsLastPageLaporanSemua() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanSemuaScreen.isLastPage());
    }

    @Then("Aplikasi Menampilkan {int} Laporan Semua")
    public void verifyRowsPerPageLaporanSemua(int expectedRows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(laporanSemuaScreen.getNumberOfTableRows(), expectedRows);
    }

    @Given("Departemen {string} di Kolom Filter Departemen Laporan Semua")
    public void setInputDepartmentLaporanSemua(String department) {
        laporanSemuaScreen.inputDepartment(department);
    }

    @When("Saya Memfilter Departemen Laporan Semua")
    public void executeDepartmentFilterLaporanSemua() {
        laporanSemuaScreen.pressFilterSaveButton();
    }

    @Then("Aplikasi Menampilkan Laporan Semua Sesuai Departemen {string}")
    public void verifyDepartmentFilterResultLaporanSemua(String expectedDepartment) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanSemuaScreen.verifyDepartmentFilterResult(expectedDepartment));
    }

    @Given("Saya Memasukkan Rentang Tanggal {string} sampai {string}")
    public void inputDateRange(String startDate, String endDate) {
        SleepHelper.SleepLong();
        laporanSemuaScreen.inputFilterStartDate(startDate);
        laporanSemuaScreen.inputFilterEndDate(endDate);
    }

    @Then("Aplikasi Menampilkan Laporan Semua Sesuai Departemen {string} dalam Rentang Tanggal {string} sampai {string}")
    public void verifyFilteredReportByDepartment(String expectedDepartment, String expectedStartDate,
            String expectedEndDate)
            throws ParseException {
        SleepHelper.SleepLong();

        // Verifikasi laporan sesuai dengan departemen yang difilter
        Assert.assertTrue(laporanSemuaScreen.verifyDepartmentFilterResult(expectedDepartment),
                "Departemen tidak sesuai!");

        // Verifikasi rentang tanggal yang difilter
        Assert.assertEquals(laporanSemuaScreen.verifyStartDateFilterResult(expectedStartDate), true,
                "Tanggal mulai tidak sesuai!");
        Assert.assertEquals(laporanSemuaScreen.verifyEndDateFilterResult(expectedEndDate), true,
                "Tanggal selesai tidak sesuai!");
    }

    @When("Saya Menekan Tombol Reset Filter")
    public void pressResetFilterButton() {
        laporanSemuaScreen.pressFilterResetButton();
        SleepHelper.SleepLong(); // Tunggu sebentar untuk memastikan perubahan
    }

    @Then("Aplikasi Tidak Menampilkan Laporan dengan Rentang Tanggal {string} sampai {string} dan Nama {string}")
    public void verifyNoFilteredResults(String expectedStartDate, String expectedEndDate, String expectedName) {
        SleepHelper.SleepLong();

        // Verifikasi bahwa tidak ada laporan dengan rentang tanggal yang sama setelah
        // reset
        Assert.assertFalse(laporanSemuaScreen.isDateRangeDisplayed(expectedStartDate, expectedEndDate),
                "Laporan dengan rentang tanggal yang sama masih muncul setelah reset!");

        // Verifikasi bahwa tidak ada laporan dengan inputan nama yang sama setelah
        // reset
        Assert.assertFalse(laporanSemuaScreen.isNameDisplayed(expectedName),
                "Laporan dengan nama yang sama masih muncul setelah reset!");
    }

    @When("Saya Mengubah Jumlah Tampilan Tabel Laporan Semua Menjadi {int}")
    public void changeRowsPerPageLaporanSemua(int rowsPerPage) {
        laporanSemuaScreen.changeRowsPerPage(rowsPerPage);
    }

    @When("Saya Berpindah Ke Laporan Semua Halaman Selanjutnya")
    public void navigateToNextPageLaporanSemua() {
        laporanSemuaScreen.pressNextPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Semua Halaman Kedua")
    public void verifyCurrentPageNumberIsSecondPageLaporanSemua() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanSemuaScreen.isSecondPage());
    }

    @When("Saya Berpindah Ke Laporan Semua Halaman Sebelumnya")
    public void navigateToPreviousPageLaporanSemua() {
        laporanSemuaScreen.pressPreviousPageButton();
    }

    @Then("Aplikasi Menampilkan Laporan Semua Halaman Pertama")
    public void verifyCurrentPageNumberIsFirstPageLaporanSemua() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanSemuaScreen.isFirstPage());

    }
    @When("Saya Berpindah Ke Laporan Semua Halaman Pertama")
    public void navigateToFirstPageLaporanSemua() {
        SleepHelper.SleepLong();
        laporanSemuaScreen.pressFirstPageButton();
    }
    @When("Saya Berpindah Ke Laporan Semua Halaman Terakhir")
    public void navigateToLastPageLaporanSemua() {
        laporanSemuaScreen.pressLastPageButton();
    }
    @When("Saya Membuka Laporan Semua")
    public void openLaporanSemuaLaporanSemua() {
        laporanSemuaScreen.open();
    }

    @Then("Aplikasi Menampilkan Semua Laporan Semua Teratas")
    public void verifyDataShowedLaporanSemua() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanSemuaScreen.isDataShowed());
    }

}