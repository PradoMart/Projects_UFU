//importando lib p/ fazer dicionários
import java.util.HashMap;
import java.util.Map;

public class Motorista {
    private String nome;
    private String cpf;
    private String categoria_cnh;
    private String status;

    //instanciando dicionario
    Map<String, String> veiculo_cnh = new HashMap<>();

    public Motorista(String nome, String cpf, String categoria_cnh){
        this.nome = nome;
        this.cpf = cpf;
        this.categoria_cnh = categoria_cnh;
        setStatus("Disponivel"); //status do motorista como default

        //add o tipo de veiculo q pode conduzir a partir da categoria_cnh
        veiculo_cnh.put("C", "Caminhao");
        veiculo_cnh.put("B", "Carro");
        veiculo_cnh.put("A", "Moto");
        veiculo_cnh.put("E", "Caminhao");
    }

    public String getStatus() {
        return status;
    }

    public Map<String, String> getVeiculo_cnh() {
        return veiculo_cnh;
    }

    public void setVeiculo_cnh(Map<String, String> veiculo_cnh) {
        this.veiculo_cnh = veiculo_cnh;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCategoria_cnh() {
        return categoria_cnh;
    }

    public void setCategoria_cnh(String categoria_cnh) {
        this.categoria_cnh = categoria_cnh;
    }

}
