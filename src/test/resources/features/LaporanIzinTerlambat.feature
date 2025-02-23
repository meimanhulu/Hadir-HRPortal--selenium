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
        And Aplikasi Menampilkan Laporan Izin Terlambat Sampai Tanggal "01/01/2025"

    Scenario: Menghilangkan Parameter-parameter Filter Laporan Izin Terlambat yang Dibuat
        Given Nama Karyawan "Kazama"
        And Saya Mencari Laporan Izin Terlambat
        And Departemen "IT Programmer"
        And Saya Memfilter Departemen Laporan Izin Terlambat
        And Tanggal Mulai "19/11/2024"
        And Tanggal Selesai "23/11/2024"
        And Saya Memfilter Tanggal Laporan Izin Terlambat
        When Saya Menekan Tombol Reset
        Then Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Nama "Kazama"
        And Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Departemen "IT Programmer"
        And Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Tanggal Mulai "19/11/2024"
        And Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Tanggal Selesai Sampai "23/11/2024"

    Scenario: Menampilkan 25 Laporan Izin Terlambat
        When Saya Mengubah Jumlah Tampilan Tabel Laporan Izin Terlambat Menjadi 25
        Then Aplikasi Menampilkan 25 Laporan Izin Terlambat Teratas

    Scenario: Menampilkan Laporan Izin Terlambat Halaman Selanjutnya
        When Saya Berpindah Ke Laporan Izin Terlambat Halaman Selanjutnya
        Then Aplikasi Menampilkan Laporan Izin Terlambat Halaman Kedua