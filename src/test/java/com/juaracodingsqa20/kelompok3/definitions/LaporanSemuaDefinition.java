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




    
}