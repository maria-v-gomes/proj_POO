package Modelo;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double areaTerreno;

    //Construtor
    public Casa(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    //override
    public double CalcularPagamentoMensal() {
        // Calcaular o pagamento
        double taxaMensal = (getTaxaJurosAnual() / 12) / 100;
        int prazoEmMeses = getPrazoFinaciamento() * 12;
        double pagamentoMensal = (getValorImovel() * taxaMensal) / (1 - Math.pow(1 +
                taxaMensal, -prazoEmMeses));
        //Adicinando o valor adicional de R$80
        pagamentoMensal += 80;

        return pagamentoMensal;

    }

    //Método Abstrato calcular pagamento
    public double CalcularTotaldoPagamento() {
        return CalcularPagamentoMensal() * getPrazoFinaciamento() * 12;
    }

    //Método abstrato mostrar dados do financiamento
    public void mostrarDadosFinanciamento() {
        System.out.println("Dados do Financiamento de Casa:");
        System.out.println("Valor do Imóvel: " + getValorImovel());
        System.out.println("Prazo do Financiamento (em anos): " + getPrazoFinaciamento());
        System.out.println("Taxa de Juros Anual: " + getTaxaJurosAnual());
        System.out.println("Área Construída: " + areaConstruida);
        System.out.println("Área do Terreno: " + areaTerreno);
        System.out.println("Valor total do Financiamento: " + CalcularTotaldoPagamento());
    }
}