package Modelo;

public class Apartamento extends Financiamento {

    //Construtor
    public Apartamento(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
    }

    //override
    public double CalcularPagamentoMensal() {
        //Calcular a taxa mensal
        //Calcular o financiamento em meses
        return 0;

    }
}
