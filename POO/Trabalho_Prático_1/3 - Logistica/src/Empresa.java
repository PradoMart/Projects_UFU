import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {

    private ArrayList<Veiculos> list_veiculos;
    private ArrayList<Motorista> list_motorista;
    private Scanner input;

    public Empresa(){
        this.list_veiculos = new ArrayList<>();
        this.list_motorista = new ArrayList<>();
        this.input = new Scanner(System.in);
    }

    public void logicSystem(){
        while (true){
            exibirMenu();

            System.out.print("\nO que deseja fazer? ");
            int opt = input.nextInt();
            input.nextLine();

            //logica do sistema, retornando as funções a partir da escolha do usuário
            if (opt == 1){
                cadastrarVeiculo();
            } else if (opt == 2) {
                cadastrarMotorista();
            } else if (opt == 3) {
                manutencao();
            } else if (opt == 4) {
                deslocarVeiculo();
            } else if (opt == 5) {
                listarFrota();
            } else if (opt == 6) {
                listarFrotaCidade();
            } else if (opt == 7) {
                rastrearVeiculo();
            } else if (opt == 0) {
                saindo();
                break;
            }else {
                System.out.println("Digite uma opção válida!");
            }
        }

    }

    public void exibirMenu(){
        System.out.println("\n<-=-=- MENU FROTA AGOSTINHO -=-=->");
        System.out.println("[1] Cadastrar Veículo");
        System.out.println("[2] Cadastrar Motorista");
        System.out.println("[3] Manuntenção de Veículo");
        System.out.println("[4] Deslocar Veículo");
        System.out.println("[5] Listar Frota");
        System.out.println("[6] Listar Frota em Cidade");
        System.out.println("[7] Rastrear Veículo");
        System.out.println("[0] Sair");
        System.out.println("<-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=->");
    }

    //funcao atrasar terminal
    public void atraso(int mls){
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void saindo(){
        atraso(1500);
        System.out.println("\nSaindo do sistema...");
        atraso(1000);
        System.exit(0);
    }

    public void cadastrarVeiculo(){
        int opt;

        //loop p/ garantir que usuario preencha o nmr correto referente ao veiculo
        while (true){
            System.out.print("\nQual tipo do Veículo? [1. Caminhao] [2. Carro] [3. Moto] : ");
            opt = input.nextInt();
            input.nextLine();

            if (opt == 1 || opt == 2 || opt == 3) {
                break;
            }
        }

        //coletando as infos do veiculo
        System.out.print("\nDigite a placa: ");
        String placa = input.nextLine();

        System.out.print("Digite o modelo: ");
        String modelo = input.nextLine();

        System.out.print("Digite a cor: ");
        String cor = input.nextLine();

        //cadastramento, a partir do TIPO do veiculo
        if (opt == 1){
            //caminhao
            atraso(500);
            list_veiculos.add(new Caminhao(placa, modelo, cor));
            atraso(500);
            System.out.println("\nCadastrando Caminhao...");
            atraso(1000);

        } else if (opt == 2) {
            //carro
            atraso(500);
            list_veiculos.add(new Carro(placa, modelo, cor));
            atraso(500);
            System.out.println("\nCadastrando Carro...");
            atraso(1000);

        } else {
            //moto
            atraso(500);
            list_veiculos.add(new Moto(placa, modelo, cor));
            atraso(500);
            System.out.println("\nCadastrando Moto...");
            atraso(1000);
        }

    }

    public void cadastrarMotorista(){
        atraso(500);
        System.out.print("\nNome: ");
        String nome = input.nextLine();

        System.out.print("CPF: ");
        String cpf = input.nextLine();

        System.out.print("Categoria CNH: ");
        String cate_cnh = input.nextLine().toUpperCase();

        list_motorista.add(new Motorista(nome, cpf, cate_cnh));

        atraso(500);
        System.out.println("\nCadastrando Motorista!");
        atraso(1000);
    }

    public void listarFrota(){
        atraso(500);
        System.out.println("\n-=- LISTANDO VEÍCULOS DA FROTA -=-");
        atraso(1000);

        //loop na lista de veiculos, exibindo com a máscara: (VEICULO | PLACA | CIDADE | STATUS)
        for (Veiculos v : list_veiculos){
            System.out.println("VEÍCULO: " + v.getTipo() + " - "+ v.getModelo() + "  |  PLACA: " + v.getPlaca() + "  |  " +
                    "CIDADE: " + v.getCidade() + "  |  " + "STATUS: " + v.getStatus());
            //atrasando exibição a cada item
            atraso(500);
        }
        atraso(500);
        System.out.println("-=-   FROTA COMPLETA LISTADA   -=-");
    }

    public void listarFrotaCidade(){
        atraso(500);

        System.out.print("Qual cidade quer analisar? ");
        String cidade = input.nextLine();

        System.out.println("\n-=- LISTANDO VEÍCULOS DA FROTA  EM " + cidade.toUpperCase() + " -=-");
        atraso(1000);

        //contador usado na hipotese de não haver o veiculo digitado
        int cont =0;

        for (Veiculos v : list_veiculos){
            //verificação p/ mostrar veiculos apenas da cidade escolhida
            if (v.getCidade().equalsIgnoreCase(cidade)){
                System.out.println("VEÍCULO: " + v.getTipo() + " - "+ v.getModelo() + "  |  PLACA: " + v.getPlaca() + "  |  " +
                        "CIDADE: " + v.getCidade() + "  |  " + "STATUS: " + v.getStatus());
                atraso(500);
                cont++;
            }
        }

        //retornos diferentes caso haja veiculo compativel com a cidade digitada
        atraso(500);
        if (cont == 0){
            System.out.println("Nenhum veículo cadastrado na cidade!");
        }
        else {
            System.out.println("-=-=-=-=-  FROTA LISTADA  -=-=-=-=-");
        }
    }

    public void rastrearVeiculo(){
        atraso(500);

        System.out.print("Digite a placa do veículo? ");
        String placa = input.nextLine();

        System.out.println("\n-=- RASTREANDO VEÍCULO -=-");
        atraso(1000);

        //contador usado na hipotese de não haver o veiculo digitado
        int cont =0;

        for (Veiculos v : list_veiculos){
            //verificaçã para listar apenas o veiculo solicitado
            if (v.getPlaca().equalsIgnoreCase(placa)){
                System.out.println("VEÍCULO: " + v.getTipo() + " - "+ v.getModelo() + "  |  PLACA: " + v.getPlaca() + "  |  " +
                        "CIDADE: " + v.getCidade() + "  |  " + "STATUS: " + v.getStatus());
                atraso(500);
                cont++;
            }

        }

        //retornos diferentes caso haja veiculo compativel com a placa digitada
        atraso(500);
        if (cont ==0){
            System.out.println("Veículo não encontrado!");
        }else {
            System.out.println("-=-=-=-=-  RASTREAMENTO CONCLUÍDO  -=-=-=-=-");
        }
    }

    public void manutencao(){
        if (list_veiculos.isEmpty()){
            System.out.println("Não tem veículos cadastrados!");
        }else {
            System.out.println("\n-=- OFICINA DO AGOSTINHO -=-");

            System.out.print("Gostaria de visualizar a frota antes? [S ou N]: ");
            String opt = input.nextLine();

            //opção de visualizar a frota antes de enviar o veiculo p/ manutenção (objetivo: anotar a placa)
            if (opt.equalsIgnoreCase("S")){
                listarFrota();
            }

            System.out.print("\nDigite a placa do veículo que entrará em manutenção: ");
            String placa = input.nextLine();

            int cont =0;

            for (Veiculos v : list_veiculos){
                //verificando se item da lista tem a mesma placa digitiada
                if (v.getPlaca().equalsIgnoreCase(placa)){
                    //verificando se veiculo tá disponivel p/ entrar em manutenção.
                    // Se já estiver em manutenção, é possível retirá-lo.
                    if (v.getStatus().equalsIgnoreCase("Disponivel")){
                        System.out.print("Digite a data da manutenção [DD/MM/AAAA]: ");
                        String dt_manutencao = input.nextLine();

                        //alterando o status do veiculo e a data de manutenção
                        v.setStatus("Na Oficina");
                        v.setDt_manuntencao(dt_manutencao);
                        atraso(1000);
                        System.out.println("\nVeículo: " + v.getTipo() + " - " + v.getModelo() + " está " + v.getStatus() + ".");
                        cont++;

                    }else if (v.getStatus().equalsIgnoreCase("Na Oficina")){
                        //caso o veiculo já esteja na oficina, possibilidade de retirá-lo
                        System.out.print("Gostaria de retirar o veículo da Oficina? [S ou N]: ");
                        String retirar = input.nextLine();

                        if (retirar.equalsIgnoreCase("s")){
                            v.setStatus("Disponivel");
                            atraso(1000);
                            System.out.println("\nVeículo: " + v.getTipo() + " - " + v.getModelo() + " está " + v.getStatus() + ".");
                        }else {
                            atraso(1000);
                            System.out.println("\nVeículo: " + v.getTipo() + " - " + v.getModelo() + " continua " + v.getStatus() + ".");
                        }
                        cont++;

                    }else{
                        //ultima condição do status do veiculo, que é em transito.
                        System.out.println("\nO veículo está Em Transito, não é possível fazer manutenção.");
                        cont++;
                    }
                }
            }

            if (cont == 0){
                System.out.println("\nVeículo não encontrado!");
            }
        }
    }

    public void deslocarVeiculo(){
        if (list_motorista.isEmpty()){
            System.out.println("\nCadastre um motorista antes de deslocar a frota!");
        }else {
            if (list_veiculos.isEmpty()) {
                System.out.println("\nCadastre um veículo antes de deslocar a frota!");
            }else {
                System.out.println("\n-=- GESTÃO LOGÍSTICA DO AGOSTINHO -=-");
                atraso(1000);

                //possibilidade de visualizar a frota antes de escolher qual veiculo deslocar
                System.out.print("Quer visualizar a frota? [S ou N]: ");
                String frota = input.nextLine();

                if (frota.equalsIgnoreCase("s")){
                    listarFrota();
                }

                System.out.print("\nDigite a placa do veículo que será usado no transporte: ");
                String placa = input.nextLine();

                for (Veiculos v : list_veiculos){
                    if (v.getPlaca().equalsIgnoreCase(placa)){

                        //retorno caso o veiculo esteja na oficina
                        if (v.getStatus().equalsIgnoreCase("Na Oficina")){
                            System.out.println("\nVeículo indisponível no momento! ");
                            break;
                        } else if (v.getStatus().equalsIgnoreCase("Em Transito")) {
                            //possibilidade de concluir a viagem, deixando veiculo e motorista disponiveis
                            System.out.print("\nGostaria de concluir a viagem? [S ou N]");
                            String fim_viagem = input.nextLine();
                            if (fim_viagem.equalsIgnoreCase("s")){
                                atraso(2000);
                                System.out.println("\nVeículo retornou de viagem e já está disponível");

                                v.setStatus("Disponivel");

                                atraso(1500);
                                System.out.print("\nDigite o nome do motorista que estava conduzindo o veículo: ");
                                String nome_motorista = input.nextLine();

                                for (Motorista m : list_motorista){
                                    if (m.getNome().equalsIgnoreCase(nome_motorista)){
                                        m.setStatus("Disponivel");
                                        atraso(1500);
                                        System.out.println("\nMotorista disponível!");
                                    }
                                }
                            }else {
                                atraso(2000);
                                System.out.println("\nViagem continua em andamento!");
                            }
                        } else{
                            System.out.println("\n-=- LISTA DE MOTORISTAS -=-");

                            //listando os motoristas
                            for (Motorista m : list_motorista){
                                System.out.println("MOTORISTA: " + m.getNome() + "  |  CATEGORIA: " + m.getCategoria_cnh() + "  |" +
                                        "  STATUS: " + m.getStatus());
                                atraso(500);
                            }

                            System.out.print("\nDigite o nome de quem conduzirá o veículo " + v.getModelo() + " na viagem: ");
                            String nome = input.nextLine();

                            for (Motorista m : list_motorista){
                                if (m.getNome().equalsIgnoreCase(nome)){
                                    //Verificando se o motorista está disponível
                                    if (!m.getStatus().equalsIgnoreCase("Disponivel")){
                                        System.out.println("\nMotorista indisponível no momento!");
                                        break;
                                    }

                                    //verificando se a categoria do motorista permite dirigir o veículo selecionado. (Usando Map)
                                    if (v.getTipo().equalsIgnoreCase(m.getVeiculo_cnh().get(m.getCategoria_cnh()))){
                                        System.out.print("Para qual cidade: ");
                                        String cidade = input.nextLine();

                                        atraso(1500);
                                        System.out.println("\nMOTORISTA: " + m.getNome() + " escalado a conduzir o VEÍCULO: " + v.getModelo() + " para a cidade de: " + cidade + ".");

                                        //alterando o status do motorista e do veiculo e a cidade do veiculo
                                        m.setStatus("Em Transito");
                                        v.setStatus("Em Transito");
                                        v.setCidade(cidade);
                                    }else {
                                        System.out.println("\nEsse motorista não tem a habilitação requerida para conduzir o " +
                                                "veículo!");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
