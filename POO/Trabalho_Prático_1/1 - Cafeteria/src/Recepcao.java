public class Recepcao{

    public void anotarPedido(){
        System.out.println("\nSeu pedido foi enviado à cozinha, agora é só aguardar!");
    }

    public void entregarPedido(String nome){
        System.out.println("\nAqui está seu pedido, " +nome + ". Bom apetite!");
    }

    public void lavarPratos(double saldo, double preco){
        if (saldo < preco){
            System.out.println("\nSaldo insuficiente! Por favor, me acompanhe até a cozinha.");

            //atraso de 2,5 segundos no terminal
            try{
                Thread.sleep(2500);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            System.out.println("\nPara pagar sua conta, aqui está a pilha de pratos sujos!");

            //atraso de 3,5 segundos no terminal
            try{
                Thread.sleep(3500);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        } else if (saldo > preco) {
            double troco = saldo - preco;
            System.out.println("\nAgradecemos a presença! Aqui está seu troco: R$" + troco);
        }else {
            System.out.println("\nAgradecemos a presença!");
        }

        System.out.println("\nTchau, tchau. Volte sempre!");
    }
}
