Feature: Laporan Izin Terlambat.

    Scenario: Mencari Laporan Izin Terlambat Berdasarkan Nama Karyawan "Kazama".
        Given Nama Karyawan "Kazama".
        When Saya Mencari Laporan Izin Terlambat.
        Then Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Nama "Kazama".

    Scenario: Menampilkan Laporan Izin Terlambat Departemen "APP Luar Kota".
        Given Departemen "APP Luar Kota".
        When Saya Memfilter Departemen Laporan Izin Terlambat.
        Then Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Departemen "APP Luar Kota".