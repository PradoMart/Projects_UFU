public class Veiculos {
    private String placa;
    private String modelo;
    private String cor;
    private String cidade;
    private String status;
    private String tipo;//caminhao, carro, moto
    private String dt_manuntencao;

    public Veiculos(String placa, String modelo, String cor){
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        setCidade("Uberlandia"); //sede da empresa como default
        setStatus("Disponivel"); //status default
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public String getStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDt_manuntencao() {
        return dt_manuntencao;
    }

    public void setDt_manuntencao(String dt_manuntencao) {
        this.dt_manuntencao = dt_manuntencao;
    }
}
