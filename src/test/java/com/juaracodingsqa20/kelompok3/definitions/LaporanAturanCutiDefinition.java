package com.juaracodingsqa20.kelompok3.definitions;
import com.juaracodingsqa20.kelompok3.screens.LaporanAturanCutiScreen;

import org.testng.Assert;

import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LaporanAturanCutiDefinition {
    private LaporanAturanCutiScreen laporanAturanCutiScreen;
    @Before
    public void setup() {
        laporanAturanCutiScreen = new LaporanAturanCutiScreen();
        UrlHelper.goToManajemenManagementUnitLeaveUrl();
    }

    @Given("Nama Cuti {string} di Kolom Pencarian Laporan Aturan Cuti")
    public void setInputNameLaporanAturanCuti(String name) {
        laporanAturanCutiScreen.inputName(name);
    }

    @When("Saya menekan tombol Search Laporan Aturan Cuti")
    public void executeSearchLaporanAturanCuti() {
        laporanAturanCutiScreen.pressSearchButton();
    }

    @Then("Sistem Menampilkan Laporan Aturan Cuti Berdasarkan Nama Cuti {string}")
    public void verifySearchResultLaporanAturanCuti(String expectedName) {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanAturanCutiScreen.verifySearchResult(expectedName));
    }

    @When("Saya menekan tombol Riset Filter Laporan Aturan Cuti")
    public void executeResetFilterLaporanAturanCuti() {
        SleepHelper.SleepLong();
        laporanAturanCutiScreen.pressFilterResetButton();
    }

    //Sistem Menampilkan Semua Laporan Aturan Cuti
    @Then("Sistem Menampilkan Semua Laporan Aturan Cuti")
    public void verifyAllLaporanAturanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanAturanCutiScreen.verifyAllLaporanAturanCuti());
    }

    //Aplikasi Menampilkan "0" Hasil Pencarian Laporan Aturan Cuti
    @Then("Sistem Menampilkan Hasil {int} Pencarian Laporan Aturan Cuti")
    public void verifyZeroSearchResultLaporanAturanCuti(int expectedRows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(laporanAturanCutiScreen.getNumberOfTableRows(), expectedRows);
    }
    //When Saya Mengubah Jumlah Tampilan Tabel Laporan Aturan Cuti Menjadi 5
    @When("Saya Mengubah Jumlah Tampilan Tabel Laporan Aturan Cuti Menjadi {int}")
    public void changeRowsPerPageLaporanAturanCuti(int rows) {
        laporanAturanCutiScreen.changeRowsPerPage(rows);
    }

    //Then Sistem Menampilkan Jumlah Tampilan Tabel Laporan Aturan Cuti Menjadi 5
    @Then("Sistem Menampilkan Jumlah Tampilan Tabel Laporan Aturan Cuti Menjadi {int}")
    public void verifyRowsPerPageLaporanAturanCuti(int rows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(laporanAturanCutiScreen.getNumberOfTableRows(), rows);
    }
    //Then Aplikasi Menampilkan 5 Laporan Aturan Cuti Teratas
    @Then("Aplikasi Menampilkan {int} Laporan Aturan Cuti Teratas")
    public void verifyTopLaporanAturanCuti(int rows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(laporanAturanCutiScreen.getNumberOfTableRows(), rows);
    }
    //Saya Berpindah Ke Laporan Aturan Cuti Halaman Selanjutnya
    @When("Saya Berpindah Ke Laporan Aturan Cuti Halaman Selanjutnya")
    public void goToNextPageLaporanAturanCuti() {
        laporanAturanCutiScreen.pressNextPageButton();
    }
    //Then Aplikasi Menampilkan Laporan Aturan Cuti Halaman
    @Then("Aplikasi Menampilkan Laporan Aturan Cuti Halaman Kedua")
    public void verifyCurrentPageNumberLaporanAturanCuti() {
        SleepHelper.SleepLong();
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanAturanCutiScreen.isSecondPage());
        SleepHelper.SleepLong();
    }
    //Saya Berpindah Ke Laporan Aturan Cuti Halaman Sebelumnya
    @When("Saya Berpindah Ke Laporan Aturan Cuti Halaman Sebelumnya")
    public void goToPreviousPageLaporanAturanCuti() {
        laporanAturanCutiScreen.pressPreviousPageButton();
    }
    //Aplikasi Menampilkan Laporan Aturan Cuti Halaman Pertama
    @Then("Aplikasi Menampilkan Laporan Aturan Cuti Halaman Pertama")
    public void verifyFirstPageLaporanAturanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanAturanCutiScreen.isFirstPage());
    }
    //Saya Berpindah Ke Laporan Aturan Cuti Halaman Terakhir
    @When("Saya Berpindah Ke Laporan Aturan Cuti Halaman Terakhir")
    public void goToLastPageLaporanAturanCuti() {
        laporanAturanCutiScreen.pressLastPageButton();
    }
    //Aplikasi Menampilkan Laporan Aturan Cuti Halaman Terakhir
    @Then("Aplikasi Menampilkan Laporan Aturan Cuti Halaman Terakhir")
    public void verifyLastPageLaporanAturanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanAturanCutiScreen.isLastPage());
        SleepHelper.SleepLong();
    }
    //And Saya Berpindah Ke Laporan Aturan Cuti Halaman Pertama
    @And("Saya Berpindah Ke Laporan Aturan Cuti Halaman Pertama")
    public void goToFirstPageLaporanAturanCuti() {
        SleepHelper.SleepLong();
        laporanAturanCutiScreen.pressFirstPageButton();
        SleepHelper.SleepLong();
    }
    //Saya Membuka Laporan Aturan Cuti
    @When("Saya Membuka Laporan Aturan Cuti")
    public void openLaporanAturanCuti() {
        laporanAturanCutiScreen.open();
    }
    //Then Aplikasi Menampilkan Semua Laporan Aturan Cuti Teratas
    @Then("Aplikasi Menampilkan Semua Laporan Aturan Cuti Teratas")
    public void verifyDataShowedLaporanAturanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(laporanAturanCutiScreen.isDataShowed());
    }

    




    
}
