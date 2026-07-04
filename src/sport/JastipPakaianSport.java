/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sport;

/**
 *
 * @author MSIrone
 */
public class JastipPakaianSport extends PesananJastip {
    // Atribut tambahan khusus subclass ini
    private final double komisiTetap;
 
    public JastipPakaianSport(String idPesanan, String namaBarang, double hargaAsli, int jumlah, String namaPelanggan) {
        super(idPesanan, namaBarang, hargaAsli, jumlah, namaPelanggan); // memanggil constructor induk
        this.komisiTetap = 25000; // komisi jasa titip pakaian sport
    }
 
    public double getKomisiTetap() {
        return komisiTetap;
    }
 
    // Rumus: Harga + Komisi Tetap
    @Override
    public double hitungTotalBiaya() {
        return (getHargaAsli() * getJumlah()) + komisiTetap;
    }
}
   
