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

public class LaporanIzinTerlambatScreen {
        private final By SEARCH_INPUT = By.xpath("//input[@id='search']");
        private final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");
        private final By FILTER_BUTTON = By.xpath(
                        "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1k0lhp1']//*[name()='svg']");
        private final By DEPARTMENT_INPUT_FIELD = By.xpath("//*[@id=\"job_departement\"]");
        private final By FIRST_DEPARTMENT_INPUT_OPTION = By.xpath("//*[@id=\"job_departement-option-0\"]");
        private final By FILTER_SAVE_BUTTON = By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/button[2]");
        private final By FILTER_DATE_BUTTON = By.xpath(
                        "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-7 MuiGrid-grid-lg-8 css-kw2xn2']//div[1]//div[1]//div[1]//button[1]");
        private final By FILTER_START_YEAR_SELECT = By.xpath(
                        "//span[@class='rdrYearPicker']//select");
        private final By FILTER_START_MONTH_SELECT = By.xpath(
                        "//span[@class='rdrMonthPicker']//select");
        private final By FILTER_END_YEAR_SELECT = By.xpath(
                        "//span[@class='rdrYearPicker']//select");
        private final By FILTER_END_MONTH_SELECT = By.xpath(
                        "//span[@class='rdrYearPicker']//select");
        private final By FILTER_RESET_BUTTON = By.xpath("//button[normalize-space()='Reset']");
        private final By ROWS_PER_PAGE_SELECT = By.xpath("//div[@id='mui-3']");
        private final By ROWS_PER_PAGE_OPTION_5 = By.xpath("//ul/li[text()='5']");
        private final By ROWS_PER_PAGE_OPTION_10 = By.xpath("//ul/li[text()='10']");
        private final By ROWS_PER_PAGE_OPTION_25 = By.xpath("//ul/li[text()='25']");
        private final By DATA_TABLE = By.xpath("//tbody/tr");
        private final By NEXT_PAGE_BUTTON = By.xpath("//button[@title='Go to next page']//*[name()='svg']");
        private final By DISPLAYED_ROWS = By.xpath("//p[@class='MuiTablePagination-displayedRows css-kim0d']");
        private final By PREVIOUS_PAGE_BUTTON = By.xpath("//button[@title='Go to previous page']//*[name()='svg']");
        private final By LAST_PAGE_BUTTON = By.xpath("//button[@title='Go to last page']//*[name()='svg']");
        private final By FIRST_PAGE_BUTTON = By.xpath("//button[@title='Go to first page']//*[name()='svg']");

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

        public void inputDepartment(String department) {
                WebElement filterButtonElement = DriverWaitHelper.DRIVER_WAIT
                                .until(ExpectedConditions.elementToBeClickable(FILTER_BUTTON));
                filterButtonElement.click();
                WebElement departementInputFieldElement = DriverWaitHelper.DRIVER_WAIT
                                .until(ExpectedConditions.elementToBeClickable(DEPARTMENT_INPUT_FIELD));
                departementInputFieldElement.sendKeys(department);
                WebElement firstDepartementInputOptionElement = DriverWaitHelper.DRIVER_WAIT
                                .until(ExpectedConditions.elementToBeClickable(FIRST_DEPARTMENT_INPUT_OPTION));
                firstDepartementInputOptionElement.click();
        }

        public void pressFilterSaveButton() {
                WebElement filterSaveButtonElement = DriverWaitHelper.DRIVER_WAIT
                                .until(ExpectedConditions.elementToBeClickable(FILTER_SAVE_BUTTON));
                filterSaveButtonElement.click();
        }

        public boolean verifyDepartmentFilterResult(String expectedDepartment) {
                for (int i = 0; i < getNumberOfTableRows(); i++) {
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
                                                + (Integer.parseInt(startDateArray[1]) - 1) + "']");
                WebElement filterStartMonthOptionElement = DriverWaitHelper.DRIVER_WAIT
                                .until(ExpectedConditions.elementToBeClickable(filterStartMonthSelectOption));
                filterStartMonthOptionElement.click();
                SleepHelper.Sleep();
                By filterStartDay = By.xpath(
                                "//div[@class='rdrDays']/button/span/span[text()='"
                                                + Integer.parseInt(startDateArray[0]) + "']");
                List<WebElement> filterStartDayElements = DriverWaitHelper.DRIVER_WAIT
                                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(filterStartDay));
                if (filterStartDayElements.size() > 1 && Integer.parseInt(startDateArray[0]) > 15) {
                        filterStartDayElements.get(1).click();
                } else {
                        filterStartDayElements.get(0).click();
                }
        }

        public void inputFilterEndDate(String endDate) {
                String[] endDateArray = endDate.split("/");
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
                                "/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/form/div/div[1]/div[3]/div/div/div[1]/div[2]/span/span[1]/select/option[@value='"
                                                + (Integer.parseInt(endDateArray[1]) - 1) + "']");
                WebElement filterEndMonthOptionElement = DriverWaitHelper.DRIVER_WAIT
                                .until(ExpectedConditions.elementToBeClickable(filterEndMonthSelectOption));
                filterEndMonthOptionElement.click();
                SleepHelper.Sleep();
                By filterEndDay = By.xpath(
                                "//div[@class='rdrDays']/button/span/span[text()='"
                                                + Integer.parseInt(endDateArray[0]) + "']");
                List<WebElement> filterEndDayElements = DriverWaitHelper.DRIVER_WAIT
                                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(filterEndDay));
                if (filterEndDayElements.size() > 1 && Integer.parseInt(endDateArray[0]) > 15) {
                        filterEndDayElements.get(1).click();
                } else {
                        filterEndDayElements.get(0).click();
                }
        }

        public boolean verifyStartDateFilterResult(String expectedStartDate) throws ParseException {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date expectedStartDateParsed = sdf.parse(expectedStartDate);
                for (int i = 0; i < getNumberOfTableRows(); i++) {
                        By dateDataFromTable = By.xpath("//tbody/tr[" + (i + 1) + "]/td[5]/h6[1]");
                        WebElement dateDataFromTableElement = DriverWaitHelper.DRIVER_WAIT
                                        .until(ExpectedConditions.elementToBeClickable(dateDataFromTable));
                        sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("id", "ID"));
                        Date dateDataFromTableParsed = sdf.parse(dateDataFromTableElement.getText());
                        boolean isValid = expectedStartDateParsed.before(dateDataFromTableParsed)
                                        || expectedStartDateParsed.equals(dateDataFromTableParsed);
                        if (!isValid) {
                                return false;
                        }
                }
                return true;
        }

        public boolean verifyEndDateFilterResult(String expectedEndDate) throws ParseException {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date expectedEndDateParsed = sdf.parse(expectedEndDate);
                for (int i = 0; i < getNumberOfTableRows(); i++) {
                        By dateDataFromTable = By.xpath("//tbody/tr[" + (i + 1) + "]/td[5]/h6[1]");
                        WebElement dateDataFromTableElement = DriverWaitHelper.DRIVER_WAIT
                                        .until(ExpectedConditions.elementToBeClickable(dateDataFromTable));
                        sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("id", "ID"));
                        Date dateDataFromTableParsed = sdf.parse(dateDataFromTableElement.getText());
                        boolean isValid = expectedEndDateParsed.after(dateDataFromTableParsed)
                                        || expectedEndDateParsed.equals(dateDataFromTableParsed);
                        if (!isValid) {
                                return false;
                        }
                }
                return true;
        }

        public void pressFilterResetButton() {
                WebElement filterResetButtonElement = DriverWaitHelper.DRIVER_WAIT
                                .until(ExpectedConditions.elementToBeClickable(FILTER_RESET_BUTTON));
                filterResetButtonElement.click();
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
                UrlHelper.goToLaporanIzinTerlambatUrl();
        }

        public boolean isDataShowed() {
                return getNumberOfTableRows() > 0;
        }
}
