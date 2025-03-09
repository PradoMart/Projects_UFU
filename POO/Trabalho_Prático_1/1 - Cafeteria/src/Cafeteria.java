import java.util.ArrayList;
import java.util.Scanner;

public class Cafeteria {
    private ArrayList<Pedido> list_pedidos;
    private Scanner input;
    private Recepcao atendente;
    private Cozinha chef;
    double soma_pedido = 0;

    public Cafeteria(){
        this.list_pedidos = new ArrayList<>();
        this.input = new Scanner(System.in);
        this.chef = new Cozinha();
        this.atendente = new Recepcao();
    }

    public void exibirMenu(){
        int opcao;
        System.out.println("\nSeja bem-vindo à CoffeeShop!");

        do {
            System.out.println("\n------------------- MENU DA CAFETERIA -------------------");
            System.out.println("[1. Exibir Cardápio]  |  [2. Fazer Pedido]  |  [3. Pagar]");

            System.out.print("\nEscolha uma opção: ");
            opcao = input.nextInt(); //Lendo nmr do teclado
            input.nextLine(); //consumir a quebra de linha

            switch (opcao){
                case 1 -> exibirCardapio();
                case 2 -> fazerPedido();
                case 3 -> pagar();
                default -> System.out.println("Digite uma opção válida.");
            }

        }while (true);
    }

    public void exibirCardapio(){
        System.out.println("\n--------- CARDÁPIO ---------");
        System.out.println("[1] Café P ---------> R$4,50");
        System.out.println("[2] Café M ---------> R$8,50");
        System.out.println("[3] Pão de Queijo --> R$2,00");
        System.out.println("[4] Croissant ------> R$7,50");
    }

    public void fazerPedido(){
        boolean verifica = true; //condição do while
        System.out.print("Para iniciar, digite seu nome: ");
        String nome = input.nextLine();

        System.out.println("\nPrimeiro selecione os itens. Depois, para enviar o pedido à cozinha, digite [0]. ");

        while (verifica) {
            System.out.print("Digite o número do item: ");
            int escolha = input.nextInt();
            input.nextLine();

            if (escolha == 0 ){
                // laço for para somar o custo do pedido
                for (Pedido p : list_pedidos){
                    soma_pedido += p.preco;
                }
                atendente.anotarPedido();
                verifica = false; //condição de parada do while
            }else {
                list_pedidos.add(new Pedido(escolha));
            }
        }

        //atraso de 3 segundos no terminal
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        chef.pedidoFeito();
        atendente.entregarPedido(nome);
    }

    public void pagar() {
        if (!list_pedidos.isEmpty()) {
            System.out.println("\nTotal da conta: R$" + soma_pedido);

            System.out.print("Qual seu saldo na carteira? ");
            double saldo = input.nextDouble();

            //verifica saldo disponível e atribui uma ação;
            atendente.lavarPratos(saldo, soma_pedido);
            System.exit(0);
        }
        else {
            System.out.println("Faça um pedido primeiro!");
        }
    }
}
