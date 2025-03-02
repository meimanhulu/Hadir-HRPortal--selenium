package com.juaracodingsqa20.kelompok3.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juaracodingsqa20.kelompok3.drivers.DriverSingleton;
import com.juaracodingsqa20.kelompok3.drivers.utils.DriverWaitHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.UrlHelper;

public class ManajemenAturanCutiScreen {
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
    private final By LAST_PAGE_BUTTON = By.xpath("//button[@aria-label='Go to last page']");
    private final By FIRST_PAGE_BUTTON = By.xpath("//button[@title='Go to first page']//*[name()='svg']");
    private static final String XPATH_TABLE_ROW_NAME = "//tbody/tr[%d]/td[1]/p";
    private final By DATA_TABLE_TBODY = By.xpath("//tbody");
    private final By DATA_TABLE = By.xpath("//tbody/tr");
    //// button[normalize-space()='Tambahkan Aturan Cuti']
    private final By ADD_BUTTON = By.xpath("//button[normalize-space()='Tambahkan Aturan Cuti']");
    // Inputan //*[@id="name"]
    private final By INPUT_NAME_CUTI = By.xpath("//*[@id='name']");
    // button tanggal cuti //button[.//svg[@data-testid="CalendarIcon"]]

    private final By BUTTON_TANGGAL_CUTI = By.xpath("//button[@aria-label='Choose date, selected date is 1 Jan 2025']");
    //// button[contains(@aria-label, 'Choose date')]

    //// button[text()='1']
    private final By BUTTON_DATE = By.xpath("//button[text()='1']");
    private final By BUTTON_CHOOSE_DATE = By.xpath("//button[contains(@aria-label, 'Choose date')]");
    //// input[@id="max_carry_forward"]
    private final By INPUT_MAX_CARRY_FORWARD = By.xpath("//*[@id='max_carry_forward']");
    //// input[@id="carry_forward_total_month"]
    private final By INPUT_CARRY_FORWARD_TOTAL_MONTH = By.xpath("//*[@id='carry_forward_total_month']");

    //// *[@id="eligible_leave_total_month"]
    private final By INPUT_ELIGIBLE_LEAVE_TOTAL_MONTH = By.xpath("//*[@id='eligible_leave_total_month']");
    //// button[text()="Tambahkan"]
    private final By BUTTON_TAMBAHKAN = By.xpath("//button[text()='Tambahkan']");
    ////button[text()='Simpan']
    private final By BUTTON_SIMPAN = By.xpath("//button[text()='Simpan']");
    //// b[normalize-space()='Tidak Ada Data']
    private final static By NO_DATA = By
            .xpath("//td[contains(@class, 'MuiTableCell-body')]//b[contains(text(),'Tidak Ada Data')]");
    private final By SETING = By.xpath("//table/tbody/tr[1]/td[8]//button[contains(@aria-label, 'action')]");

    private final By DELETE_BUTTON = By.xpath("(//li[contains(@class, 'MuiMenuItem-root')])[3]\r\n");

    private final By CONFIRM_DELETE = By.xpath("//button[normalize-space()='Hapus']\r\n");
    private final By SUCCESS_POPUP = By.xpath("//div[@class='MuiSnackbarContent-message css-1w0ym84']");

    public void inputName(String name) {
        WebElement searchInputElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        searchInputElement.sendKeys(name);
    }

    public void pressSearchButton() {
        WebElement searchButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON));
        searchButtonElement.click();
        SleepHelper.SleepLong();

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

    // verifyAllManajemenAturanCuti()
    public boolean verifyAllManajemenAturanCuti() {
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
        SleepHelper.SleepLong();
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
        UrlHelper.goToManajemenManagementUnitLeaveUrl();
    }

    public boolean isDataShowed() {
        return getNumberOfTableRows() > 0;
    }

    public boolean isNoData() {
        WebElement noDataElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(NO_DATA));
        return noDataElement.isDisplayed();
    }

    public static String getNoDataText() {
        WebElement noDataElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.visibilityOfElementLocated(NO_DATA));
        return noDataElement.getText();
    }

    public void clickSetingButton() {
        WebDriver driver = DriverSingleton.getDriver(); // Ambil WebDriver dari singleton
        WebElement setingButton = DriverWaitHelper.DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(SETING));

        Actions actions = new Actions(driver);
        actions.moveToElement(setingButton).click().perform();
    }

    public void clickDeleteButton() {
        WebDriver driver = DriverSingleton.getDriver(); // Ambil WebDriver dari singleton
        WebElement deleteButton = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.presenceOfElementLocated(DELETE_BUTTON));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", deleteButton);
    }
    public void clickEditButton() {
        WebDriver driver = DriverSingleton.getDriver(); // Ambil WebDriver dari singleton
        WebElement editButton = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class, 'MuiMenuItem-root') and contains(text(), 'Edit')]")));
    
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", editButton);
    }
    //clickViewButton
    public void clickViewButton() {
        WebDriver driver = DriverSingleton.getDriver(); // Ambil WebDriver dari singleton
        WebElement viewButton = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class, 'MuiMenuItem-root') and contains(text(), 'View')]")));
    
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", viewButton);
    }
    

    public void confirmDelete() {
        WebElement confirmDelete = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.visibilityOfElementLocated(CONFIRM_DELETE));
        confirmDelete.click();
    }

    public boolean isSuccessMessageDisplayed() {
        WebElement successMessage = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_POPUP));
        return successMessage.isDisplayed();
    }

    public void clickAddButton() {
        WebElement addButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(ADD_BUTTON));
        addButtonElement.click();
    }

    // INPUT_NAME_CUTI
    public void inputCutiName(String name) {
        WebElement nameElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(INPUT_NAME_CUTI));
        nameElement.sendKeys(name);
    }
    //editCutiName
    public void editCutiName(String name) {
        WebElement nameElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(INPUT_NAME_CUTI));
//hapus nama lama sendKeys(Keys.BACKSPACE)
        nameElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        nameElement.sendKeys(name);
    
    }
    public void editCutiNameNegatif(String name) {
        WebElement nameElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(INPUT_NAME_CUTI));
//hapus nama lama sendKeys(Keys.BACKSPACE)
        nameElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        nameElement.sendKeys(name);
    
    }
    //deleteCutiName
    public void deleteCutiName() {
        WebElement nameElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(INPUT_NAME_CUTI));
//hapus nama lama sendKeys(Keys.BACKSPACE)
        nameElement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        
    }
    

    public void inputMaxCarryForward(String maxCarryForward) {
        WebElement maxCarryForwardElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(INPUT_MAX_CARRY_FORWARD));
        maxCarryForwardElement.sendKeys(maxCarryForward);
    }

    public void inputCarryForwardTotalMonth(String carryForwardTotalMonth) {
        WebElement carryForwardTotalMonthElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(INPUT_CARRY_FORWARD_TOTAL_MONTH));
        carryForwardTotalMonthElement.sendKeys(carryForwardTotalMonth);
    }

    public void inputEligibleLeaveTotalMonth(String eligibleLeaveTotalMonth) {
        WebElement eligibleLeaveTotalMonthElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(INPUT_ELIGIBLE_LEAVE_TOTAL_MONTH));
        eligibleLeaveTotalMonthElement.sendKeys(eligibleLeaveTotalMonth);
    }
    public String getErrorMessage() {
        WebElement errorElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("name-helper-text"))); // ID dari elemen notifikasi
        return errorElement.getText();
    }
    public String getErrorMessageEdit() {
        WebElement errorElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("name-helper-text"))); // ID elemen yang mengandung pesan error
        return errorElement.getText();
    }
    public String getPopupMessage() {
        WebElement popupElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_POPUP)); // Notifikasi bisa sukses atau error
        return popupElement.getText();
    }
    public boolean isPembuatanAturanCutiSukes() {
        WebElement popupElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_POPUP)); // Notifikasi bisa sukses atau error
        return popupElement.getText().contains("Sukses Membuat Aturan Cuti");
    }
    

    public void isiTanggalCuti(String tanggalCuti) {
        SleepHelper.SleepLong(); // Tunggu sebelum klik untuk menghindari elemen belum siap
    
        // Temukan input tanggal menggunakan XPath
        WebElement inputTanggalCuti = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='tanggal_cuti']")
                ));
    
        // Hapus nilai lama jika ada dan masukkan tanggal baru
        inputTanggalCuti.clear();
        inputTanggalCuti.sendKeys(tanggalCuti);
        inputTanggalCuti.sendKeys(Keys.ENTER); // Pastikan tanggal terinput dengan benar
    }
    
    
    


    // BUTTON_DATE
    public void clickButtonDate() {
        WebElement buttonDateElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(BUTTON_DATE));
        buttonDateElement.click();
    }

    public void clickButtonChooseDate() {
        WebElement buttonChooseDateElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(BUTTON_CHOOSE_DATE));
        buttonChooseDateElement.click();
    }

    public void BUTTON_TAMBAHKAN() {
        WebElement buttonTambahkanElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(BUTTON_TAMBAHKAN));
        buttonTambahkanElement.click();
    }
    //
    public void BUTTON_SIMPAN() {
        WebElement buttonSimpanElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(BUTTON_SIMPAN));
        buttonSimpanElement.click();
    }
    //isDetailCutiShowed menghitung jumlah row
    public boolean isDetailCutiShowed() {
        return getNumberOfTableRows() > 0;
    }

}
