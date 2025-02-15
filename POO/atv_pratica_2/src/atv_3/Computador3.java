package atv_3;

public class Computador3 {
    private String marca;
    private int mem_ram;
    private int armazenamento;

    Computador3(String marca, int mem_ram, int armazenamento){
        this.marca = marca;
        this.mem_ram = mem_ram;
        this.armazenamento = armazenamento;
    }

    public void exibeInfo(){
        System.out.println("Marca: " + marca + "\nRAM: " + mem_ram + "\nARMAZENAMENTO: " + armazenamento);
    }
}
