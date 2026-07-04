/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sport;

/**
 *
 * @author MSIrone
 */
public class Pelanggan {
    private final String idPelanggan;
    private final String namaPelanggan;
    private final String noHp;
 
    // Constructor
    public Pelanggan(String idPelanggan, String namaPelanggan, String noHp) {
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.noHp = noHp;
    }
 
    // Accessor (Getter)
    public String getIdPelanggan() {
        return idPelanggan;
    }
 
    public String getNamaPelanggan() {
        return namaPelanggan;
    }
 
    public String getNoHp() {
        return noHp;
    }
}
