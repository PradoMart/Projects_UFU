public class Pedido {
    protected int pedido;
    protected double preco;

    public Pedido(int pedido){
        this.pedido = pedido;

        //colocando os preços de acordo com o tipo do pedido
        if (pedido == 1){
            this.preco = 4.50;
        } else if (pedido == 2) {
            this.preco = 8.50;
        } else if (pedido == 3) {
            this.preco = 2;
        }else if (pedido == 4){
            this.preco = 7.50;
        }

    }

}
