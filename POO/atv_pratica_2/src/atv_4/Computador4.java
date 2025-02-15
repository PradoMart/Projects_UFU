package atv_4;

public class Computador4 {

    private String marca;
    private int ram;
    private int hd;

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setRam(int ram) {
        if(ram > 0){
            this.ram = ram;
        }else {
            System.out.println("ERRO - RAM inválida!");
        }
    }

    public void setHd(int hd) {
        if(ram > 0){
            this.hd = hd;
        }else {
            System.out.println("ERRO - HD inválida!");
        }
    }

    public int getRam() {
        return ram;
    }

    public int getHd(){
        return hd;
    }

    public String getMarca() {
        return marca;
    }

    public void exibeInfo(){
        System.out.println("Marca: " + getMarca() + "\nRAM: " + getRam() + "\nHD: "+ getHd());
    }
}
