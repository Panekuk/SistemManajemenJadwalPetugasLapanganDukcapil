package jadwalpetugas;

// Class untuk merepresentasikan jadwal harian petugas
public class Jadwal {
    private String hari;      // Hari kerja (Senin-Minggu)
    private String kegiatan;  // Deskripsi kegiatan

    // Constructor: membuat objek Jadwal
    public Jadwal(String hari, String kegiatan) {
        this.hari = hari;
        this.kegiatan = kegiatan;
    }

    // Accessor: Mengambil nilai hari
    public String getHari() {
        return hari;
    }

    // Mutator: Mengatur nilai hari
    public void setHari(String hari) {
        this.hari = hari;
    }

    // Accessor: Mengambil nilai kegiatan
    public String getKegiatan() {
        return kegiatan;
    }

    // Mutator: Mengatur nilai kegiatan
    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    // Menampilkan informasi jadwal di satu hari
    public void tampilkanJadwal() {
        System.out.println(hari + ": " + kegiatan);
    }
}

