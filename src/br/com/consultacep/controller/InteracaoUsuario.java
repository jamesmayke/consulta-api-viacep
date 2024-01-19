package src.br.com.consultacep.controller;

import java.util.Scanner;

public class InteracaoUsuario {
    Scanner scanner = new Scanner(System.in);

    public String comunicacaoCep() {
        System.out.print("Digite o CEP desejado: ");
        String cepInformado = scanner.next();
        return cepInformado;
    }

    public int comunicacaoNumeroCasa() {
        System.out.print("Número da casa: ");
        int numeroCasa = scanner.nextInt();
        return numeroCasa;
    }

    public String comunicacaoBairro() {
        System.out.print("Bairro: ");
        String bairro = scanner.next();
        return bairro;
    }
}
