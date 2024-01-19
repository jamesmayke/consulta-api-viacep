package src.br.com.consultacep.model;

public class Cep {

    private final String cep;
    private final int numeroCasa;
    private final String bairro;
    private final String localidade;
    private final String uf;

    public Cep(EstruturaCep estruturaCep, int numeroCasa, String bairro) {
        this.cep = estruturaCep.cep();
        this.localidade = estruturaCep.localidade();
        this.uf = estruturaCep.uf();

        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return  "Cep = " + cep +
                "Numero = " + numeroCasa +
                "Bairro = " + bairro +
                "Localidade = " + localidade +
                "UF = " + uf;
    }
}
