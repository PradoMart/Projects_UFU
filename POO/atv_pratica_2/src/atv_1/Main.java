package atv_1;

public class Main {
    public static void main(String[] args){
        Computador pc = new Computador();
        pc.marca = "Lenovo";
        pc.mem_ram = 16;
        pc.armazenamento = 512;

        pc.show_config();
    }
}
