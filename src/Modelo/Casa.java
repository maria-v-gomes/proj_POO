package Modelo;

public class Casa extends Financiamento {

    //Construtor
    public Casa(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
    }

    //override
    public double CalcularPagamentoMensal() {
        return super.CalcularPagamentoMensal() + 80;

    }

}
