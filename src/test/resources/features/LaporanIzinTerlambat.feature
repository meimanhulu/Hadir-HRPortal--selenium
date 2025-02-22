Feature: Laporan Izin Terlambat

    Scenario: Mencari Laporan Izin Terlambat Berdasarkan Nama Karyawan "Kazama"
        Given Nama Karyawan "Kazama"
        When Saya Mencari Laporan Izin Terlambat
        Then Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Nama "Kazama"

    Scenario: Menampilkan Laporan Izin Terlambat Departemen "APP Luar Kota"
        Given Departemen "APP Luar Kota"
        When Saya Memfilter Departemen Laporan Izin Terlambat
        Then Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Departemen "APP Luar Kota"

    Scenario: Menampilkan Laporan Izin Terlambat dari Tanggal 10/08/2024 sampai 01/01/2025
        Given Tanggal Mulai "10/08/2024"
        And Tanggal Selesai "01/01/2025"
        When Saya Memfilter Tanggal Laporan Izin Terlambat
        Then Aplikasi Menampilkan Laporan Izin Terlambat dari Tanggal "10/08/2024"
        And Sampai Tanggal "01/01/2025"