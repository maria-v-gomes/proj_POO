package Main;

import Modelo.Casa;
import Modelo.Apartamento;
import Modelo.Terreno;
import Modelo.Financiamento;
import Util.InterfaceUsuario;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao programa de Financiamento de imóveis");

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Solicitar os dados do usuário para o financiamento de casa
        double taxaJurosCasa = interfaceUsuario.SolicitarTaxaAnual();
        int prazoCasa = interfaceUsuario.SolicitarPrazoFinanciamento();
        double valorCasa = interfaceUsuario.SolicitarValorImovel();
        double areaConstruidaCasa = interfaceUsuario.SolicitarAreaConstruida();
        double areaTerrenoCasa = interfaceUsuario.SolicitarAreaTerreno();
        Casa casa1 = new Casa(valorCasa, prazoCasa, taxaJurosCasa, areaConstruidaCasa, areaTerrenoCasa);
        financiamentos.add(casa1);

        // Financiamento direto no código
        Casa casa2 = new Casa(150000, 20, 8.5, 200, 300);
        financiamentos.add(casa2);

        // Financiamento Apartamentos
        Apartamento apartamento1 = new Apartamento(200000, 15, 7.0, 2,6);
        financiamentos.add(apartamento1);
        Apartamento apartamento2 = new Apartamento(180000, 10, 6.5,1,3);
        financiamentos.add(apartamento2);

        // Financiamento Terreno
        Terreno terreno = new Terreno(120000, 5, 10.0,"Residencial");
        financiamentos.add(terreno);

        //  Calcula o valor total de todos os imoveis e todos os financiamentos
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (Financiamento financiamento : financiamentos) {
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.CalcularTotaldoPagamento();
        }

        // Mostrar os resultados
        System.out.println("Detalhes dos financiamentos:");
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            String tipoImovel = "";

            if (financiamento instanceof Casa) {
                tipoImovel = "Casa";
            } else if (financiamento instanceof Apartamento) {
                tipoImovel = "Apartamento";
            } else if (financiamento instanceof Terreno) {
                tipoImovel = "Terreno";
            } else {
                tipoImovel = "Imóvel";
            }

            System.out.println("Financiamento " + (i + 1) + " -tipo: " + tipoImovel + ", valor do imóvel: R$" + financiamento.getValorImovel()
                    + ", valor do financiamento: R$ " + financiamento.CalcularTotaldoPagamento());
        }

        System.out.println("Total dos imóveis: R$ " + totalImoveis);
        System.out.println("Total dos financimentos: R$ " + totalFinanciamentos);
    }
}
