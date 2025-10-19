# Proyek Akhir Pemrograman Berbasis Objek 1
Ita Khairati_2310010219_4BNR_PBO1

Proyek ini adalah contoh sederhana aplikasi **Sistem Manajemen Jadwal Petugas Lapangan Dukcapil** menggunakan Java sebagai tugas akhir dari mata kuliah Pemrograman Berbasis Objek 1.

## Deskripsi

Aplikasi ini digunakan untuk mencatat jadwal mingguan petugas lapangan Dukcapil, misalnya untuk perekaman KTP elektronik lansia/difabel. Data yang dicatat meliputi: **nama petugas**, **NIK**, **wilayah tugas**, dan **jadwal kegiatan mingguan**.

Aplikasi ini membantu mempermudah pengaturan jadwal dan mendeteksi kemungkinan konflik jadwal antar hari. Aplikasi ini mengimplementasikan konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Constructor, Mutator, Accessor, Encapsulation, Inheritance, Polymorphism (Overriding), Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

---

## Penjelasan Kode

### 1. Class

```java
class Petugas { ... }
class PetugasLapangan extends Petugas { ... }
class Jadwal { ... }
public class PetugasBeraksi { ... }
```

### 2. Object

```java
PetugasLapangan petugas = new PetugasLapangan(nama, nik, wilayah, idPetugas);
```

### 3. Atribut

```java
private String nama;
private String nik;
private String wilayahTugas;
```

### 4. Constructor

```java
public Petugas(String nama, String nik) {
    this.nama = nama;
    this.nik = nik;
}
```

### 5. Mutator (Setter)

```java
public void setNama(String nama) {
    this.nama = nama;
}
```

### 6. Accessor (Getter)

```java
public String getNama() {
    return nama;
}
```

### 7. Encapsulation

Atribut diset sebagai `private`, hanya dapat diakses melalui getter/setter:

```java
private String kegiatan;
```

### 8. Inheritance

```java
class PetugasLapangan extends Petugas {
    ...
}
```

### 9. Polymorphism (Overriding)

```java
@Override
public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.println("Wilayah Tugas: " + wilayahTugas);
}
```

### 10. Seleksi

```java
if (kegiatan.isEmpty()) {
    kegiatan = "Libur / Tidak Ada Tugas";
}
```

### 11. Perulangan

```java
for (int i = 0; i < hari.length; i++) {
    System.out.print("Kegiatan hari " + hari[i] + ": ");
}
```

### 12. IO Sederhana

```java
Scanner input = new Scanner(System.in);
System.out.println("Masukkan nama petugas: ");
```

### 13. Array

```java
Jadwal[] jadwalMingguan = new Jadwal[7];
```

### 14. Error Handling

```java
try {
    // Menampilkan info petugas dan jadwal
} catch (Exception e) {
    System.out.println("Terjadi kesalahan: " + e.getMessage());
}
```

---

## Contoh Output (Cuplikan)

```
=== SISTEM JADWAL PETUGAS DUKCAPIL ===
Masukkan nama petugas: Ita Khairati
Masukkan NIK petugas : 1234567890123456
Masukkan wilayah tugas: Banjarmasin

Kegiatan hari Senin: Perekaman KTP Lansia
Kegiatan hari Selasa: Perekaman KTP Difabel
...
```

---

## Usulan Penilaian

| No | Materi             | Nilai |
|----|--------------------|-------|
| 1  | Class              | 5     |
| 2  | Object             | 5     |
| 3  | Atribut            | 5     |
| 4  | Constructor        | 5     |
| 5  | Mutator            | 5     |
| 6  | Accessor           | 5     |
| 7  | Encapsulation      | 5     |
| 8  | Inheritance        | 5     |
| 9  | Polymorphism       | 10    |
| 10 | Seleksi            | 5     |
| 11 | Perulangan         | 5     |
| 12 | IO Sederhana       | 10    |
| 13 | Array              | 15    |
| 14 | Error Handling     | 15    |
|    | **TOTAL**          | **100**|

---

## Pembuat

**Nama**  : Ita Khairati  
**NPM**   : 2310010219  
**Kelas** : 4BNR_PBO1
