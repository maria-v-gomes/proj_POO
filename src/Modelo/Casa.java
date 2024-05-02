package Modelo;
import java.io.Serializable;
import java.util.Objects;

// Classe de exceção personalizada
class DescontoMaiorDoQueJurosException extends Exception {
    public DescontoMaiorDoQueJurosException(String mensagem) {
        super(mensagem);
    }
}

public class Casa extends Financiamento implements Serializable {

    private double areaConstruida;
    private double areaTerreno;

    // Construtor vazio
    public Casa() {

    }

    // Construtor
    public Casa(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    // Método para converter um objeto Casa em uma string para salvar no arquivo
    @Override
    public String toFileString() {
        return String.format("%s,%f,%f", super.toFileString(), areaConstruida, areaTerreno);
    }

    public static Casa fromFileString(String line) {
        String[] parts = line.split(",");
        double valorImovel = Double.parseDouble(parts[0]);
        int prazoFinanciamento = Integer.parseInt(parts[1]);
        double taxaJurosAnual = Double.parseDouble(parts[2]);
        double areaConstruida = Double.parseDouble(parts[3]);
        double areaTerreno = Double.parseDouble(parts[4]);
        return new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, areaTerreno);
    }

    //métodos
    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Casa casa = (Casa) obj;
        return Double.compare(casa.ValorImovel, ValorImovel) == 0 &&
                PrazoFinaciamento == casa.PrazoFinaciamento &&
                Double.compare(casa.TaxaJurosAnual, TaxaJurosAnual) == 0 &&
                Double.compare(casa.areaConstruida, areaConstruida) == 0 &&
                Double.compare(casa.areaTerreno, areaTerreno) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ValorImovel, PrazoFinaciamento, TaxaJurosAnual, areaConstruida, areaTerreno);
    }
}