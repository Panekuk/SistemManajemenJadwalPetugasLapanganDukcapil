package jadwalpetugas;
public class Petugas {
    //private : encapsulation-hanya bisa diakses dari dalam class ini
    private String nama;  //atribut nama dan nik 
    private String nik;

    //Constructor 
    public Petugas(String nama, String nik) {
        this.nama = nama;
        this.nik = nik;
    }
    //this. nama mengacu pada atribut class
        //  nama (tanpa this) adalah parameter.
    
    // Accessor (Getter): mengambil/membaca nilai atribut dari luar class
    public String getNama() {
        return nama;
    }
    public String getNik() {
        return nik;
    }
    
    //Mutator (Setter) :  Digunakan untuk mengubah nilai atribut nama dan nik dari luar class.
    public void setNama(String nama) {
        this.nama = nama;
    }
        public void setNik(String nik) {
        this.nik = nik;
    }

    //Method :Menampilkan informasi petugas ke layar.
    public void tampilkanInfo() {
        System.out.println("Nama Petugas: " + nama);
        System.out.println("NIK Petugas : " + nik);
    }
}



