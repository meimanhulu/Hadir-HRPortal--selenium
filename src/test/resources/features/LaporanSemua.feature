@LaporanSemua
Feature: Pengujian Fitur "Laporan Semua"
  Scenario: Mencari Laporan Berdasarkan Nama Karyawan "Momo"
    Given Nama Karyawan "Momo" di Kolom Pencarian Laporan Semua
    When Saya menekan tombol Search
    Then Aplikasi Menampilkan Laporan Semua Sesuai "Momo"
  
