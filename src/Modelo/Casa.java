package Modelo;

// Classe de exceção personalizada
class DescontoMaiorDoQueJurosException extends Exception {
    public DescontoMaiorDoQueJurosException(String mensagem) {
        super(mensagem);
    }
}

public class Casa extends Financiamento {

    private double areaConstruida;
    private double areaTerreno;

    // Construtor
    public Casa(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    // Override do método CalcularPagamentoMensal
    @Override
    public double CalcularPagamentoMensal() {
        // Cálculo do pagamento
        double taxaMensal = (getTaxaJurosAnual() / 12) / 100;
        int prazoEmMeses = getPrazoFinaciamento() * 12;
        double pagamentoMensal = (getValorImovel() * taxaMensal) / (1 - Math.pow(1 +
                taxaMensal, -prazoEmMeses));
        // Adicionando o valor adicional de R$80
        pagamentoMensal += 80;

        return pagamentoMensal;
    }

    // Método Abstrato calcular pagamento
    public double CalcularTotaldoPagamento() {
        return CalcularPagamentoMensal() * getPrazoFinaciamento() * 12;
    }

    // Verifica se o desconto é maior do que os juros
    public void verificarDesconto(double desconto) {
        double jurosMensais = CalcularPagamentoMensal() - 80; // Descontando o valor adicional
        try {
            if (desconto > jurosMensais) {
                throw new DescontoMaiorDoQueJurosException("Desconto maior do que os juros da mensalidade.");
            }
        } catch (DescontoMaiorDoQueJurosException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método abstrato mostrar dados do financiamento
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