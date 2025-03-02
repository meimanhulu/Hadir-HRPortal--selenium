package com.juaracodingsqa20.kelompok3.definitions;

import com.juaracodingsqa20.kelompok3.screens.ManajemenAturanCutiScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.juaracodingsqa20.kelompok3.drivers.utils.DriverWaitHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManajemenAturanCutiDefinition {
    private ManajemenAturanCutiScreen ManajemenAturanCutiScreen;

    @Before
    public void setup() {
        ManajemenAturanCutiScreen = new ManajemenAturanCutiScreen();
        UrlHelper.goToManajemenManagementUnitLeaveUrl();
    }

    @Given("Nama Cuti {string} di Kolom Pencarian Manajemen Aturan Cuti")
    public void setInputNameManajemenAturanCuti(String name) {
        SleepHelper.SleepLong();
        ManajemenAturanCutiScreen.inputName(name);
    }

    @When("Saya menekan tombol Search Manajemen Aturan Cuti")
    public void executeSearchManajemenAturanCuti() {
        ManajemenAturanCutiScreen.pressSearchButton();
    }

    @Then("Sistem Menampilkan Manajemen Aturan Cuti Berdasarkan Nama Cuti {string}")
    public void verifySearchResultManajemenAturanCuti(String expectedName) {
        SleepHelper.SleepLong();
        Assert.assertTrue(ManajemenAturanCutiScreen.verifySearchResult(expectedName));
        
    }

    @When("Saya menekan tombol Riset Filter Manajemen Aturan Cuti")
    public void executeResetFilterManajemenAturanCuti() {
        SleepHelper.SleepLong();
        ManajemenAturanCutiScreen.pressFilterResetButton();
    }

    // Sistem Menampilkan Semua Manajemen Aturan Cuti
    @Then("Sistem Menampilkan Semua Manajemen Aturan Cuti")
    public void verifyAllManajemenAturanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(ManajemenAturanCutiScreen.verifyAllManajemenAturanCuti());
    }

    // Aplikasi Menampilkan "0" Hasil Pencarian Manajemen Aturan Cuti
    @Then("Sistem Menampilkan Hasil {int} Pencarian Manajemen Aturan Cuti")
    public void verifyZeroSearchResultManajemenAturanCuti(int expectedRows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(ManajemenAturanCutiScreen.getNumberOfTableRows(), expectedRows);
    }

    // isNoData
    @Then("Sistem Menampilkan Hasil {string} Nama Pencarian Manajemen Aturan Cuti")
    public void verifyNoDataManajemenAturanCuti(String expectedText) {
        SleepHelper.SleepLong(); // Tunggu elemen muncul
        String actualText = com.juaracodingsqa20.kelompok3.screens.ManajemenAturanCutiScreen.getNoDataText();

        // Validasi teks
        Assert.assertEquals(actualText, expectedText, "Pesan 'Tidak Ada Data' tidak sesuai!");
    }

    // When Saya Mengubah Jumlah Tampilan Tabel Manajemen Aturan Cuti Menjadi 5
    @When("Saya Mengubah Jumlah Tampilan Tabel Manajemen Aturan Cuti Menjadi {int}")
    public void changeRowsPerPageManajemenAturanCuti(int rows) {
        ManajemenAturanCutiScreen.changeRowsPerPage(rows);
    }

    // Then Sistem Menampilkan Jumlah Tampilan Tabel Manajemen Aturan Cuti Menjadi 5
    @Then("Sistem Menampilkan Jumlah Tampilan Tabel Manajemen Aturan Cuti Menjadi {int}")
    public void verifyRowsPerPageManajemenAturanCuti(int rows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(ManajemenAturanCutiScreen.getNumberOfTableRows(), rows);
    }

    // Then Aplikasi Menampilkan 5 Manajemen Aturan Cuti Teratas
    @Then("Aplikasi Menampilkan {int} Manajemen Aturan Cuti Teratas")
    public void verifyTopManajemenAturanCuti(int rows) {
        SleepHelper.SleepLong();
        Assert.assertEquals(ManajemenAturanCutiScreen.getNumberOfTableRows(), rows);
    }

    // Saya Berpindah Ke Manajemen Aturan Cuti Halaman Selanjutnya
    @When("Saya Berpindah Ke Manajemen Aturan Cuti Halaman Selanjutnya")
    public void goToNextPageManajemenAturanCuti() {
        ManajemenAturanCutiScreen.pressNextPageButton();
    }

    // Then Aplikasi Menampilkan Manajemen Aturan Cuti Halaman
    @Then("Aplikasi Menampilkan Manajemen Aturan Cuti Halaman Kedua")
    public void verifyCurrentPageNumberManajemenAturanCuti() {
        SleepHelper.SleepLong();
        SleepHelper.SleepLong();
        Assert.assertTrue(ManajemenAturanCutiScreen.isSecondPage());
        SleepHelper.SleepLong();
    }

    // Saya Berpindah Ke Manajemen Aturan Cuti Halaman Sebelumnya
    @When("Saya Berpindah Ke Manajemen Aturan Cuti Halaman Sebelumnya")
    public void goToPreviousPageManajemenAturanCuti() {
        ManajemenAturanCutiScreen.pressPreviousPageButton();
    }

    // Aplikasi Menampilkan Manajemen Aturan Cuti Halaman Pertama
    @Then("Aplikasi Menampilkan Manajemen Aturan Cuti Halaman Pertama")
    public void verifyFirstPageManajemenAturanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(ManajemenAturanCutiScreen.isFirstPage());
    }

    // Saya Berpindah Ke Manajemen Aturan Cuti Halaman Terakhir
    @When("Saya Berpindah Ke Manajemen Aturan Cuti Halaman Terakhir")
    public void goToLastPageManajemenAturanCuti() {
        ManajemenAturanCutiScreen.pressLastPageButton();
    }

    // Aplikasi Menampilkan Manajemen Aturan Cuti Halaman Terakhir
    @Then("Aplikasi Menampilkan Manajemen Aturan Cuti Halaman Terakhir")
    public void verifyLastPageManajemenAturanCuti() {
        SleepHelper.SleepLong();
        Assert.assertTrue(ManajemenAturanCutiScreen.isLastPage());
        SleepHelper.SleepLong();
    }

    // And Saya Berpindah Ke Manajemen Aturan Cuti Halaman Pertama
    @And("Saya Berpindah Ke Manajemen Aturan Cuti Halaman Pertama")
    public void goToFirstPageManajemenAturanCuti() {
        SleepHelper.SleepLong();
        ManajemenAturanCutiScreen.pressFirstPageButton();
        SleepHelper.SleepLong();
    }

    // Saya Membuka Manajemen Aturan Cuti
    @When("Saya Membuka Manajemen Aturan Cuti")
    public void openManajemenAturanCuti() {
        ManajemenAturanCutiScreen.open();
    }

    // Then Aplikasi Menampilkan Semua Manajemen Aturan Cuti Teratas
    @Then("Aplikasi Menampilkan Semua Manajemen Aturan Cuti Teratas")
    public void verifyDataShowedManajemenAturanCuti() {
        
        Assert.assertTrue(ManajemenAturanCutiScreen.isDataShowed());
        
    }

    // Given Saya Mencari Cuti Dengan Nama "Test Bug Cuti Maksimal"
    @Given("Saya Mencari Cuti Dengan Nama {string}")
    public void searchCuti(String name) {
        SleepHelper.SleepLong();
        ManajemenAturanCutiScreen.inputName(name);
        // click search button
        ManajemenAturanCutiScreen.pressSearchButton();
    }

    // When Saya Menekan Tombol Seting Cuti
    @When("Saya Menekan Tombol Seting Cuti")
    public void clickSettingCuti() {
        ManajemenAturanCutiScreen.clickSetingButton();
    }

    // Saya Menghapus Cuti
    @And("Saya Menghapus Cuti")
    public void deleteCuti() {
        ManajemenAturanCutiScreen.clickDeleteButton();
    }

    // And Saya Menekan Tombol Edit
    @And("Saya Menekan Tombol Edit")
    public void clickEditCuti() {
        ManajemenAturanCutiScreen.clickEditButton();
    }
    //clickViewButton
    @And("Saya Menekan Tombol Lihat")
    public void clickViewCuti() {
        ManajemenAturanCutiScreen.clickViewButton();
    }

    // Saya Mengubah Nama Cuti
    @And("Saya Mengubah Nama Cuti {string}")
    public void editCutiName(String name) {
        // ManajemenAturanCutiScreen.inputCutiName(name); dihapus isi sebelumnya
        ManajemenAturanCutiScreen.editCutiName(name);

    }
    //Saya Menghapus Nama
    @And("Saya Menghapus Nama")
    public void deleteCutiName() {
        ManajemenAturanCutiScreen.deleteCutiName();
    }
    //Saya Melihat Notifikasi Gagal Edit "Nama aturan cuti harus diisi!"
    @Then("Saya Melihat Notifikasi Gagal Edit {string}")
    public void verifyEditCutiFailed(String expectedMessage) {
        String actualMessage = ManajemenAturanCutiScreen.getErrorMessageEdit();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    // And Saya Menekan Tombol Konfirmasi Hapus Cuti
    @And("Saya Menekan Tombol Konfirmasi Hapus Cuti")
    public void confirmDeleteCuti() {
        ManajemenAturanCutiScreen.confirmDelete();
    }

    // Then Cuti Berhasil Dihapus
    @Then("Cuti Berhasil Dihapus")
    public void verifyDeleteCuti() {
        Assert.assertTrue(ManajemenAturanCutiScreen.isSuccessMessageDisplayed());
    }

    // Given Saya Menekan Tombol Tambah Cuti
    // And Saya Mengisi Nama Cuti "Test Cuti Baru"
    // And Saya Mengisi Jumlah Cuti "10"
    // And Saya Menekan Tombol Simpan Cuti
    // Then Saya Melihat Notifikasi "Data Berhasil Disimpan"
    @Given("Saya Menekan Tombol Tambah Cuti")
    public void clickAddCuti() {
        SleepHelper.SleepLong();
        ManajemenAturanCutiScreen.clickAddButton();
    }

    @And("Saya Mengisi Nama Cuti {string}")
    public void inputCutiName(String name) {
        ManajemenAturanCutiScreen.inputCutiName(name);
    }

    // inputEligibleLeaveTotalMonth
    @And("Saya Mengisi Jumlah Cuti {string}")
    public void inputEligibleLeaveTotalMonth(String total) {
        ManajemenAturanCutiScreen.inputEligibleLeaveTotalMonth(total);
    }

    @And("Saya Menekan Tombol Simpan Cuti")
    public void clickSaveCuti() {
        ManajemenAturanCutiScreen.BUTTON_TAMBAHKAN();
    }
    //BUTTON_SIMPAN
    //Saya Menekan Tombol Edit Simpan Cuti
    @And("Saya Menekan Tombol Edit Simpan Cuti")
    public void clickEditSaveCuti() {
        ManajemenAturanCutiScreen.BUTTON_SIMPAN();
    }

    @And("Saya Mengisi Tanggal Cuti Dengan Tanggal {string}")
    public void isiTanggalCuti(String tanggalCuti) {
        ManajemenAturanCutiScreen.isiTanggalCuti(tanggalCuti);
    }

    // inputCarryForwardTotalMonth
    @And("Saya Mengisi Jumlah Bulan Kerja Sisa Cuti {string}")
    public void inputCarryForwardTotalMonth(String total) {
        ManajemenAturanCutiScreen.inputCarryForwardTotalMonth(total);
    }

    // inputEligibleLeaveTotalMonth Maksimal Sisa Cuti
    @And("Saya Mengisi Maksimal Sisa Cuti {string}")
    public void inputMaksimalSisaCuti(String total) {
        ManajemenAturanCutiScreen.inputMaxCarryForward(total);
    }

    @Then("Saya Melihat Notifikasi Gagal {string}")
    public void sayaMelihatNotifikasiGagal(String expectedMessage) {
        String actualMessage = ManajemenAturanCutiScreen.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    // clickButtonDate
    @And("Saya Menekan Tombol Tanggal")
    public void clickButtonDate() {
        ManajemenAturanCutiScreen.clickButtonDate();
    }

    @Then("Saya Melihat Notifikasi {string}")
    public void verifySuccessMessage(String message) {
        Assert.assertTrue(ManajemenAturanCutiScreen.isSuccessMessageDisplayed());
    }

    @Then("Saya Melihat Notifikasi Sukses Ini Berarti Gagal {string}")
    public void verifyPopupMessage(String expectedMessage) {
        String actualMessage = ManajemenAturanCutiScreen.getPopupMessage();

        if (actualMessage.contains("Sukses")) {
            Assert.fail("Seharusnya gagal, tetapi malah muncul notifikasi sukses: " + actualMessage);
        } else {
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }

    @Then("Pembuatan Data Aturan Cuti Gagal")
    public void verifyPopupMessage() {
        Assert.assertFalse(ManajemenAturanCutiScreen.isPembuatanAturanCutiSukes());
    }
    //Saya Melihat Rincian Data Cuti
    @Then("Saya Melihat Rincian Data Cuti")
    public void verifyDetailCuti() {
        Assert.assertTrue(ManajemenAturanCutiScreen.isDetailCutiShowed());
    }

}
