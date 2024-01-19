package src.br.com.consultacep.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCep {
    public String buscaViaCep(String endereco) {
        String json = "";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://viacep.com.br/ws/"+endereco+"/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro na busca.");
        }

        return json;
    }
}
