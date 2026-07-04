/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sport;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author MSIrone
 */
public class StyleDrop {
    private static final Scanner scanner = new Scanner(System.in);
 
    // Array: menampung objek-objek turunan PesananJastip
    private static final PesananJastip[] daftarPesanan = new PesananJastip[10];
    private static int jumlahPesanan = 0;
 
    public static void main(String[] args) {
        try (scanner) {
            int pilihan;
            
            System.out.println("############################################");
            System.out.println("#           SELAMAT DATANG DI               #");
            System.out.println("#                STYLEDROP                  #");
            System.out.println("#   Jasa Titip Perlengkapan Sport Favoritmu #");
            System.out.println("############################################");
            
            // Perulangan (do-while): menampilkan menu terus-menerus sampai user memilih keluar
            do {
                tampilkanMenu();
                pilihan = bacaPilihanMenu();
                
                // Seleksi (switch-case) untuk menentukan aksi berdasarkan pilihan
                switch (pilihan) {
                    case 1 -> tambahPesananPakaian();
                    case 2 -> tambahPesananAlat();
                    case 3 -> tampilkanSemuaPesanan();
                    case 4 -> updateStatusPembayaran();
                    case 5 -> System.out.println("Terima kasih telah menggunakan StyleDrop. Sampai jumpa!");
                    default -> System.out.println("Pilihan tidak tersedia, silakan coba lagi.");
                }
                System.out.println();
            } while (pilihan != 5);
        }
    }
 
    private static void tampilkanMenu() {
        System.out.println("---------------- MENU STYLEDROP ----------------");
        System.out.println("1. Tambah Pesanan Pakaian Sport (Jersey/Sepatu)");
        System.out.println("2. Tambah Pesanan Alat Sport (Sarung Tinju/Raket)");
        System.out.println("3. Tampilkan Semua Struk Pesanan");
        System.out.println("4. Update Status Pembayaran");
        System.out.println("5. Keluar");
        System.out.print("Masukkan pilihan (1-5): ");
    }
 
    // Error Handling saat membaca pilihan menu agar input huruf tidak membuat program crash
    private static int bacaPilihanMenu() {
        int pilihan = -1;
        try {
            pilihan = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            scanner.next(); // membuang input yang salah dari buffer
        }
        return pilihan;
    }
 
    private static void tambahPesananPakaian() {
        // Seleksi (if): cek kapasitas array sebelum menambah data baru
        if (jumlahPesanan >= daftarPesanan.length) {
            System.out.println("Maaf, kapasitas antrean pesanan sudah penuh!");
            return;
        }
 
        try {
            scanner.nextLine(); // membersihkan sisa buffer newline
            System.out.print("Nama Pelanggan               : ");
            String namaPelanggan = scanner.nextLine();
 
            System.out.print("Nama Barang (Jersey/Sepatu)  : ");
            String namaBarang = scanner.nextLine();
 
            System.out.print("Harga Asli Barang (Rp)       : ");
            double harga = scanner.nextDouble();
 
            System.out.print("Jumlah Barang                : ");
            int jumlah = scanner.nextInt();
 
            String idPesanan = "PS-" + String.format("%03d", jumlahPesanan + 1);
 
            // Object: instansiasi objek baru dari subclass, disimpan sebagai tipe superclass
            PesananJastip pesananBaru = new JastipPakaianSport(idPesanan, namaBarang, harga, jumlah, namaPelanggan);
 
            daftarPesanan[jumlahPesanan] = pesananBaru;
            jumlahPesanan++;
 
            System.out.println("Pesanan berhasil ditambahkan dengan ID: " + idPesanan);
 
        } catch (InputMismatchException e) {
            System.out.println("Input harga/jumlah harus berupa angka! Pesanan gagal disimpan.");
            scanner.nextLine(); // buang input tak valid agar program tidak crash
        }
    }
 
    private static void tambahPesananAlat() {
        if (jumlahPesanan >= daftarPesanan.length) {
            System.out.println("Maaf, kapasitas antrean pesanan sudah penuh!");
            return;
        }
 
        try {
            scanner.nextLine();
            System.out.print("Nama Pelanggan                     : ");
            String namaPelanggan = scanner.nextLine();
 
            System.out.print("Nama Barang (Sarung Tinju/Raket)   : ");
            String namaBarang = scanner.nextLine();
 
            System.out.print("Harga Asli Barang (Rp)             : ");
            double harga = scanner.nextDouble();
 
            System.out.print("Jumlah Barang                      : ");
            int jumlah = scanner.nextInt();
 
            System.out.print("Berat Barang (kg)                  : ");
            double berat = scanner.nextDouble();
 
            String idPesanan = "AS-" + String.format("%03d", jumlahPesanan + 1);
 
            PesananJastip pesananBaru = new JastipAlatSport(idPesanan, namaBarang, harga, jumlah, namaPelanggan, berat);
 
            daftarPesanan[jumlahPesanan] = pesananBaru;
            jumlahPesanan++;
 
            System.out.println("Pesanan berhasil ditambahkan dengan ID: " + idPesanan);
 
        } catch (InputMismatchException e) {
            System.out.println("Input harga/jumlah/berat harus berupa angka! Pesanan gagal disimpan.");
            scanner.nextLine();
        }
    }
 
    // Perulangan (for loop) untuk menyisir seluruh data dalam array
    private static void tampilkanSemuaPesanan() {
        if (jumlahPesanan == 0) {
            System.out.println("Belum ada data pesanan yang tersimpan.");
            return;
        }
 
        System.out.println("\n>>> DAFTAR SELURUH PESANAN STYLEDROP <<<\n");
        for (int i = 0; i < jumlahPesanan; i++) {
            // Polymorphism terjadi di sini: cetakStruk() memanggil hitungTotalBiaya()
            // yang hasilnya berbeda tergantung objek aslinya (Pakaian atau Alat)
            daftarPesanan[i].cetakStruk();
        }
    }
 
    private static void updateStatusPembayaran() {
        if (jumlahPesanan == 0) {
            System.out.println("Belum ada data pesanan.");
            return;
        }
 
        try {
            scanner.nextLine();
            System.out.print("Masukkan ID Pesanan yang ingin dibayar: ");
            String id = scanner.nextLine();
 
            PesananJastip pesananDicari = null;
            // Perulangan (for) untuk mencari pesanan berdasarkan ID
            for (int i = 0; i < jumlahPesanan; i++) {
                if (daftarPesanan[i].getIdPesanan().equalsIgnoreCase(id)) {
                    pesananDicari = daftarPesanan[i];
                    break;
                }
            }
 
            // Seleksi (if): validasi apakah data ditemukan
            if (pesananDicari == null) {
                System.out.println("ID Pesanan tidak ditemukan.");
                return;
            }
 
            double totalBiaya = pesananDicari.hitungTotalBiaya();
            System.out.println("Total tagihan untuk pesanan ini : Rp" + String.format("%,.0f", totalBiaya));
            System.out.print("Masukkan jumlah uang yang dibayarkan : Rp");
            double totalBayar = scanner.nextDouble();
 
            // Seleksi (if-else) untuk menentukan status pembayaran
            if (totalBayar >= totalBiaya) {
                pesananDicari.setStatusPembayaran("Lunas");
                System.out.println("Pembayaran berhasil! Status pesanan: Lunas.");
            } else {
                pesananDicari.setStatusPembayaran("DP/Kurang");
                double kurang = totalBiaya - totalBayar;
                System.out.println("Pembayaran belum mencukupi. Kekurangan: Rp" + String.format("%,.0f", kurang));
            }
 
        } catch (InputMismatchException e) {
            System.out.println("Input nominal pembayaran harus berupa angka!");
            scanner.nextLine();
        }
    }
}
