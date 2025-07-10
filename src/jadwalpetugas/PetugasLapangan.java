package jadwalpetugas;

// Class turunan dari Petugas
public class PetugasLapangan extends Petugas {
    private String wilayahTugas; // Wilayah tugas lapangan
    private Jadwal[] jadwalMingguan = new Jadwal[7]; // Array 7 hari kerja
    private String idPetugas;    // ID unik petugas, misal PTGS001

    // Constructor: memanggil constructor superclass dan menetapkan atribut tambahan
    public PetugasLapangan(String nama, String nik, String wilayahTugas, String idPetugas) {
        super(nama, nik); // memanggil constructor dari class induk
        this.wilayahTugas = wilayahTugas;
        this.idPetugas = idPetugas;
    }

    // Accessor wilayah tugas
    public String getWilayahTugas() {
        return wilayahTugas;
    }

    // Mutator wilayah tugas
    public void setWilayahTugas(String wilayahTugas) {
        this.wilayahTugas = wilayahTugas;
    }

    // Accessor untuk mendapatkan semua jadwal mingguan
    public Jadwal[] getJadwalMingguan() {
        return jadwalMingguan;
    }

    // Mutator untuk mengatur jadwal harian berdasarkan index 0-6
    public void setJadwalHarian(int index, Jadwal j) {
        this.jadwalMingguan[index] = j;
    }

    // Accessor ID petugas
    public String getIdPetugas() {
        return idPetugas;
    }

    // Menampilkan info lengkap petugas
    @Override
    public void tampilkanInfo() {
        System.out.println("ID Petugas   : " + idPetugas);
        super.tampilkanInfo(); // panggil method tampilkanInfo dari class Petugas
        System.out.println("Wilayah Tugas: " + wilayahTugas);
    }
}

