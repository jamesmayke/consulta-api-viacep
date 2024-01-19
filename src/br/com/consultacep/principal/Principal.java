package src.br.com.consultacep.principal;

import src.br.com.consultacep.controller.BuscaCep;
import src.br.com.consultacep.controller.InteracaoUsuario;
import src.br.com.consultacep.model.Cep;
import src.br.com.consultacep.model.EstruturaCep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        BuscaCep buscaCep = new BuscaCep();
        InteracaoUsuario usuario = new InteracaoUsuario();

        String cepInformado = usuario.comunicacaoCep();
        int numeroCasa = usuario.comunicacaoNumeroCasa();
        String bairro = usuario.comunicacaoBairro();

        String resultadoJson = buscaCep.buscaViaCep(cepInformado);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        EstruturaCep estrutura = gson.fromJson(resultadoJson, EstruturaCep.class);
        Cep cep = new Cep(estrutura, numeroCasa, bairro);

        try {
            FileWriter arquivo = new FileWriter(estrutura.cep() + ".json");
            arquivo.write(gson.toJson(cep));
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Não consegui gerar o arquivo");
        }
    }
}
