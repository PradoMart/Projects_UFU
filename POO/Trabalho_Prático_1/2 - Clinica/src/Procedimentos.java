public class Procedimentos {
    protected int id;
    protected String nome;
    protected double valor;

    public Procedimentos(int id) {
        this.id = id;

        //associando o procedimento ao valor
        if (id == 1){
            this.nome = "Rinoplastia";
            this.valor = 4700;
        } else if (id == 2) {
            this.nome = "Botox";
            this.valor = 600;
        } else {
            this.nome = "Lipoaspiração";
            this.valor = 6000;
        }
    }
}
