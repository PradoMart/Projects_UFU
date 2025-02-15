package atv_1;

public class Computador {
    String marca;
    int mem_ram;
    int armazenamento;

    void show_config(){
        System.out.println("Marca: "+ marca + "\nRAM: " + mem_ram + "GB\nArmazenamento: " + armazenamento + "GB");
    }
}
