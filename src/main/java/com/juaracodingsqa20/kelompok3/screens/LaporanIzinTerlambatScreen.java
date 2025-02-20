package com.juaracodingsqa20.kelompok3.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.juaracodingsqa20.kelompok3.drivers.utils.SleepHelper;
import com.juaracodingsqa20.kelompok3.drivers.utils.DriverWaitHelper;

public class LaporanIzinTerlambatScreen {
    private final WebDriver DRIVER;

    private final By SEARCH_INPUT = By.xpath("//input[@id='search']");
    private final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");
    private final By FILTER_BUTTON = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1k0lhp1']//*[name()='svg']");
    private final By DEPARTMENT_INPUT_FIELD = By.xpath("//*[@id=\"job_departement\"]");
    private final By FIRST_DEPARTMENT_INPUT_CHOICE = By.xpath("//*[@id=\"job_departement-option-0\"]");
    private final By FILTER_SAVE_BUTTON = By.xpath("/html/body/div[3]/div[3]/div/form/div[2]/button[2]");

    public LaporanIzinTerlambatScreen(WebDriver driver) {
        this.DRIVER = driver;
    }

    public void inputNama(String name) {
        WebElement searchInputElement = DriverWaitHelper.DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(SEARCH_INPUT));
        searchInputElement.sendKeys(name);
    }

    public void pressSearchButton() {
        WebElement searchButtonElement = DriverWaitHelper.DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON));
        searchButtonElement.click();
    }

    public boolean verifySearchResult(String expectedName) {
        SleepHelper.Sleep();
        int numberOfLine = DRIVER.findElements(By.xpath("//tbody/tr")).size();
        for (int i = 0; i < numberOfLine; i++) {
            By nameDataFromTable = By.xpath("//tbody/tr[" + (i + 1) + "]/td[2]/h6[1]");
            WebElement nameDataFromTableElement = DriverWaitHelper.DRIVER_WAIT
                    .until(ExpectedConditions.elementToBeClickable(nameDataFromTable));
            boolean isNameDataContainsExpectedName = nameDataFromTableElement.getText().toLowerCase()
                    .contains(expectedName.toLowerCase());
            if (!isNameDataContainsExpectedName) {
                return false;
            }
        }
        return true;
    }

    public void inputDepartment(String department) {
        WebElement filterButtonElement = DriverWaitHelper.DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(FILTER_BUTTON));
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
            boolean isDepartmentDataContainsExpectedName = departmentDataFromTableElement.getText().equals(expectedDepartment);
            if (!isDepartmentDataContainsExpectedName) {
                return false;
            }
        }
        return true;
    }
}
