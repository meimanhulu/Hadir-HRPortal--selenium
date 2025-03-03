@LaporanSemua
Feature: Laporan Semua
Scenario: Menampilkan Laporan Semua Departemen Security
    Given Departemen "Security" di Kolom Filter Departemen Negatif Laporan Semua
    When Saya Memfilter Departemen Laporan Semua
    Then Aplikasi Menampilkan 0 Laporan Semua
Scenario: Mencari Laporan Berdasarkan Rentang Tanggal dan Nama Karyawan "Momo"
    Given Saya Memasukkan Rentang Tanggal "18/01/2025" sampai "01/03/2025" dan Nama Karyawan "Momo"
    When Saya Memfilter dan Menekan Tombol Search
    Then Aplikasi Menampilkan Laporan Semua Sesuai Nama "Momo" dalam Rentang Tanggal "18/01/2025" sampai "01/03/2025"
  Scenario: Mencari Laporan Berdasarkan Nama Karyawan "Momo"
    Given Nama Karyawan "Momo" di Kolom Pencarian Laporan Semua
    When Saya menekan tombol Search
    Then Aplikasi Menampilkan Laporan Semua Sesuai "Momo"
  Scenario: Mencari Laporan Berdasarkan Nama Karyawan "abcxyz"
    Given Nama Karyawan "abcxyz" di Kolom Pencarian Laporan Semua
    When Saya menekan tombol Search
    Then Aplikasi Menampilkan 0 Laporan Semua
  Scenario: Menampilkan Laporan Semua dari Tanggal 18/02/2025 sampai 01/03/2025
    Given Tanggal Mulai "18/02/2025" di Kolom Filter Tanggal Laporan Semua
    And Tanggal Selesai "01/03/2025" di Kolom Filter Tanggal Laporan Semua
    When Saya Memfilter Tanggal Laporan Semua
    Then Aplikasi Menampilkan Laporan Semua dari Tanggal "18/02/2025"
    And Aplikasi Menampilkan Laporan Semua Sampai Tanggal "01/03/2025"
Scenario: Menampilkan Laporan Semua Departemen Sysmex
    Given Departemen "Sysmex" di Kolom Filter Departemen Laporan Semua
    When Saya Memfilter Departemen Laporan Semua
    Then Aplikasi Menampilkan Laporan Semua Sesuai Departemen "Sysmex"


Scenario: Mencari Laporan Berdasarkan Rentang Tanggal dan Nama Karyawan "Momo", lalu Menghapus Nama
  Given Saya Memasukkan Rentang Tanggal "18/01/2025" sampai "01/03/2025" dan Nama Karyawan "Momo"
  When Saya Memfilter dan Menekan Tombol Search
  Then Aplikasi Menampilkan Laporan Semua Sesuai Nama "Momo" dalam Rentang Tanggal "18/01/2025" sampai "01/03/2025"
  When Saya Menghapus Nama Karyawan
  And Saya Memfilter dan Menekan Tombol Search
  Then Aplikasi hanya menampilkan Laporan dalam rentang tanggal
Scenario: Menampilkan Laporan Semua Departemen Sysmex
    Given Departemen "Sysmex" di Kolom Filter Departemen Laporan Semua
    When Saya Memfilter Departemen Laporan Semua
    Then Aplikasi Menampilkan Laporan Semua Sesuai Departemen "Sysmex"
Scenario: Menampilkan Laporan Semua Departemen Sysmex dalam Rentang Tanggal
    Given Saya Memasukkan Rentang Tanggal "18/01/2025" sampai "01/03/2025"
    And Departemen "Sysmex" di Kolom Filter Departemen Laporan Semua
    When Saya Memfilter Departemen Laporan Semua
    Then Aplikasi Menampilkan Laporan Semua Sesuai Departemen "Sysmex" dalam Rentang Tanggal "18/01/2025" sampai "01/03/2025"
Scenario: Menampilkan Laporan Semua Departemen Security
    Given Departemen "Security" di Kolom Filter Departemen Laporan Semua
    When Saya Memfilter Departemen Laporan Semua
    Then Aplikasi Menampilkan 0 Laporan Semua
Scenario: Mencari Laporan Berdasarkan Rentang Tanggal dan Nama Karyawan "Momo"
    Given Saya Memasukkan Rentang Tanggal "18/01/2025" sampai "01/03/2025" dan Nama Karyawan "Momo"
    When Saya Memfilter dan Menekan Tombol Search
    Then Aplikasi Menampilkan Laporan Semua Sesuai Nama "Momo" dalam Rentang Tanggal "18/01/2025" sampai "01/03/2025"
    When Saya Menekan Tombol Reset Filter
    Then Aplikasi Tidak Menampilkan Laporan dengan Rentang Tanggal "18/01/2025" sampai "01/03/2025" dan Nama "Momo"
  Scenario: Menampilkan 25 Laporan Semua
    Given Tanggal Mulai "01/01/2025" di Kolom Filter Tanggal Laporan Semua
    And Tanggal Selesai "01/03/2025" di Kolom Filter Tanggal Laporan Semua
    When Saya Memfilter Tanggal Laporan Semua
    When Saya Mengubah Jumlah Tampilan Tabel Laporan Semua Menjadi 25
    Then Aplikasi Menampilkan 25 Laporan Semua

  Scenario: Menampilkan Laporan Semua Halaman Selanjutnya
    Given Tanggal Mulai "01/01/2024" di Kolom Filter Tanggal Laporan Semua
    And Tanggal Selesai "01/03/2025" di Kolom Filter Tanggal Laporan Semua
    When Saya Memfilter Tanggal Laporan Semua
    When Saya Berpindah Ke Laporan Semua Halaman Selanjutnya
    Then Aplikasi Menampilkan Laporan Semua Halaman Kedua

  Scenario: Menampilkan Laporan Semua Halaman Sebelumnya
      Given Tanggal Mulai "01/01/2024" di Kolom Filter Tanggal Laporan Semua
    And Tanggal Selesai "01/03/2025" di Kolom Filter Tanggal Laporan Semua
    When Saya Memfilter Tanggal Laporan Semua
    When Saya Berpindah Ke Laporan Semua Halaman Selanjutnya
    And Saya Berpindah Ke Laporan Semua Halaman Sebelumnya
    Then Aplikasi Menampilkan Laporan Semua Halaman Pertama

  Scenario: Menampilkan Laporan Semua Halaman Terakhir
      Given Tanggal Mulai "01/01/2024" di Kolom Filter Tanggal Laporan Semua
    And Tanggal Selesai "01/03/2025" di Kolom Filter Tanggal Laporan Semua
    When Saya Memfilter Tanggal Laporan Semua
    When Saya Berpindah Ke Laporan Semua Halaman Terakhir
    Then Aplikasi Menampilkan Laporan Semua Halaman Terakhir

  Scenario: Menampilkan Laporan Semua Halaman Pertama
      Given Tanggal Mulai "01/01/2024" di Kolom Filter Tanggal Laporan Semua
    And Tanggal Selesai "01/03/2025" di Kolom Filter Tanggal Laporan Semua
    When Saya Memfilter Tanggal Laporan Semua
    When Saya Berpindah Ke Laporan Semua Halaman Selanjutnya
    And Saya Berpindah Ke Laporan Semua Halaman Pertama
    Then Aplikasi Menampilkan Laporan Semua Halaman Pertama

      Scenario: Menampilkan Semua Laporan Semua Teratas
    When Saya Membuka Laporan Semua
    Then Aplikasi Menampilkan Semua Laporan Semua Teratas
