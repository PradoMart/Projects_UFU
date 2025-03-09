package Animals;

public class Animais {
    private String classe;
    private String especie;
    private String alimentacao;
    private String habitat;

    public Animais(String especie, String alimentacao, String habitat){
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.habitat = habitat;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}
