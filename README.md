# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah aplikasi sederhana pengolahan data jasa titip (jastip) perlengkapan sport bernama StyleDrop, menggunakan Java sebagai tugas akhir dari mata kuliah Pemrograman Berbasis Objek 1.

## Deskripsi

Aplikasi ini menerima input berupa data pesanan titipan barang olahraga dari pelanggan (nama pelanggan, nama barang, harga, jumlah, dan berat khusus untuk alat sport), lalu memberikan output berupa struk rincian biaya jastip, termasuk total biaya yang sudah dihitung otomatis serta status pembayarannya (Belum Bayar / Lunas / DP-Kurang).

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Polymorphism, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, PesananJastip, JastipPakaianSport, JastipAlatSport, Pelanggan, dan StyleDrop adalah contoh dari class.

```bash
public abstract class PesananJastip {
    ...
}

public class JastipPakaianSport extends PesananJastip {
    ...
}

public class JastipAlatSport extends PesananJastip {
    ...
}

public class Pelanggan {
    ...
}

public class StyleDrop {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, pesananBaru = new JastipPakaianSport(...) adalah contoh pembuatan object.

```bash
PesananJastip pesananBaru = new JastipPakaianSport(idPesanan, namaBarang, harga, jumlah, namaPelanggan);
daftarPesanan[jumlahPesanan] = pesananBaru;
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, namaBarang, hargaAsli, jumlah, dan statusPembayaran adalah contoh atribut.


```bash
private final String namaBarang;
private final double hargaAsli;
private final int jumlah;
private String statusPembayaran;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class PesananJastip dan diwariskan pemanggilannya lewat super(...) di class anak seperti JastipPakaianSport.

```bash
public PesananJastip(String idPesanan, String namaBarang, double hargaAsli, int jumlah, String namaPelanggan) {
    this.idPesanan = idPesanan;
    this.namaBarang = namaBarang;
    this.hargaAsli = hargaAsli;
    this.jumlah = jumlah;
    this.namaPelanggan = namaPelanggan;
    this.statusPembayaran = "Belum Bayar";
}

public JastipPakaianSport(String idPesanan, String namaBarang, double hargaAsli, int jumlah, String namaPelanggan) {
    super(idPesanan, namaBarang, hargaAsli, jumlah, namaPelanggan);
    this.komisiTetap = 25000;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, setStatusPembayaran adalah contoh method mutator.

```bash
public void setStatusPembayaran(String statusPembayaran) {
    this.statusPembayaran = statusPembayaran;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, getNamaBarang, getHargaAsli, getJumlah, getStatusPembayaran, dan getIdPesanan adalah contoh method accessor.

```bash
public String getNamaBarang() {
    return namaBarang;
}

public double getHargaAsli() {
    return hargaAsli;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, seluruh atribut di PesananJastip (dan class lainnya) dienkapsulasi menjadi private/private final, dan hanya bisa diakses melalui method getter dan setter.

```bash
private final String idPesanan;
private final String namaBarang;
private final double hargaAsli;
private final int jumlah;
private final String namaPelanggan;
private String statusPembayaran;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, JastipPakaianSport dan JastipAlatSport mewarisi PesananJastip dengan sintaks extends.

```bash
public class JastipPakaianSport extends PesananJastip {
    ...
}

public class JastipAlatSport extends PesananJastip {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah method dapat memiliki perilaku berbeda tergantung objek yang memanggilnya (method overriding). Pada kode ini, method abstrak hitungTotalBiaya() dideklarasikan di PesananJastip, lalu diimplementasikan berbeda di setiap class anak: pada JastipPakaianSport hanya dihitung dari harga dan komisi tetap, sedangkan pada JastipAlatSport ditambah lagi dengan biaya ongkir berdasarkan berat barang.

```bash
// Di superclass PesananJastip
public abstract double hitungTotalBiaya();

// Override di JastipPakaianSport
@Override
public double hitungTotalBiaya() {
    return (getHargaAsli() * getJumlah()) + komisiTetap;
}

// Override di JastipAlatSport
@Override
public double hitungTotalBiaya() {
    return (getHargaAsli() * getJumlah()) + komisiTetap + (beratBarang * ONGKIR_PER_KG);
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi if-else dalam method updateStatusPembayaran untuk menentukan status Lunas atau DP/Kurang, dan seleksi switch dalam main untuk menentukan menu yang dijalankan.

```bash
if (totalBayar >= totalBiaya) {
    pesananDicari.setStatusPembayaran("Lunas");
} else {
    pesananDicari.setStatusPembayaran("DP/Kurang");
}

switch (pilihan) {
    case 1 -> tambahPesananPakaian();
    case 2 -> tambahPesananAlat();
    case 3 -> tampilkanSemuaPesanan();
    case 4 -> updateStatusPembayaran();
    case 5 -> System.out.println("Terima kasih telah menggunakan StyleDrop. Sampai jumpa!");
    default -> System.out.println("Pilihan tidak tersedia, silakan coba lagi.");
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop do-while agar menu utama terus tampil sampai pengguna memilih keluar, dan loop for untuk menyisir seluruh data di array pesanan.

```bash
do {
    tampilkanMenu();
    pilihan = bacaPilihanMenu();
    ...
} while (pilihan != 5);

for (int i = 0; i < jumlahPesanan; i++) {
    daftarPesanan[i].cetakStruk();
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class Scanner untuk menerima input dan method System.out.println/System.out.print untuk menampilkan output.

```bash
Scanner scanner = new Scanner(System.in);
System.out.print("Nama Pelanggan               : ");
String namaPelanggan = scanner.nextLine();

System.out.println("Total Biaya  : Rp" + String.format("%,.0f", hitungTotalBiaya()));
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, PesananJastip[] daftarPesanan = new PesananJastip[10]; adalah contoh penggunaan array untuk menampung seluruh objek pesanan.

```bash
private static final PesananJastip[] daftarPesanan = new PesananJastip[10];
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan try-catch untuk menangani InputMismatchException, misalnya saat pengguna salah memasukkan huruf ketika program meminta input angka.

```bash
try {
    double harga = scanner.nextDouble();
    int jumlah = scanner.nextInt();
    ...
} catch (InputMismatchException e) {
    System.out.println("Input harga/jumlah harus berupa angka! Pesanan gagal disimpan.");
    scanner.nextLine();
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: M. Ruziannur
NPM: 2410010352
