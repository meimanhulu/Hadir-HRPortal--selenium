Feature: Laporan Izin Pulang Cepat

  Scenario: Mencari Laporan Izin Pulang Cepat Berdasarkan Nama Karyawan "Kazama"
    Given Nama Karyawan "Kazama" di Kolom Pencarian Laporan Izin Pulang Cepat
    When Saya Mencari Laporan Izin Pulang Cepat
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat Sesuai Nama "Kazama"

  Scenario: Menampilkan Laporan Izin Pulang Cepat Departemen "APP Luar Kota"
    Given Departemen "APP Luar Kota" di Kolom Filter Departemen Laporan Izin Pulang Cepat
    When Saya Memfilter Departemen Laporan Izin Pulang Cepat
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat Sesuai Departemen "APP Luar Kota"

  Scenario: Menampilkan Laporan Izin Pulang Cepat dari Tanggal 10/08/2024 sampai 01/01/2025
    Given Tanggal Mulai "10/08/2024" di Kolom Filter Tanggal Laporan Izin Pulang Cepat
    And Tanggal Selesai "01/01/2025" di Kolom Filter Tanggal Laporan Izin Pulang Cepat
    When Saya Memfilter Tanggal Laporan Izin Pulang Cepat
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat dari Tanggal "10/08/2024"
    And Aplikasi Menampilkan Laporan Izin Pulang Cepat Sampai Tanggal "01/01/2025"

  Scenario: Menghilangkan Parameter-parameter Filter Laporan Izin Pulang Cepat yang Dibuat
    Given Nama Karyawan "Kazama" di Kolom Pencarian Laporan Izin Pulang Cepat
    And Saya Mencari Laporan Izin Pulang Cepat
    And Departemen "IT Programmer" di Kolom Filter Departemen Laporan Izin Pulang Cepat
    And Saya Memfilter Departemen Laporan Izin Pulang Cepat
    And Tanggal Mulai "19/11/2024" di Kolom Filter Tanggal Laporan Izin Pulang Cepat
    And Tanggal Selesai "23/11/2024" di Kolom Filter Tanggal Laporan Izin Pulang Cepat
    And Saya Memfilter Tanggal Laporan Izin Pulang Cepat
    When Saya Menekan Tombol Reset di Laporan Izin Pulang Cepat
    Then Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Nama "Kazama"
    And Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Departemen "IT Programmer"
    And Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Tanggal Mulai "19/11/2024"
    And Aplikasi Menampilkan Laporan Izin Pulang Cepat Tidak Berdasarkan Tanggal Selesai Sampai "23/11/2024"

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