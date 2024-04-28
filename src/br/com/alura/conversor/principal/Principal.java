package br.com.alura.conversor.principal;

import br.com.alura.conversor.modelo.Menu;
import br.com.alura.conversor.servico.ConversorApi;

public class Principal {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirOperacoes();
    }
}
