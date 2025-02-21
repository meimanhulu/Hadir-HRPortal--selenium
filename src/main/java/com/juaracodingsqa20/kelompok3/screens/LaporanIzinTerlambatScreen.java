package com.juaracodingsqa20.kelompok3.screens;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.DriverWaitHelper;
import java.util.Date;
import java.util.Locale;

public class LaporanIzinTerlambatScreen {
    private final WebDriver DRIVER;

    private final By SEARCH_INPUT = By.xpath("//input[@id='search']");
    private final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");
    private final By FILTER_BUTTON = By.xpath(
            "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1k0lhp1']//*[name()='svg']");
    private final By DEPARTMENT_INPUT_FIELD = By.xpath("//*[@id=\"job_departement\"]");
    private final By FIRST_DEPARTMENT_INPUT_CHOICE = By.xpath("//*[@id=\"job_departement-option-0\"]");
    private final By FILTER_SAVE_BUTTON = By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/button[2]");
    private final By FILTER_DATE_BUTTON = By.xpath(
            "/html/body/div[1]/div/div/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[2]/div[1]/div/div/button");
    private final By FILTER_START_YEAR_SELECT = By.xpath(
            "/html/body/div[1]/div/div/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[2]/span/span[3]/select");
    private final By FILTER_START_MONTH_SELECT = By.xpath(
            "/html/body/div[1]/div/div/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[2]/span/span[1]/select");
    private final By FILTER_END_YEAR_SELECT = By.xpath(
            "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[2]/span/span[3]/select");
    private final By FILTER_END_MONTH_SELECT = By.xpath(
            "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[2]/span/span[1]/select");

    public LaporanIzinTerlambatScreen(WebDriver driver) {
        this.DRIVER = driver;
    }

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
        SleepHelper.Sleep();
        int numberOfLine = DRIVER.findElements(By.xpath("//tbody/tr")).size();
        for (int i = 0; i < numberOfLine; i++) {
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

    public void inputDepartment(String department) {
        WebElement filterButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(FILTER_BUTTON));
        filterButtonElement.click();
        WebElement departementInputFieldElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(DEPARTMENT_INPUT_FIELD));
        departementInputFieldElement.sendKeys(department);
        WebElement firstDepartementInputChoiceElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(FIRST_DEPARTMENT_INPUT_CHOICE));
        firstDepartementInputChoiceElement.click();
    }

    public void pressFilterSaveButton() {
        WebElement filterSaveButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(FILTER_SAVE_BUTTON));
        filterSaveButtonElement.click();
    }

    public boolean verifyDepartmentFilterResult(String expectedDepartment) {
        SleepHelper.Sleep();
        int numberOfLine = DRIVER.findElements(By.xpath("//tbody/tr")).size();
        for (int i = 0; i < numberOfLine; i++) {
            By departmentDataFromTable = By.xpath("//tbody/tr[" + (i + 1) + "]/td[4]/h6[1]");
            WebElement departmentDataFromTableElement = DriverWaitHelper.DRIVER_WAIT
                    .until(ExpectedConditions.elementToBeClickable(departmentDataFromTable));
            boolean isValid = departmentDataFromTableElement.getText().equals(expectedDepartment);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }

    public void inputFilterStartDate(String startDate) {
        String[] startDateArray = startDate.split("/");
        SleepHelper.Sleep();
        WebElement filterStartDateButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(FILTER_DATE_BUTTON));
        filterStartDateButtonElement.click();
        SleepHelper.Sleep();
        WebElement filterStartYearSelectElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(FILTER_START_YEAR_SELECT));
        filterStartYearSelectElement.click();
        SleepHelper.Sleep();
        By filterStartYearSelectOption = By.xpath(
                "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[2]/span/span[3]/select/option[@value='"
                        + startDateArray[2] + "']");
        WebElement filterStartYearOptionElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(filterStartYearSelectOption));
        filterStartYearOptionElement.click();
        SleepHelper.Sleep();
        WebElement filterStartMonthSelectElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(FILTER_START_MONTH_SELECT));
        filterStartMonthSelectElement.click();
        SleepHelper.Sleep();
        By filterStartMonthSelectOption = By.xpath(
                "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[2]/span/span[1]/select/option[@value='"
                        + (Integer.parseInt(startDateArray[0]) - 1) + "']");
        WebElement filterStartMonthOptionElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(filterStartMonthSelectOption));
        filterStartMonthOptionElement.click();
        SleepHelper.Sleep();
        By filterStartDay = By.xpath(
                "//button/span/span[contains(.,'"
                        + Integer.parseInt(startDateArray[0]) + "')]");
        WebElement filterStartDayElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(filterStartDay));
        filterStartDayElement.click();
    }

    public void inputFilterEndDate(String endDate) {
        String[] endDateArray = endDate.split("/");
        SleepHelper.Sleep();
        WebElement filterEndDateButtonElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(FILTER_DATE_BUTTON));
        filterEndDateButtonElement.click();
        SleepHelper.Sleep();
        WebElement filterEndYearSelectElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(FILTER_END_YEAR_SELECT));
        filterEndYearSelectElement.click();
        SleepHelper.Sleep();
        By filterEndYearSelectOption = By.xpath(
                "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[2]/span/span[3]/select/option[@value='"
                        + endDateArray[2] + "']");
        WebElement filterEndYearOptionElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(filterEndYearSelectOption));
        filterEndYearOptionElement.click();
        SleepHelper.Sleep();
        WebElement filterEndMonthSelectElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(FILTER_END_MONTH_SELECT));
        filterEndMonthSelectElement.click();
        SleepHelper.Sleep();
        By filterEndMonthSelectOption = By.xpath(
                "/html/body/div[1]/div/div/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[2]/span/span[1]/select/option[@value='"
                        + (Integer.parseInt(endDateArray[0]) - 1) + "']");
        WebElement filterEndMonthOptionElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(filterEndMonthSelectOption));
        filterEndMonthOptionElement.click();
        SleepHelper.Sleep();
        By filterEndDay = By.xpath(
                "//button/span/span[contains(.,'"
                        + Integer.parseInt(endDateArray[0]) + "')]");
        WebElement filterEndDayElement = DriverWaitHelper.DRIVER_WAIT
                .until(ExpectedConditions.elementToBeClickable(filterEndDay));
        filterEndDayElement.click();
    }

    public boolean verifyStartDateFilterResult(String expectedStartDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date expectedStartDateParsed = sdf.parse(expectedStartDate);
        SleepHelper.Sleep();
        int numberOfLine = DRIVER.findElements(By.xpath("//tbody/tr")).size();
        for (int i = 0; i < numberOfLine; i++) {
            By dateDataFromTable = By.xpath("//tbody/tr[" + (i + 1) + "]/td[5]/h6[1]");
            WebElement dateDataFromTableElement = DriverWaitHelper.DRIVER_WAIT
                    .until(ExpectedConditions.elementToBeClickable(dateDataFromTable));
            sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("id", "ID"));
            Date dateDataFromTableParsed = sdf.parse(dateDataFromTableElement.getText());
            boolean isValid = expectedStartDateParsed.after(dateDataFromTableParsed)
                    || expectedStartDateParsed.equals(expectedStartDateParsed);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyEndDateFilterResult(String expectedEndDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date expectedEndDateParsed = sdf.parse(expectedEndDate);
        SleepHelper.Sleep();
        int numberOfLine = DRIVER.findElements(By.xpath("//tbody/tr")).size();
        for (int i = 0; i < numberOfLine; i++) {
            By dateDataFromTable = By.xpath("//tbody/tr[" + (i + 1) + "]/td[5]/h6[1]");
            WebElement dateDataFromTableElement = DriverWaitHelper.DRIVER_WAIT
                    .until(ExpectedConditions.elementToBeClickable(dateDataFromTable));
            sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("id", "ID"));
            Date dateDataFromTableParsed = sdf.parse(dateDataFromTableElement.getText());
            boolean isValid = expectedEndDateParsed.before(dateDataFromTableParsed)
                    || expectedEndDateParsed.equals(expectedEndDateParsed);
            if (!isValid) {
                return false;
            }
        }
        return true;
    }
}
