package atv_2;

public class Computador2 {
    private String marca;
    private int mem_ram;
    private int armazenamento;

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMem_ram(int mem_ram) {
        this.mem_ram = mem_ram;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void show_config(){
        System.out.println("Marca: "+ marca + "\nRAM: " + mem_ram + "GB\nArmazenamento: " + armazenamento + "GB");
    }
}