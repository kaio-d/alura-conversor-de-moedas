package br.com.alura.conversor.servico;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorApi {
    public static void converterMoeda(String moedaInicial, String moedaFinal, Scanner scanner){
        try {
            String apiKey = "f8b48547056bab7755c96986";
            String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaInicial;

            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");

            if (!conversionRates.has(moedaFinal)) {
                System.out.println("Moeda de destino inválida.");
                return;
            }

            double taxaDeCambio = conversionRates.get(moedaFinal).getAsDouble();

            System.out.println("Digite o valor que deseja converter:");
            double valorParaConversao = scanner.nextDouble();
            double valorDaConversao = valorParaConversao * taxaDeCambio;

            System.out.println("Valor da conversão: " + valorDaConversao);

        } catch (Exception e){
            System.out.println("Ocorreu um erro");
            System.out.println(e.getMessage());
        }
    }
}
