
public class Paciente {
    protected String nome;
    protected int idade;
    protected String condicao_patologica;
    protected boolean pagamento;

    public Paciente(String nome, int idade, String condicao_patologica, boolean pagamento){
        this.nome = nome;
        this.idade = idade;
        this.condicao_patologica = condicao_patologica;
        this.pagamento = pagamento;
    }
}
