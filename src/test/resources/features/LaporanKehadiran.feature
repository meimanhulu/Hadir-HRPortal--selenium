Feature: Laporan Kehadiran

  Scenario: Mencari Laporan Kehadiran Berdasarkan Nama Karyawan "ADITYA RIDWAN NUGRAHA"
    Given Nama Karyawan "ADITYA RIDWAN NUGRAHA" di Kolom Pencarian Laporan Kehadiran
    When Saya Mencari Laporan Kehadiran
    Then Aplikasi Menampilkan Laporan Kehadiran Sesuai Nama "ADITYA RIDWAN NUGRAHA"

  Scenario: Menampilkan Laporan Kehadiran Departemen "Iforte"
    Given Departemen "Iforte" di Kolom Filter Departemen Laporan Kehadiran
    When Saya Memfilter Departemen Laporan Kehadiran
    Then Aplikasi Menampilkan Laporan Kehadiran Sesuai Departemen "Iforte"

  Scenario: Menampilkan Laporan Kehadiran dari Tanggal 10/01/2021 sampai 20/02/2025
    Given Tanggal Mulai "10/01/2021" di Kolom Filter Tanggal Laporan Kehadiran
    And Tanggal Selesai "20/02/2025" di Kolom Filter Tanggal Laporan Kehadiran
    When Saya Memfilter Tanggal Laporan Kehadiran
    Then Aplikasi Menampilkan Laporan Kehadiran dari Tanggal "10/01/2021"
    And Aplikasi Menampilkan Laporan Kehadiran Sampai Tanggal "20/02/2025"

  Scenario: Menghilangkan Parameter-parameter Filter Laporan Kehadiran yang Dibuat
    Given Nama Karyawan "ADITYA RIDWAN NUGRAHA" di Kolom Pencarian Laporan Kehadiran
    And Saya Mencari Laporan Kehadiran
    And Departemen "Iforte" di Kolom Filter Departemen Laporan Kehadiran
    And Saya Memfilter Departemen Laporan Kehadiran
    And Tanggal Mulai "10/01/2021" di Kolom Filter Tanggal Laporan Kehadiran
    And Tanggal Selesai "20/02/2025" di Kolom Filter Tanggal Laporan Kehadiran
    And Saya Memfilter Tanggal Laporan Kehadiran
    When Saya Menekan Tombol Reset di Laporan Kehadiran
    Then Aplikasi Menampilkan Laporan Kehadiran Tidak Berdasarkan Nama "ADITYA RIDWAN NUGRAHA"
    And Aplikasi Menampilkan Laporan Kehadiran Tidak Berdasarkan Departemen "Iforte"
    And Aplikasi Menampilkan Laporan Kehadiran Tidak Berdasarkan Tanggal Mulai "10/01/2021"
    And Aplikasi Menampilkan Laporan Kehadiran Tidak Berdasarkan Tanggal Selesai Sampai "20/02/2025"

  Scenario: Menampilkan 25 Laporan Kehadiran
    When Saya Mengubah Jumlah Tampilan Tabel Laporan Kehadiran Menjadi 25
    Then Aplikasi Menampilkan 25 Laporan Kehadiran Teratas

  Scenario: Menampilkan Laporan Kehadiran Halaman Selanjutnya
    When Saya Berpindah Ke Laporan Kehadiran Halaman Selanjutnya
    Then Aplikasi Menampilkan Laporan Kehadiran Halaman Kedua

  Scenario: Menampilkan Laporan Kehadiran Halaman Sebelumnya
    When Saya Berpindah Ke Laporan Kehadiran Halaman Selanjutnya
    And Saya Berpindah Ke Laporan Kehadiran Halaman Sebelumnya
    Then Aplikasi Menampilkan Laporan Kehadiran Halaman Pertama

  Scenario: Menampilkan Laporan Kehadiran Halaman Terakhir
    When Saya Berpindah Ke Laporan Kehadiran Halaman Terakhir
    Then Aplikasi Menampilkan Laporan Kehadiran Halaman Terakhir

  Scenario: Menampilkan Laporan Kehadiran Halaman Pertama
    When Saya Berpindah Ke Laporan Kehadiran Halaman Selanjutnya
    And Saya Berpindah Ke Laporan Kehadiran Halaman Pertama
    Then Aplikasi Menampilkan Laporan Kehadiran Halaman Pertama

  Scenario: Menampilkan Semua Laporan Kehadiran Teratas
    When Saya Membuka Laporan Kehadiran
    Then Aplikasi Menampilkan Semua Laporan Kehadiran Teratas

  Scenario: Mengekspor Laporan Kehadiran Menggunakan Tombol Export 
    When Saya Menekan Tombol Export Laporan Kehadiran
    And Saya Mengkonfirmasi Export Laporan Kehadiran
    Then Aplikasi Memproses Export Laporan Kehadiran

  Scenario: Membatalkan Export Laporan Kehadiran 
    When Saya Menekan Tombol Export Laporan Kehadiran
    And Saya Menekan Tombol Batal Laporan Kehadiran
    Then Aplikasi Membatalkan Proses Export Laporan Kehadiran
