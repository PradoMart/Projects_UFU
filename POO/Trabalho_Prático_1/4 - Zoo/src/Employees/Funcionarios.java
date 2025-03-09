package Employees;

public class Funcionarios {
    private String cargo;
    private String responsabilidade;


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getResponsabilidade() {
        return responsabilidade;
    }

    public void setResponsabilidade(String responsabilidade) {
        this.responsabilidade = responsabilidade;
    }

    public void realizarFuncao(){
        System.out.println(cargo + " está realizando a função: " + getResponsabilidade().toUpperCase());
    }
}
