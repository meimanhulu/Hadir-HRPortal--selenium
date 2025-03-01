package com.juaracodingsqa20.kelompok3.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.juaracodingsqa20.kelompok3.drivers.utils.DriverWaitHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;

public class LaporanAturanCutiScreen {
    private final By SEARCH_INPUT = By.xpath("//input[@name='search']");
    private final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");
    private final By FILTER_RESET_BUTTON = By.xpath("//button[normalize-space()='Reset']");
    private final By ROWS_PER_PAGE_SELECT = By.xpath("//div[@id='mui-6']");
    private final By ROWS_PER_PAGE_OPTION_5 = By.xpath("//ul/li[text()='5']");
    private final By ROWS_PER_PAGE_OPTION_10 = By.xpath("//ul/li[text()='10']");
    private final By ROWS_PER_PAGE_OPTION_25 = By.xpath("//ul/li[text()='25']");
    private final By NEXT_PAGE_BUTTON = By.xpath("//button[@title='Go to next page']//*[name()='svg']");
    private final By DISPLAYED_ROWS = By.xpath("//p[@class='MuiTablePagination-displayedRows css-kim0d']");
    private final By PREVIOUS_PAGE_BUTTON = By.xpath("//button[@title='Go to previous page']//*[name()='svg']");
    private final By LAST_PAGE_BUTTON = By.xpath("//button[@title='Go to last page']//*[name()='svg']");
    private final By FIRST_PAGE_BUTTON = By.xpath("//button[@title='Go to first page']//*[name()='svg']");
    private static final String XPATH_TABLE_ROW_NAME = "//tbody/tr[%d]/td[2]/h6[1]";
    private final By DATA_TABLE_TBODY = By.xpath("//tbody");
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
            // Format XPath dengan indeks baris
            By nameDataFromTable = By.xpath(String.format(XPATH_TABLE_ROW_NAME, i + 1));

            // Tunggu hingga elemen bisa diklik
            WebElement nameDataFromTableElement = DriverWaitHelper.DRIVER_WAIT
                    .until(ExpectedConditions.elementToBeClickable(nameDataFromTable));

            // Periksa apakah teks sesuai dengan yang diharapkan
            boolean isValid = nameDataFromTableElement.getText().toLowerCase()
                    .contains(expectedName.toLowerCase());

            if (!isValid) {
                return false; // Jika ada yang tidak cocok, langsung return false
            }
        }
        return true; // Jika semua cocok, return true
    }

    public void pressFilterResetButton() {
        WebElement filterResetButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(FILTER_RESET_BUTTON));
        filterResetButtonElement.click();
    }

    // verifyAllLaporanAturanCuti()
    public boolean verifyAllLaporanAturanCuti() {
        return getNumberOfTableRows() > 0;
    }

    public void changeRowsPerPage(int rowsPerPage) {
        WebElement rowsPerPageSelectElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(ROWS_PER_PAGE_SELECT));
        rowsPerPageSelectElement.click();
        switch (rowsPerPage) {
            case 5: {
                WebElement rowsPerPageOption5Element = DriverWaitHelper.DRIVER_WAIT
                        .until(ExpectedConditions.elementToBeClickable(ROWS_PER_PAGE_OPTION_5));
                rowsPerPageOption5Element.click();
                break;
            }
            case 10: {
                WebElement rowsPerPageOption10Element = DriverWaitHelper.DRIVER_WAIT
                        .until(ExpectedConditions
                                .elementToBeClickable(ROWS_PER_PAGE_OPTION_10));
                rowsPerPageOption10Element.click();
                break;
            }
            case 25: {
                WebElement rowsPerPageOption25Element = DriverWaitHelper.DRIVER_WAIT
                        .until(ExpectedConditions
                                .elementToBeClickable(ROWS_PER_PAGE_OPTION_25));
                rowsPerPageOption25Element.click();
                break;
            }
            default: {
                WebElement rowsPerPageOption10Element = DriverWaitHelper.DRIVER_WAIT
                        .until(ExpectedConditions
                                .elementToBeClickable(ROWS_PER_PAGE_OPTION_10));
                rowsPerPageOption10Element.click();
                break;
            }
        }
    }

    public int getNumberOfTableRows() {
        WebElement dataTableTBodyElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions
                        .presenceOfElementLocated(DATA_TABLE_TBODY));
        if (dataTableTBodyElement.getText().isEmpty()) {
            return 0;
        }
        List<WebElement> dataTableElements = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(DATA_TABLE));
        return dataTableElements.size();
    }

    public void pressNextPageButton() {
        WebElement nextPageButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions
                        .elementToBeClickable(NEXT_PAGE_BUTTON));
        nextPageButtonElement.click();
    }

    public boolean isSecondPage() {
        WebElement rowsPerPageSelectElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(ROWS_PER_PAGE_SELECT));
        WebElement displayedRowsElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(DISPLAYED_ROWS));
        int rowsPerPage = Integer.parseInt(rowsPerPageSelectElement.getText());
        int rowsFrom = Integer.parseInt(displayedRowsElement.getText().split("-")[0]);
        return rowsPerPage + 1 == rowsFrom;
    }
    

    public void pressPreviousPageButton() {
        SleepHelper.SleepLong();
        WebElement previousPageButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions
                        .elementToBeClickable(PREVIOUS_PAGE_BUTTON));
        previousPageButtonElement.click();
    }

    public boolean isFirstPage() {
        WebElement displayedRowsElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(DISPLAYED_ROWS));
        int rowsFrom = Integer.parseInt(displayedRowsElement.getText().split("-")[0]);
        return rowsFrom == 1;
    }

    public void pressLastPageButton() {
        WebElement lastPageButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions
                        .elementToBeClickable(LAST_PAGE_BUTTON));
        lastPageButtonElement.click();
    }

    public boolean isLastPage() {
        WebElement displayedRowsElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(DISPLAYED_ROWS));
        int rowsTo = Integer.parseInt(displayedRowsElement.getText().split("-")[1].split(" of ")[0]);
        int rowsOf = Integer.parseInt(displayedRowsElement.getText().split(" of ")[1]);
        return rowsTo == rowsOf;
    }

    public void pressFirstPageButton() {
        WebElement firstPageButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions
                        .elementToBeClickable(FIRST_PAGE_BUTTON));
        firstPageButtonElement.click();
    }

    public void open() {
        UrlHelper.goToLaporanAllUrl();
    }

    public boolean isDataShowed() {
        return getNumberOfTableRows() > 0;
    }

}
