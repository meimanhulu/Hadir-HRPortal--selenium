@LaporanIzinPulangCepat
Feature: Laporan Izin Pulang Cepat

  Scenario: Mencari Laporan Izin Pulang Cepat Berdasarkan Nama Karyawan "Agung Aji Nugraha"
    Given Nama Karyawan "Agung Aji Nugraha" di Kolom Pencarian Laporan Izin Pulang Cepat
    When Saya Mencari Laporan Izin Pulang Cepat
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat Sesuai Nama "Agung Aji Nugraha"

  Scenario: Menampilkan Laporan Izin Pulang Cepat Departemen "Tiket.com"
    Given Departemen "Tiket.com" di Kolom Filter Departemen Laporan Izin Pulang Cepat
    When Saya Memfilter Departemen Laporan Izin Pulang Cepat
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat Sesuai Departemen "Tiket.com"

  Scenario: Menampilkan Laporan Izin Pulang Cepat dari Tanggal 11/12/2024 sampai 25/02/2025
    Given Tanggal Mulai "11/12/2024" di Kolom Filter Tanggal Laporan Izin Pulang Cepat
    And Tanggal Selesai "25/02/2025" di Kolom Filter Tanggal Laporan Izin Pulang Cepat
    When Saya Memfilter Tanggal Laporan Izin Pulang Cepat
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat dari Tanggal "11/12/2024"
    And Aplikasi Menampilkan Laporan Izin Pulang Cepat Sampai Tanggal "25/02/2025"

  Scenario: Menghilangkan Parameter-parameter Filter Laporan Izin Pulang Cepat yang Dibuat
    Given Nama Karyawan "Hadir SQA Testing 1" di Kolom Pencarian Laporan Izin Pulang Cepat
    And Saya Mencari Laporan Izin Pulang Cepat
    And Departemen "Sysmex" di Kolom Filter Departemen Laporan Izin Pulang Cepat
    And Saya Memfilter Departemen Laporan Izin Pulang Cepat
    And Tanggal Mulai "01/01/2025" di Kolom Filter Tanggal Laporan Izin Pulang Cepat
    And Tanggal Selesai "24/02/2025" di Kolom Filter Tanggal Laporan Izin Pulang Cepat
    And Saya Memfilter Tanggal Laporan Izin Pulang Cepat
    When Saya Menekan Tombol Reset di Laporan Izin Pulang Cepat
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Nama "Hadir SQA Testing 1"
    And Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Departemen "Sysmex"
    And Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Tanggal Mulai "01/01/2025"
    And Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Tanggal Selesai Sampai "24/02/2025"

  Scenario: Menampilkan 25 Laporan Izin Pulang Cepat
    When Saya Mengubah Jumlah Tampilan Tabel Laporan Izin Pulang Cepat Menjadi 25
    Then Aplikasi Menampilkan 25 Laporan Izin Pulang Cepat Teratas

  Scenario: Menampilkan Laporan Izin Pulang Cepat Halaman Selanjutnya
    When Saya Berpindah Ke Laporan Izin Pulang Cepat Halaman Selanjutnya
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat Halaman Kedua

  Scenario: Menampilkan Laporan Izin Pulang Cepat Halaman Sebelumnya
    When Saya Berpindah Ke Laporan Izin Pulang Cepat Halaman Selanjutnya
    And Saya Berpindah Ke Laporan Izin Pulang Cepat Halaman Sebelumnya
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat Halaman Pertama

  Scenario: Menampilkan Laporan Izin Pulang Cepat Halaman Terakhir
    When Saya Berpindah Ke Laporan Izin Pulang Cepat Halaman Terakhir
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat Halaman Terakhir

  Scenario: Menampilkan Laporan Izin Pulang Cepat Halaman Pertama
    When Saya Berpindah Ke Laporan Izin Pulang Cepat Halaman Selanjutnya
    And Saya Berpindah Ke Laporan Izin Pulang Cepat Halaman Pertama
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat Halaman Pertama

  Scenario: Menampilkan Semua Laporan Izin Pulang Cepat Teratas
    When Saya Membuka Laporan Izin Pulang Cepat
    Then Aplikasi Menampilkan Semua Laporan Izin Pulang Cepat Teratas