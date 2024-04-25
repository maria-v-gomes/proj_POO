package Main;

import Modelo.Financiamento;
import Util.InterfaceUsuario;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo ao programa de Financiamento de imóveis");

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        //Adicionar os quatro financiamentos ao Arraylist
        for (int i = 1; i <= 4; i++) {
            double TaxaJuros = interfaceUsuario.SolicitarTaxaAnual();
            int PrazoFinanciamentoemAnos = interfaceUsuario.SolicitarPrazoFinanciamento();
            double ValorImovel = interfaceUsuario.SolicitarValorImovel();


            Financiamento NovoFinanciamento = new Financiamento(ValorImovel, PrazoFinanciamentoemAnos, TaxaJuros);
            financiamentos.add(NovoFinanciamento);
        }
        //  Calcula o valor total de todos os imoveis e todos os financiamentos
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (Financiamento financimento : financiamentos) {
            totalImoveis += financimento.getValorImovel();
            totalFinanciamentos += financimento.CalcularTotaldoPagamento();
        }

        //Mostrar os resultados
        System.out.println("Detalhes dos financiamentos:");
        for (int i = 0; i < financiamentos.size(); i++) {
            System.out.println("Financiamento" + (i + 1) + " - valor do imóvel: R$" + financiamentos.get(i).getValorImovel()
                    + ", valor do financiamento: R$ " + financiamentos.get(i).CalcularTotaldoPagamento());

        }

        System.out.println("Total dos imóveis: R$ " + totalImoveis);
        System.out.println("Total dos financiamentos: R$ " + totalFinanciamentos);
    }
}