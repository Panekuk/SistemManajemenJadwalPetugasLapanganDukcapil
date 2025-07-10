package jadwalpetugas; // Mendeklarasikan package tempat file ini berada

import java.util.ArrayList; // Mengimpor ArrayList untuk menyimpan banyak objek PetugasLapangan
import java.util.Scanner;   // Mengimpor Scanner untuk membaca input dari pengguna

public class PetugasBeraksi { // Kelas utama yang menjalankan program
    public static void main(String[] args) { // Metode utama program
        Scanner input = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari keyboard
        ArrayList<PetugasLapangan> daftarPetugas = new ArrayList<>(); // Menyimpan semua data petugas lapangan
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"}; // Nama hari untuk jadwal

        boolean berjalan = true; // Penanda agar program tetap berjalan sampai pengguna memilih keluar
        while (berjalan) { // Perulangan utama (menu)
            System.out.println("\n=== SISTEM JADWAL PETUGAS DUKCAPIL ===");
            System.out.println("1. Input Data Petugas"); // Opsi menu 1
            System.out.println("2. Lihat Daftar Petugas"); // Opsi menu 2
            System.out.println("3. Cek Konflik Jadwal"); // Opsi menu 3
            System.out.println("0. Keluar"); // Opsi menu keluar
            System.out.print("Pilih menu: ");
            String pilihan = input.nextLine(); // Membaca input pilihan menu

            switch (pilihan) { // Percabangan berdasarkan input pengguna
                case "1": // Input data petugas
                    try {
                        System.out.print("Masukkan jumlah petugas yang ingin ditambahkan: ");
                        int jumlah = Integer.parseInt(input.nextLine()); // Membaca jumlah petugas dan konversi ke integer

                        for (int p = 0; p < jumlah; p++) { // Ulangi sesuai jumlah petugas
                            System.out.println("\nData Petugas ke-" + (p + 1));

                            System.out.print("Nama: ");
                            String nama = input.nextLine(); // Input nama petugas

                            String nik;
                            while (true) { // Validasi panjang NIK harus 16 digit
                                System.out.print("NIK (16 digit): ");
                                nik = input.nextLine();
                                if (nik.length() == 16) break; // Jika valid, lanjut
                                System.out.println("NIK harus 16 digit!"); // Jika tidak valid, ulangi
                            }

                            System.out.print("Wilayah: ");
                            String wilayah = input.nextLine(); // Input wilayah tugas

                            // Buat ID petugas otomatis, misal: PTGS001, PTGS002, dst
                            String idPetugas = "PTGS" + String.format("%03d", daftarPetugas.size() + 1);
                            // Membuat objek petugas
                            PetugasLapangan petugas = new PetugasLapangan(nama, nik, wilayah, idPetugas);

                            // Input kegiatan untuk 7 hari
                            for (int i = 0; i < hari.length; i++) {
                                System.out.print("Kegiatan hari " + hari[i] + ": ");
                                String kegiatan = input.nextLine(); // Input kegiatan

                                if (kegiatan.isEmpty()) kegiatan = "Libur / Tidak Ada Tugas"; // Default jika kosong

                                petugas.setJadwalHarian(i, new Jadwal(hari[i], kegiatan)); // Set jadwal harian
                            }

                            daftarPetugas.add(petugas); // Tambahkan ke list
                            System.out.println("Petugas berhasil ditambahkan!");
                        }
                    } catch (NumberFormatException e) { // Menangkap error jika input bukan angka
                        System.out.println("Input jumlah tidak valid. Harus berupa angka.");
                    }
                    break;

                case "2": // Menampilkan daftar petugas
                    if (daftarPetugas.isEmpty()) {
                        System.out.println("Belum ada data petugas.");
                    } else {
                        System.out.println("\n=== DAFTAR PETUGAS DAN JADWAL ===");
                        for (PetugasLapangan p : daftarPetugas) { // Iterasi semua petugas
                            p.tampilkanInfo(); // Tampilkan ID, nama, NIK, wilayah
                            for (Jadwal j : p.getJadwalMingguan()) { // Tampilkan jadwal mingguannya
                                j.tampilkanJadwal(); // Tampilkan hari dan kegiatan
                            }
                            System.out.println(); // Baris kosong sebagai pemisah
                        }
                    }
                    break;

                case "3": // Mengecek konflik antar petugas
                    System.out.println("=== PENGECEKAN KONFLIK JADWAL ===");
                    boolean konflikDitemukan = false; // Penanda apakah ada konflik

                    // Bandingkan semua pasangan petugas
                    for (int i = 0; i < daftarPetugas.size(); i++) {
                        for (int j = i + 1; j < daftarPetugas.size(); j++) {
                            PetugasLapangan p1 = daftarPetugas.get(i);
                            PetugasLapangan p2 = daftarPetugas.get(j);

                            // Bandingkan jadwal harian antara p1 dan p2
                            for (int h = 0; h < 7; h++) {
                                Jadwal j1 = p1.getJadwalMingguan()[h];
                                Jadwal j2 = p2.getJadwalMingguan()[h];

                                // Jika kegiatan sama, bukan libur, dan wilayah sama → konflik
                                if (
                                    j1.getKegiatan().equalsIgnoreCase(j2.getKegiatan()) &&
                                    !j1.getKegiatan().equalsIgnoreCase("Libur / Tidak Ada Tugas") &&
                                    p1.getWilayahTugas().equalsIgnoreCase(p2.getWilayahTugas())
                                ) {
                                    konflikDitemukan = true;
                                    System.out.println("⚠️ Konflik: " + p1.getNama() + " & " + p2.getNama() +
                                            " pada " + j1.getHari() + ", kegiatan: " + j1.getKegiatan() +
                                            ", wilayah: " + p1.getWilayahTugas());
                                }
                            }
                        }
                    }

                    if (!konflikDitemukan) {
                        System.out.println("Tidak ada konflik jadwal ditemukan.");
                    }
                    break;

                case "0": // Keluar dari program
                    berjalan = false;
                    System.out.println("Program selesai.");
                    break;

                default: // Jika pilihan tidak sesuai
                    System.out.println("Pilihan tidak valid. Silakan pilih 0-3.");
            }
        }

        input.close(); // Menutup Scanner untuk mencegah memory leak
    }
}
