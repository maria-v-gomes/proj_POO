package Modelo;

public class Financiamento {
    // Atributos
    protected double ValorImovel;
    protected int PrazoFinaciamento;
    protected double TaxaJurosAnual;

    // Construtor
    public Financiamento(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual) {
        this.ValorImovel = valorDesejadoImovel;
        this.PrazoFinaciamento = PrazoFinaciamentoemAnos;
        this.TaxaJurosAnual = TaxaJurosAnual;
    }

    //Getters
    public double getValorImovel() {
        return ValorImovel;
    }

    public int getPrazoFinaciamento() {
        return PrazoFinaciamento;
    }

    public double getTaxaJurosAnual() {
        return TaxaJurosAnual;
    }


    //Métodos
    public double CalcularPagamentoMensal() {
        return(this.ValorImovel / (this.PrazoFinaciamento * 12)) * (1 + (this.TaxaJurosAnual / 12));

    }

    public double CalcularTotaldoPagamento() {
        return this.CalcularPagamentoMensal() * this.PrazoFinaciamento * 12;
    }

    //Mostrar finaciamento na tela
    public void mostrarDadosFinanciamento() {
        System.out.println("Dados do Finaciamento:");
        System.out.println("Valor do Imóvel: " + this.getValorImovel());
        System.out.println("Prazo do Finaciamento (em anos): " + this.getPrazoFinaciamento());
        System.out.println("Taxa de Juros Anual: " + this.getTaxaJurosAnual());
        System.out.println("Valor total do Financiamento: " + this.CalcularTotaldoPagamento());
    }
}
