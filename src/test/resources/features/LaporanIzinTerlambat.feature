@LaporanIzinTerlambat
Feature: Laporan Izin Terlambat

  Scenario: Mencari Laporan Izin Terlambat Berdasarkan Nama Karyawan Kazama
    Given Nama Karyawan "Kazama" di Kolom Pencarian Laporan Izin Terlambat
    When Saya Mencari Laporan Izin Terlambat
    Then Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Nama "Kazama"

  Scenario: Mencari Laporan Izin Terlambat Berdasarkan Nama Karyawan abcxyz
    Given Nama Karyawan "abcxyz" di Kolom Pencarian Laporan Izin Terlambat
    When Saya Mencari Laporan Izin Terlambat
    Then Aplikasi Menampilkan 0 Laporan Izin Terlambat Teratas

  Scenario: Menampilkan Laporan Izin Terlambat Departemen APP Luar Kota
    Given Departemen "APP Luar Kota" di Kolom Filter Departemen Laporan Izin Terlambat
    When Saya Memfilter Departemen Laporan Izin Terlambat
    Then Aplikasi Menampilkan Laporan Izin Terlambat Sesuai Departemen "APP Luar Kota"

  Scenario: Menampilkan Laporan Izin Terlambat dari Tanggal 10/08/2024 sampai 01/01/2025
    Given Tanggal Mulai "10/08/2024" di Kolom Filter Tanggal Laporan Izin Terlambat
    And Tanggal Selesai "01/01/2025" di Kolom Filter Tanggal Laporan Izin Terlambat
    When Saya Memfilter Tanggal Laporan Izin Terlambat
    Then Aplikasi Menampilkan Laporan Izin Terlambat dari Tanggal "10/08/2024"
    And Aplikasi Menampilkan Laporan Izin Terlambat Sampai Tanggal "01/01/2025"

  Scenario: Menghilangkan Parameter-parameter Filter Laporan Izin Terlambat yang Dibuat
    Given Nama Karyawan "juned" di Kolom Pencarian Laporan Izin Terlambat
    And Saya Mencari Laporan Izin Terlambat
    And Departemen "Brodo" di Kolom Filter Departemen Laporan Izin Terlambat
    And Saya Memfilter Departemen Laporan Izin Terlambat
    And Tanggal Mulai "24/02/2025" di Kolom Filter Tanggal Laporan Izin Terlambat
    And Tanggal Selesai "25/02/2025" di Kolom Filter Tanggal Laporan Izin Terlambat
    And Saya Memfilter Tanggal Laporan Izin Terlambat
    When Saya Menekan Tombol Reset di Laporan Izin Terlambat
    Then Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Nama "juned"
    And Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Departemen "Brodo"
    And Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Tanggal Mulai "24/02/2025"
    And Aplikasi Menampilkan Laporan Izin Terlambat Tidak Berdasarkan Tanggal Selesai Sampai "25/02/2025"

  Scenario: Menampilkan 25 Laporan Izin Terlambat
    When Saya Mengubah Jumlah Tampilan Tabel Laporan Izin Terlambat Menjadi 25
    Then Aplikasi Menampilkan 25 Laporan Izin Terlambat Teratas

  Scenario: Menampilkan 10 Laporan Izin Terlambat
    When Saya Mengubah Jumlah Tampilan Tabel Laporan Izin Terlambat Menjadi 10
    Then Aplikasi Menampilkan 10 Laporan Izin Terlambat Teratas

  Scenario: Menampilkan 5 Laporan Izin Terlambat
    When Saya Mengubah Jumlah Tampilan Tabel Laporan Izin Terlambat Menjadi 5
    Then Aplikasi Menampilkan 5 Laporan Izin Terlambat Teratas

  Scenario: Menampilkan Laporan Izin Terlambat Halaman Selanjutnya
    When Saya Berpindah Ke Laporan Izin Terlambat Halaman Selanjutnya
    Then Aplikasi Menampilkan Laporan Izin Terlambat Halaman Kedua

  Scenario: Menampilkan Laporan Izin Terlambat Halaman Sebelumnya
    When Saya Berpindah Ke Laporan Izin Terlambat Halaman Selanjutnya
    And Saya Berpindah Ke Laporan Izin Terlambat Halaman Sebelumnya
    Then Aplikasi Menampilkan Laporan Izin Terlambat Halaman Pertama

  Scenario: Menampilkan Laporan Izin Terlambat Halaman Terakhir
    When Saya Berpindah Ke Laporan Izin Terlambat Halaman Terakhir
    Then Aplikasi Menampilkan Laporan Izin Terlambat Halaman Terakhir

  Scenario: Menampilkan Laporan Izin Terlambat Halaman Pertama
    When Saya Berpindah Ke Laporan Izin Terlambat Halaman Selanjutnya
    And Saya Berpindah Ke Laporan Izin Terlambat Halaman Pertama
    Then Aplikasi Menampilkan Laporan Izin Terlambat Halaman Pertama

  Scenario: Menampilkan Semua Laporan Izin Terlambat Teratas
    When Saya Membuka Laporan Izin Terlambat
    Then Aplikasi Menampilkan Semua Laporan Izin Terlambat Teratas