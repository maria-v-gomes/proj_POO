package Modelo;

public class Casa extends Financiamento {

    //Construtor
    public Casa(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
    }

    //override
    public double CalcularPagamentoMensal() {
        // Calcaular o pagamento
        double pagamentomensalOriginal = super.CalcularPagamentoMensal();

        //Adicinando o valor adicional de R$80
        return pagamentomensalOriginal + 80;

    }

}
