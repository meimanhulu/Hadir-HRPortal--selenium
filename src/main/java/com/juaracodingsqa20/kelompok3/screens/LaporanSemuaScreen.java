package com.juaracodingsqa20.kelompok3.screens;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.DriverWaitHelper;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LaporanSemuaScreen {
    private final By SEARCH_INPUT = By.xpath("//input[@id='search']");
    private final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");

    private final By DATA_TABLE = By.xpath("//tbody/tr");

    public void inputName(String name) {
        WebElement searchInputElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        searchInputElement.sendKeys(name);
    }

    public void pressSearchButton() {
        WebElement searchButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON));
        searchButtonElement.click();
    }

    public boolean verifySearchResult(String expectedName) {
        for (int i = 0; i < getNumberOfTableRows(); i++) {
            By nameDataFromTable = By.xpath("//tbody/tr[" + (i + 1) + "]/td[2]/h6[1]");
            WebElement nameDataFromTableElement = DriverWaitHelper.DRIVER_WAIT
                    .until(ExpectedConditions.elementToBeClickable(nameDataFromTable));
            boolean isValid = nameDataFromTableElement.getText().toLowerCase()
                    .contains(expectedName.toLowerCase());
            if (!isValid) {
                return false;
            }
        }
        return true;
    }

    public int getNumberOfTableRows() {
        List<WebElement> dataTableElements = DriverWaitHelper.DRIVER_WAIT
                        .until(ExpectedConditions
                                        .presenceOfAllElementsLocatedBy(DATA_TABLE));
        return dataTableElements.size();
}

}