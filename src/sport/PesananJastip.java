/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sport;

/**
 *
 * @author MSIrone
 */
public abstract class PesananJastip {
    // Atribut (private -> Encapsulation, tidak bisa diakses langsung dari luar)
    private final String idPesanan;
    private final String namaBarang;
    private final double hargaAsli;
    private final int jumlah;
    private final String namaPelanggan;
    private String statusPembayaran;
 
    // Constructor: mengisi nilai awal begitu objek diciptakan
    public PesananJastip(String idPesanan, String namaBarang, double hargaAsli, int jumlah, String namaPelanggan) {
        this.idPesanan = idPesanan;
        this.namaBarang = namaBarang;
        this.hargaAsli = hargaAsli;
        this.jumlah = jumlah;
        this.namaPelanggan = namaPelanggan;
        this.statusPembayaran = "Belum Bayar";
    }
 
    // Accessor (Getter)
    public String getIdPesanan() {
        return idPesanan;
    }
 
    public String getNamaBarang() {
        return namaBarang;
    }
 
    public double getHargaAsli() {
        return hargaAsli;
    }
 
    public int getJumlah() {
        return jumlah;
    }
 
    public String getNamaPelanggan() {
        return namaPelanggan;
    }
 
    public String getStatusPembayaran() {
        return statusPembayaran;
    }
 
    // Mutator (Setter)
    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }
 
    /**
     * Polymorphism: method abstrak ini WAJIB diimplementasikan berbeda
     * oleh setiap subclass (JastipPakaianSport vs JastipAlatSport),
     * sesuai rumus perhitungan biaya masing-masing.
     * @return 
     */
    public abstract double hitungTotalBiaya();
 
    /**
     * Method umum untuk mencetak struk ke terminal.
     * Saat memanggil hitungTotalBiaya(), Java otomatis menjalankan
     * versi method milik objek aslinya (inilah wujud nyata Polymorphism).
     */
    public void cetakStruk() {
        System.out.println("======================================");
        System.out.println("        STRUK STYLEDROP JASTIP        ");
        System.out.println("======================================");
        System.out.println("ID Pesanan   : " + idPesanan);
        System.out.println("Pelanggan    : " + namaPelanggan);
        System.out.println("Jenis Item   : " + this.getClass().getSimpleName());
        System.out.println("Barang       : " + namaBarang);
        System.out.println("Jumlah       : " + jumlah);
        System.out.println("Harga Asli   : Rp" + String.format("%,.0f", hargaAsli));
        System.out.println("Total Biaya  : Rp" + String.format("%,.0f", hitungTotalBiaya()));
        System.out.println("Status Bayar : " + statusPembayaran);
        System.out.println("======================================");
    }
} 
