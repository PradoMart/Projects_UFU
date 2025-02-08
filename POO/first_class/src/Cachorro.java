public class Cachorro {
    String nome;
    String raca;
    int idade;
    double peso;
    String cor;

    int mostraIdade(){
        return idade;
    }

    double mostraPeso(){
        return peso;
    }

    void latir(){
        System.out.println("Au au!!");
    }
}
