package Main;

import Modelo.Casa;
import Modelo.Apartamento;
import Modelo.Terreno;
import Modelo.Financiamento;
import Util.InterfaceUsuario;
import java.util.ArrayList;
import Modelo.FinanciamentoFileManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao programa de Financiamento de imóveis");

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Solicitar os dados do usuário para o financiamento de casa
        double taxaJurosCasa = interfaceUsuario.solicitarTaxaAnual();
        int prazoCasa = interfaceUsuario.solicitarPrazoFinanciamento();
        double valorCasa = interfaceUsuario.solicitarValorImovel();
        double areaConstruidaCasa = interfaceUsuario.solicitarAreaConstruida();
        double areaTerrenoCasa = interfaceUsuario.solicitarAreaTerreno();
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

            System.out.println("\nFinanciamento " + (i + 1) + ":");

            if (financiamento instanceof Casa) {
                System.out.println("Tipo: Casa");
                System.out.println("Área Construída: " + ((Casa) financiamento).getAreaConstruida() + "m²");
                System.out.println("Área do Terreno: " + ((Casa) financiamento).getAreaTerreno() + "m²");
            } else if (financiamento instanceof Apartamento) {
                System.out.println("Tipo: Apartamento");
                System.out.println("Número do Andar: " + ((Apartamento) financiamento).getNumeroAndar());
                System.out.println("Número de Vagas na Garagem: " + ((Apartamento) financiamento).getNumeroVagasGaragem());
            } else if (financiamento instanceof Terreno) {
                System.out.println("Tipo: Terreno");
                System.out.println("Tipo de Zona: " + ((Terreno) financiamento).getTipoZona());
            } else {
                System.out.println("Tipo: Imóvel");
            }

            System.out.println("Valor do imóvel: R$" + String.format("%.2f", financiamento.getValorImovel()));
            System.out.println("Valor do financiamento: R$ " + String.format("%.2f", financiamento.CalcularTotaldoPagamento()));
        }

        System.out.println("Total dos imóveis: R$ " + String.format("%.2f", totalImoveis));
        System.out.println("Total dos financiamentos: R$ " + String.format("%.2f", totalFinanciamentos));

        // Salvar a lista de financiamentos em um arquivo
        String filename = "financiamentos.ser";
        FinanciamentoFileManager.salvarArrayList(financiamentos, filename);

        // Carregar a lista de financiamentos do arquivo
        ArrayList<Financiamento> financiamentosCarregados = FinanciamentoFileManager.carregarArrayList(filename);

        // Verificar se os dados foram salvos corretamente
        // Isso irá imprimir true se os dados foram salvos e carregados corretamente
        System.out.println(financiamentos.equals(financiamentosCarregados));

    }
}