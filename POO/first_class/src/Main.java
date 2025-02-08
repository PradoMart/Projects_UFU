public class Main {
    public static void main(String[] args){
        Cachorro dog1 = new Cachorro();
        Cachorro dog2 = new Cachorro();

        Pessoa tutor1 = new Pessoa();

        tutor1.nome = "José Carlos";

        dog1.nome = "Maradona";
        dog1.idade = 4;
        dog1.raca = "Salsicha";
        dog1.cor = "Marrom";
        dog1.peso = 10.8;
        dog2.peso = 15.9;

        int idadeDog= dog1.mostraIdade();
        System.out.println("O dog tem " + idadeDog + " anos. E pesa " + tutor1.mostraPeso(dog1) + " kilos.");
        System.out.println("O dog tem " + idadeDog + " anos. E pesa " + tutor1.mostraPeso(dog2) + " kilos.");

        dog1.latir();

    }
}
