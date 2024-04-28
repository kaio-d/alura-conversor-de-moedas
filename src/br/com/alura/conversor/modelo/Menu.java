package br.com.alura.conversor.modelo;

import br.com.alura.conversor.servico.ConversorApi;

import java.util.Scanner;

public class Menu {
    public void exibirOperacoes(){
        Scanner scanner = new Scanner(System.in);
        int selecionarOperacao;
        String menu = """
                ******************************************
                Selecione a opção que deseja realizar:
                1 - Dólar X Peso Argentino
                2 - Peso Argentino X Dólar
                3 - Dólar X Real Brasileiro
                4 - Real Brasileiro X Dólar
                5 - Dólar X Peso Colombiano
                6 - Peso colombiano X Dólar
                7 - Sair
                ******************************************
                """;

        do {
            System.out.println(menu);
            selecionarOperacao = scanner.nextInt();

            if (selecionarOperacao == 1){
                ConversorApi.converterMoeda("USD", "ARS", scanner);
            } else if (selecionarOperacao == 2) {
                ConversorApi.converterMoeda("ARS", "USD", scanner);
            } else if (selecionarOperacao == 3) {
                ConversorApi.converterMoeda("USD", "BRL", scanner);
            } else if (selecionarOperacao == 4) {
                ConversorApi.converterMoeda("BRL", "USD", scanner);
            } else if (selecionarOperacao == 5) {
                ConversorApi.converterMoeda("USD", "COP", scanner);
            } else if (selecionarOperacao == 6){
                ConversorApi.converterMoeda("COP", "USD", scanner);
            } else {
                System.out.println("Selecione uma opção valida!");
            }
        } while (selecionarOperacao != 7);
    }
}
