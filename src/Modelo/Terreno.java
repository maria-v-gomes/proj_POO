package Modelo;

public class Terreno extends Financiamento {

    //construtor
    public Terreno(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
    }

    //override para incluir o acréscimo
    public double CalcularPagamentoMensal() {
        //Calcula o pagamento mensal seguindo a fórmula
        double pagamentoMensalOriginal = super.CalcularPagamentoMensal();

        //Calcular o acréscimo de 2%
        double acrescimo = pagamentoMensalOriginal * 0.02;

        //Retornar o valor do pagamento mensal + 2%
        return pagamentoMensalOriginal + acrescimo;

    }
}