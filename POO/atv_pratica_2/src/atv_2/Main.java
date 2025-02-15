package atv_2;

public class Main {
    public static void main(String[] args){
        Computador2 pc = new Computador2();
        pc.setMarca("Samsung");
        pc.setMem_ram(8);
        pc.setArmazenamento(512);

        pc.show_config();
    }
}

