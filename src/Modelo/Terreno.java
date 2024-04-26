package Modelo;

public class Terreno extends Financiamento {

    private String tipoZona;

    //construtor
    public Terreno(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual, String tipoZona) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    //Métodos
    public String getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(String tipoZona) {
        this.tipoZona = tipoZona;
    }

    //override para incluir o acréscimo
    @Override
    public double CalcularPagamentoMensal() {
        //Calcula o pagamento mensal seguindo a fórmula
        double taxaMensal = (getTaxaJurosAnual() / 12) / 100;
        int prazoEmMeses = getPrazoFinaciamento() * 12;
        double pagamentoMensal = (getValorImovel() * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -prazoEmMeses));

        //Acréscimo 2%
        double acrescimo = pagamentoMensal * 0.02;

        // retornar o pagamento mensal
        return pagamentoMensal + acrescimo;
    }

    //Método abstrato
    public double CalcularTotaldoPagamento() {
        return CalcularPagamentoMensal() * getPrazoFinaciamento() * 12;
    }

    public void mostrarDadosFinanciamento() {
        System.out.println("Dados do Financiamento de Terreno:");
        System.out.println("Valor do Terreno: " + getValorImovel());
        System.out.println("Prazo do Financiamento (em anos): " + getPrazoFinaciamento());
        System.out.println("Taxa de Juros Anual: " + getTaxaJurosAnual());
        System.out.println("Valor total do Financiamento: " + CalcularTotaldoPagamento());
    }
}
