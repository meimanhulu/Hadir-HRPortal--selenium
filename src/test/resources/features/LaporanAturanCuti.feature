Feature: Laporan Aturan Cuti

  # Scenario: Mencari Laporan Aturan Cuti Berdasarkan Nama Cuti "Aturan Cuti New"
  #   Given Nama Cuti "Aturan Cuti New" di Kolom Pencarian Laporan Aturan Cuti
  #   When Saya menekan tombol Search Laporan Aturan Cuti
  #   Then Sistem Menampilkan Laporan Aturan Cuti Berdasarkan Nama Cuti "Aturan Cuti New"

  # Scenario: Mencari Laporan Aturan Cuti Yang Tidak Ada Berdasarkan Nama Cuti "Aturan Cuti New"
  #   Given Nama Cuti "Tanggal Merah" di Kolom Pencarian Laporan Aturan Cuti
  #   When Saya menekan tombol Search Laporan Aturan Cuti
  #   Then Sistem Menampilkan Hasil 0 Pencarian Laporan Aturan Cuti

  # Scenario: Menghilangkan Filter Pencarian Laporan Aturan Cuti
  #   Given Nama Cuti "Aturan Cuti New" di Kolom Pencarian Laporan Aturan Cuti
  #   When Saya menekan tombol Search Laporan Aturan Cuti
  #   When Saya menekan tombol Riset Filter Laporan Aturan Cuti
  #   Then Sistem Menampilkan Semua Laporan Aturan Cuti

  # Scenario: Menampilkan 5 Laporan Aturan Cuti Teratas
  #   When Saya Mengubah Jumlah Tampilan Tabel Laporan Aturan Cuti Menjadi 5
  #   Then Aplikasi Menampilkan 5 Laporan Aturan Cuti Teratas

  # Scenario: Menampilkan 10 Laporan Aturan Cuti Teratas
  #   When Saya Mengubah Jumlah Tampilan Tabel Laporan Aturan Cuti Menjadi 10
  #   Then Aplikasi Menampilkan 10 Laporan Aturan Cuti Teratas

  # Scenario: Menampilkan Laporan Aturan Cuti Halaman Sebelumnya
  #   When Saya Berpindah Ke Laporan Aturan Cuti Halaman Selanjutnya
  #   And Saya Berpindah Ke Laporan Aturan Cuti Halaman Sebelumnya
  #   Then Aplikasi Menampilkan Laporan Aturan Cuti Halaman Pertama

  # Scenario: Menampilkan Laporan Aturan Cuti Halaman Terakhir
  #   When Saya Berpindah Ke Laporan Aturan Cuti Halaman Terakhir
  #   Then Aplikasi Menampilkan Laporan Aturan Cuti Halaman Terakhir

  # Scenario: Menampilkan Laporan Aturan Cuti Halaman Pertama
  #   When Saya Berpindah Ke Laporan Aturan Cuti Halaman Selanjutnya
  #   And Saya Berpindah Ke Laporan Aturan Cuti Halaman Pertama
  #   Then Aplikasi Menampilkan Laporan Aturan Cuti Halaman Pertama

  # Scenario: Menampilkan Semua Laporan Aturan Cuti Teratas
  #   When Saya Membuka Laporan Aturan Cuti
  #   Then Aplikasi Menampilkan Semua Laporan Aturan Cuti Teratas
  #   #error

  Scenario: Menampilkan Laporan Aturan Cuti Halaman Selanjutnya
    When Saya Berpindah Ke Laporan Aturan Cuti Halaman Selanjutnya
    Then Aplikasi Menampilkan Laporan Aturan Cuti Halaman Kedua
