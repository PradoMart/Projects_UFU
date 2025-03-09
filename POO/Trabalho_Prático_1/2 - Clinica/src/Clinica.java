import java.util.Scanner;
import java.util.ArrayList;

public class Clinica {
    protected String nome;
    private Scanner input;
    protected double custo;
    private ArrayList<Procedimentos> list_prcd;

    public Clinica(){
        this.input = new Scanner(System.in);
        this.list_prcd = new ArrayList<>();
    }

    public void exibirMenu(){
        System.out.print("\n<-=-=- Seja bem-vinda à Clínica Bem-Estar -=-=->\nPara iniciar, digite seu nome: ");
        nome = input.nextLine();

        System.out.print("\n"+ nome + ", vamos agendar sua consulta de avaliação? [Digite S ou N]: ");
        String option = input.nextLine();

        if (option.equalsIgnoreCase("S")){
            //Pagamento da consulta de avaliação e cadastro de infos paciente
            System.out.print("A consulta de avaliação custa R$250,00 podemos cobrar o valor? [Digite S ou N]: ");
            String opt_consulta = input.nextLine();

            //verifica autorização de pagamento e segue para a consulta de avaliação
            if (opt_consulta.equalsIgnoreCase("S")){
                custo += 250;
                boolean status_pgto = true;
                consultaAvaliacao(status_pgto);

                atraso(1500);

                //seguindo a jornada da paciente apresentando os outros procedimentos e realizando-os
                exibirServicos();
                realizandoServicos();

            }else {
                System.out.println("Trabalhamos apenas com pagamento antecipado!");
            }

        }else {
            //condição negativa p/ caso a paciente ñ queira agendar a consulta avaliativa.
            System.out.println("Até a próxima, " + nome + "!");
            System.exit(0);
        }
    }

    public void consultaAvaliacao(boolean status_pgto){
        if (status_pgto){
            System.out.println("\nAntes de iniciarmos, precisamos de algumas informações pessoais.");

            System.out.print("\nQual sua idade? ");
            int idade = input.nextInt();
            input.nextLine(); //limpando buffer

            System.out.print("Possui alguma condição patológica? [Digite S ou N]: ");
            String condicao = input.nextLine();

            if (condicao.equalsIgnoreCase("s")){
                System.out.print("Descreva a condição patólogica: ");
                String descricao_condicao = input.nextLine();
            }

            //add as infos passadas na classe paciente
            Paciente pac = new Paciente(nome, idade, condicao, status_pgto);

        }else {
            System.out.println("O pagamento ainda não foi realizada!");
        }
    }

    public void exibirServicos(){
        System.out.println("\n<-- Serviços de Embelezamento -->");
        System.out.println("[1] Rinoplastia -----> R$4.700,00");
        System.out.println("[2] Botox -----------> R$  600,00");
        System.out.println("[3] Lipoaspiração ---> R$6.000,00");
        System.out.println("<----- Digite 0 para sair! ----->");
    }

    public void realizandoServicos(){
        System.out.println("\n"+ nome + ", o que faremos hoje? ");
        double custo = 0; //declarando variavel custo que servirá p/ somar o total dos procedimentos

        //usando while para caso a paciente queira realizar +1 procedimento
        while (true){
            System.out.print("Selecione o procedimento: ");
            int opt_servico = input.nextInt();
            input.nextLine();

            if (opt_servico == 0){
                //usando o for para percorrer a lista dos procedimentos escolhidos e somar o custo deles
                for (Procedimentos p : list_prcd){
                    custo += p.valor;
                }
                break;
            }

            //add os procedimentos escolhidos na lista
            list_prcd.add(new Procedimentos(opt_servico));
        }

        //verificando se a lista de procedimentos ñ está vazia p/ seguir com o pagamento e realização
        if (!list_prcd.isEmpty()){
            System.out.print(nome + ", você autoriza a cobrança de R$" + custo +" referente ao(s) procedimento(s)? " +
                    "[Digite S ou N] ");
            String opt = input.nextLine();

            //verificando a positividade da cobrança
            if (opt.equalsIgnoreCase("s")){
                System.out.println("\nMARAVILHA! Sendo assim, vamos embelezar!");

                //usando a função atraso, que retarda o terminal.
                atraso(1000);
                System.out.println("Preparando a sala...");

                for (Procedimentos p : list_prcd){
                    atraso(2500);
                    System.out.print("\nO procedimento " + p.nome.toUpperCase() + " está sendo executado.");
                }

                atraso(2500);
                System.out.println("\nProcedimento(s) realizado(s) com sucesso!");

                //função de agendamento de retorno, ñ permite o paciente sair sem marcar
                agendandoRetorno();

            }else {
                System.out.println("Trabalhamos apenas com pagamento antecipado!");
            }

        }else { //condição quando a lista está vazia
            System.out.println("\nNenhum procedimento selecionado!");
        }

    }

    //função p/ atrasar o terminal
    public void atraso(int mls){
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void agendandoRetorno(){
        //função p/ atrasar o terminal
        atraso(3000);

        System.out.println("\n" + nome+ ", antes de ir, precisamos marcar seu retorno. ");
        System.out.print("[A] 7 dias  |  [B] 10 dias  |  [C] 15 dias  --  Qual a melhor opção? ");
        String dt_retorno = input.nextLine();

        //loop p/ ñ deixar a paciente sair sem selecionar alguma das opções de retorno
        while (! (dt_retorno.equalsIgnoreCase("a") || dt_retorno.equalsIgnoreCase("b") || dt_retorno.equalsIgnoreCase(
                "c"))){
            System.out.println("\nPrecisamos deixar agendado. É uma recomendação médica!");

            System.out.print("[A] 7 dias  |  [B] 10 dias  |  [C] 15 dias  --  Qual a melhor opção? ");
            dt_retorno = input.nextLine();
        }

        atraso(2000);

        System.out.println("\nRetorno agendado! Nos vemos em breve, " + nome + ".\nA clínica Bem-Estar agradece a " +
                "preferência!");

    }
}
