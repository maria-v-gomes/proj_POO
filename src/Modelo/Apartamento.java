package Modelo;

public class Apartamento extends Financiamento {

    //Construtor
    public Apartamento(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
    }

    //override
    public double CalcularPagamentoMensal() {
        //Calcular a taxa mensal
        double taxaMensal = (getTaxaJurosAnual() / 12) / 100;

        //Calcular o financiamento em meses
        int prazoEmMeses = getPrazoFinaciamento() * 12;

        // Calcular o pagamento mensal com a fórmula da amortização PRICE
        double pagamentoMensal = (getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, - prazoEmMeses));

        return pagamentoMensal;


    }
}
