package com.juaracodingsqa20.kelompok3.drivers.utils;

import org.openqa.selenium.WebDriver;

import com.juaracodingsqa20.kelompok3.drivers.DriverSingleton;

public class UrlHelper {
    private static final WebDriver driver = DriverSingleton.getDriver();
    private static final String BASE_URL = "https://magang.dikahadir.com/";
    private static final String LAPORAN_IZIN_TERLAMBAT_URL = BASE_URL + "laporan/izin-terlambat";
    private static final String ADMIN_LOGIN_URL = BASE_URL + "authentication/login";
    private static final String DASHBOARD_URL = BASE_URL + "dashboards/dashboard";
    private static final String LAPORAN_IZIN_PULANG_CEPAT_URL = BASE_URL + "laporan/izin-pulang-cepat";

    private static final String LAPORAN_KEHADIRAN_URL = BASE_URL + "leader/kehadiran";
    private static final String LAPORAN_CUTI_URL = BASE_URL + "laporan/cuti";

    /// laporan Semua
    private static final String LAPORAN_ALL_URL = BASE_URL + "laporan/all";
    // Manajemen Aturan Cuti
    
    private static final String MANAJEMEN_MANAGEMENT_UNIT_LEAVE_URL = BASE_URL + "management/unit-leave";

    public static void goToBaseUrl() {
        driver.get(BASE_URL);
    }

    public static void goToLaporanKehadiranUrl() {
        driver.get(LAPORAN_KEHADIRAN_URL);
    }

    public static void goToLaporanIzinTerlambatUrl() {
        driver.get(LAPORAN_IZIN_TERLAMBAT_URL);
    }

    public static void goToAdminLoginUrl() {
        driver.get(ADMIN_LOGIN_URL);
    }

    public static void goToDashboardUrl() {
        driver.get(DASHBOARD_URL);
    }

    public static void goToLaporanIzinPulangCepatUrl() {
        driver.get(LAPORAN_IZIN_PULANG_CEPAT_URL);
    }

    public static void goToLaporanCutiUrl() {
        driver.get(LAPORAN_CUTI_URL);
    }

    public static void goToLaporanAllUrl() {
        driver.get(LAPORAN_ALL_URL);
    }

    public static void goToManajemenManagementUnitLeaveUrl() {
        driver.get(MANAJEMEN_MANAGEMENT_UNIT_LEAVE_URL);
    }
}
