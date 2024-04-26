package Modelo;

public class Apartamento extends Financiamento {
    private int numeroVagasGaragem;
    private int numeroAndar;

    //Construtor
    public Apartamento(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    //Métodos
    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public void setNumeroVagasGaragem(int numeroVagasGaragem) {
        this.numeroVagasGaragem = numeroVagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    public void setNumeroAndar(int numeroAndar) {
        this.numeroAndar = numeroAndar;
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
    // Método abstrato calcular total pagamento
    public double CalcularTotaldoPagamento() {
        return CalcularPagamentoMensal() * getPrazoFinaciamento() * 12;
    }
    //Método mostrar dados do financiamento
    public void mostrarDadosFinanciamento() {
        System.out.println("Dados do Financiamento de Apartamento:");
        System.out.println("Valor do Imóvel: " + getValorImovel());
        System.out.println("Prazo do Financiamento (em anos): " + getPrazoFinaciamento());
        System.out.println("Taxa de Juros Anual: " + getTaxaJurosAnual());
        System.out.println("Valor total do Financiamento: " + CalcularTotaldoPagamento());
    }

}
