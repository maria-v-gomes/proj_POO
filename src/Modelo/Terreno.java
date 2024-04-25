package Modelo;

public class Terreno extends Financiamento {

    //construtor
    public Terreno(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
    }

    //override
    public double CalcularPagamentoMensal() {
        return super.CalcularPagamentoMensal();

    }
}