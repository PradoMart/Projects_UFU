public class Caminhao extends Veiculos{
    public Caminhao(String placa, String modelo, String cor){
        super(placa, modelo, cor); //instanciando as variaveis da classe-mae
        setTipo("Caminhao"); //tipo caminhao p/ classe caminhao
    }
}
