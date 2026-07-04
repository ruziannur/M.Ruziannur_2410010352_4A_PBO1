/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sport;

/**
 *
 * @author MSIrone
 */
public class JastipAlatSport extends PesananJastip {
    // Atribut tambahan khusus subclass ini
    private final double beratBarang; // dalam kg
    private final double komisiTetap;
    private static final double ONGKIR_PER_KG = 5000;
 
    public JastipAlatSport(String idPesanan, String namaBarang, double hargaAsli, int jumlah,
                            String namaPelanggan, double beratBarang) {
        super(idPesanan, namaBarang, hargaAsli, jumlah, namaPelanggan); // memanggil constructor induk
        this.beratBarang = beratBarang;
        this.komisiTetap = 20000; // komisi jasa titip alat sport
    }
 
    public double getBeratBarang() {
        return beratBarang;
    }
 
    public double getKomisiTetap() {
        return komisiTetap;
    }
 
    // Rumus: Harga + Komisi + (Berat Barang * Ongkir Tambahan)
    @Override
    public double hitungTotalBiaya() {
        return (getHargaAsli() * getJumlah()) + komisiTetap + (beratBarang * ONGKIR_PER_KG);
    }
     
}
