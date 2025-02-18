package atv_5;

public class Computador5 {
    private String marca;
    private int ram;
    private int hd;
    private Processador frequencia;

    Computador5(String marca, int ram, int hd, int frequencia){
        this.marca = marca;
        this.ram = ram;
        this.hd = hd;
        this.frequencia = new Processador(frequencia);
    }

    public void exibirInfo(){
        System.out.println("Marca: " + marca);
        System.out.println("RAM: " + ram + "GB");
        System.out.println("HD: " + hd + "GB");
        System.out.println("Processador: " + frequencia.getFrequencia() + "Ghz");

    }

}
