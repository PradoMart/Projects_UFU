import Animals.*;
import Employees.Biologos;
import Employees.Tratadores;
import Employees.Veterinario;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zoo {

    private ArrayList<Animais> list_animais;
    private Scanner input;

    //dicionários para facilitar a manipulação dos dados inseridos pelo usuário em relação aos tipos de animal,
    // alimentação e habitat
    Map<Integer, String> cl_animal = new HashMap<>();
    Map<Integer, String> cl_alimentacao = new HashMap<>();
    Map<Integer, String> cl_habitat = new HashMap<>();


    public Zoo(){
        this.input = new Scanner(System.in);
        this.list_animais = new ArrayList<>();
    }

    public void mainLogic(){
        System.out.println("\n<-=-  BEM-VINDO AO PARQUE DOS DINOSSAUROS  -=->");
        while (true){
            exibirMenu();
            
            System.out.print("\nO que gostaria de fazer? ");
            int opt = input.nextInt();
            input.nextLine();
            
            if (opt == 5){
                atraso(1500);
                System.out.println("\nVolte sempre ao Parque dos Dinossauros!");
                break;
            } else if (opt == 1) {
                cadastrarAnimal();
            } else if (opt == 2) {
                listarAnimal();
            } else if (opt == 3) {
                listarAnimalHabitat();
            } else if (opt == 4) {
                manutencao();
            } else {
                System.out.println("Digite uma opção válida!");
            }
        }

    }

    public void exibirMenu(){
        System.out.println("\n-=- MENU DE OPÇÕES -=-");
        System.out.println("[1] Cadastrar Animal");
        System.out.println("[2] Listar Animais");
        System.out.println("[3] Listar Animais por Habitat");
        System.out.println("[4] Manutenção");
        System.out.println("[5] Sair");
    }

    //funcao atrasa o terminal
    public void atraso(int mls){
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarAnimal(){
        atraso(1000);
        System.out.print("\nQual a classe do animal? [1 - Mamífero] [2 - Répteis] [3 - Aves] [4 - Anfíbios] : ");
        int classe = input.nextInt();
        input.nextLine();

        //ADD key;value no dict de classe biologica
        cl_animal.put(1, "Mamífero");
        cl_animal.put(2, "Répteis");
        cl_animal.put(3, "Aves");
        cl_animal.put(4, "Anfíbios");

        System.out.print("Agora, digite a qual espécie o animal pertence: ");
        String especie = input.nextLine();

        System.out.print("Qual o tipo da alimentação? [1 - Carnívoro] [2 - Herbívoro] [3 - Onívoro] : ");
        int alimentacao = input.nextInt();
        input.nextLine();

        //ADD key;value no dict de alimentacao
        cl_alimentacao.put(1,"Carnívoro");
        cl_alimentacao.put(2,"Herbívoro");
        cl_alimentacao.put(3,"Onívoro");


        System.out.print("Por fim, qual o habitat do animal? [1 - Aquático] [2 - Floresta] [3 - Deserto] [4 - Polar] : ");
        int habitat = input.nextInt();
        input.nextLine();

        //ADD key;value no dict de habitat
        cl_habitat.put(1,"Aquático");
        cl_habitat.put(2,"Floresta");
        cl_habitat.put(3,"Deserto");
        cl_habitat.put(4,"Polar");

        //add as infos na lista mediante a classe escolhida
        if (classe == 1){
            Mamiferos mamiferos = new Mamiferos(especie, cl_alimentacao.get(alimentacao), cl_habitat.get(habitat));
            list_animais.add(mamiferos);
        } else if (classe == 2) {
            Repteis repteis = new Repteis(especie, cl_alimentacao.get(alimentacao), cl_habitat.get(habitat));
            list_animais.add(repteis);
        }else if (classe == 3){
            Aves aves = new Aves(especie, cl_alimentacao.get(alimentacao), cl_habitat.get(habitat));
            list_animais.add(aves);
        } else if (classe == 4) {
            Anfibios anfibios = new Anfibios(especie, cl_alimentacao.get(alimentacao), cl_habitat.get(habitat));
            list_animais.add(anfibios);
        }else {
            System.out.println("Classe inexistente!");
        }

        atraso(2000);
        System.out.println("\nAnimal cadastrado com sucesso!");
    }

    public void listarAnimal(){
        if (list_animais.isEmpty()){
            System.out.println("\nNão há nenhum animal cadastrado!");
        }else {
            System.out.println("\n-=- LISTAGEM DE ANIMAIS -=-");
            for (Animais a : list_animais){
                System.out.println("CLASSE: " + a.getClasse() + "  |  ESPÉCIE: " + a.getEspecie() + "  |  ALIMENTAÇÃO: "+ a.getAlimentacao() + "  |  HABITAT: " + a.getHabitat());
            }
        }
    }

    public void listarAnimalHabitat(){
        if (list_animais.isEmpty()){
            System.out.println("\nNão há nenhum animal cadastrado!");
        }else {
            System.out.print("\nQual habitat você quer visualizar? [1 - Aquático] [2 - Floresta] [3 - Deserto] [4 - Polar] : ");
            int habitat = input.nextInt();
            input.nextLine();

            System.out.println("\n-=- LISTAGEM DE ANIMAIS NO HABITAT " + cl_habitat.get(habitat).toUpperCase() + " -=-");

            // o contador é pra verificar se ñ tem nenhum animal cadastrado no habitat escolhido
            int cont = 0;
            for (Animais a : list_animais){
                if (a.getHabitat().equalsIgnoreCase(cl_habitat.get(habitat))){
                    System.out.println("CLASSE: " + a.getClasse() + "  |  ESPÉCIE: " + a.getEspecie() + "  |  ALIMENTAÇÃO: "+ a.getAlimentacao() + "  |  HABITAT: " + a.getHabitat());
                    cont++;
                }
            }

            if (cont == 0){
                System.out.println("\nNão há nenhum animal cadastrado!");
            }
        }
    }

    public void manutencao(){
        System.out.print("\nQual o tipo de manutenção? [1 - Completa] [2 - Individual]? ");
        int opt = input.nextInt();
        input.nextLine();

        //instanciando as classes dos funcionários
        Veterinario vet = new Veterinario();
        Tratadores tratadores = new Tratadores();
        Biologos bio = new Biologos();

        if (opt == 1){
            atraso(500);
            System.out.println("\nIniciando Manutenção Completa...");

            atraso(2500);
            System.out.print("\n");
            vet.realizarFuncao(); //realizando a função do vet

            atraso(2500);
            System.out.print("\n");
            tratadores.realizarFuncao(); //realizando a função do tratador

            atraso(2500);
            System.out.print("\n");
            bio.realizarFuncao(); //realizando a funcao do biologo
        }else {
            //condição caso o usuario tenha escolhido a manutenção individual
            System.out.print("\nQual serviço você quer? [1 - Cuidar dos Animais] [2 - Limpar Habitats] [3 - Análise de Adaptação] : ");
            int escolha = input.nextInt();
            input.nextLine();

            if (escolha == 1){
                System.out.print("\n");
                vet.realizarFuncao();
            } else if (escolha == 2) {
                System.out.print("\n");
                tratadores.realizarFuncao();
            } else if (escolha == 3) {
                System.out.print("\n");
                bio.realizarFuncao();
            }else {
                System.out.println("Serviço indisponível!");
            }
        }
    }
}

