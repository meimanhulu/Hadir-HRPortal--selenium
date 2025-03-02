@LaporanCuti
Feature: Laporan Cuti

  Scenario: Mencari Laporan Cuti Berdasarkan Nama Karyawan "ADITYA RIDWAN NUGRAHA"
    Given Nama Karyawan "ADITYA RIDWAN NUGRAHA" di Kolom Pencarian Laporan Cuti
    When Saya Mencari Laporan Cuti
    Then Aplikasi Menampilkan Laporan Cuti Sesuai Nama "ADITYA RIDWAN NUGRAHA"

  Scenario: Menampilkan Laporan Cuti Departemen "Iforte"
    Given Departemen "Iforte" di Kolom Filter Departemen Laporan Cuti
    When Saya Memfilter Departemen Laporan Cuti
    Then Aplikasi Menampilkan Laporan Cuti Sesuai Departemen "Iforte"

  Scenario: Menampilkan Laporan Cuti dari Tanggal 10/01/2021 sampai 20/02/2025
    Given Tanggal Mulai "10/01/2021" di Kolom Filter Tanggal Laporan Cuti
    And Tanggal Selesai "20/02/2025" di Kolom Filter Tanggal Laporan Cuti
    When Saya Memfilter Tanggal Laporan Cuti
    Then Aplikasi Menampilkan Laporan Cuti dari Tanggal "10/01/2021"
    And Aplikasi Menampilkan Laporan Cuti Sampai Tanggal "20/02/2025"

  Scenario: Menghilangkan Parameter-parameter Filter Laporan Cuti yang Dibuat
    Given Nama Karyawan "ADITYA RIDWAN NUGRAHA" di Kolom Pencarian Laporan Cuti
    And Saya Mencari Laporan Cuti
    And Departemen "Iforte" di Kolom Filter Departemen Laporan Cuti
    And Saya Memfilter Departemen Laporan Cuti
    And Tanggal Mulai "10/01/2021" di Kolom Filter Tanggal Laporan Cuti
    And Tanggal Selesai "20/02/2025" di Kolom Filter Tanggal Laporan Cuti
    And Saya Memfilter Tanggal Laporan Cuti
    When Saya Menekan Tombol Reset di Laporan Cuti
    Then Aplikasi Menampilkan Laporan Cuti Tidak Berdasarkan Nama "ADITYA RIDWAN NUGRAHA"
    And Aplikasi Menampilkan Laporan Cuti Tidak Berdasarkan Departemen "Iforte"
    And Aplikasi Menampilkan Laporan Cuti Tidak Berdasarkan Tanggal Mulai "10/01/2021"
    And Aplikasi Menampilkan Laporan Cuti Tidak Berdasarkan Tanggal Selesai Sampai "20/02/2025"

  Scenario: Menampilkan 25 Laporan Cuti
    When Saya Mengubah Jumlah Tampilan Tabel Laporan Cuti Menjadi 25
    Then Aplikasi Menampilkan 25 Laporan Cuti Teratas

  Scenario: Menampilkan Laporan Cuti Halaman Selanjutnya
    When Saya Berpindah Ke Laporan Cuti Halaman Selanjutnya
    Then Aplikasi Menampilkan Laporan Cuti Halaman Kedua

  Scenario: Menampilkan Laporan Cuti Halaman Sebelumnya
    When Saya Berpindah Ke Laporan Cuti Halaman Selanjutnya
    And Saya Berpindah Ke Laporan Cuti Halaman Sebelumnya
    Then Aplikasi Menampilkan Laporan Cuti Halaman Pertama

  Scenario: Menampilkan Laporan Cuti Halaman Terakhir
    When Saya Berpindah Ke Laporan Cuti Halaman Terakhir
    Then Aplikasi Menampilkan Laporan Cuti Halaman Terakhir

  Scenario: Menampilkan Laporan Cuti Halaman Pertama
    When Saya Berpindah Ke Laporan Cuti Halaman Selanjutnya
    And Saya Berpindah Ke Laporan Cuti Halaman Pertama
    Then Aplikasi Menampilkan Laporan Cuti Halaman Pertama

  Scenario: Menampilkan Semua Laporan Cuti Teratas
    When Saya Membuka Laporan Cuti
    Then Aplikasi Menampilkan Semua Laporan Cuti Teratas