package Modelo;
import java.io.Serializable;
import java.util.Objects;

public class Terreno extends Financiamento implements Serializable {

    private String tipoZona;

    //Construtor vazio
    public Terreno() {

    }

    //construtor
    public Terreno(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual, String tipoZona) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    // Método para converter um objeto Terreno em uma string para salvar no arquivo
    @Override
    public String toFileString() {
        return String.format("%s,%f,%f", super.toFileString(), tipoZona);
    }

    public static Terreno fromFileString(String line) {
        String[] parts = line.split(",");
        double valorImovel = Double.parseDouble(parts[0]);
        int prazoFinanciamento = Integer.parseInt(parts[1]);
        double taxaJurosAnual = Double.parseDouble(parts[2]);
        String tipoZona = parts[3];
        return new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
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
        System.out.println("Tipo de zona:" + getTipoZona());
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
        Terreno terreno = (Terreno) obj;
        return Double.compare(terreno.ValorImovel, ValorImovel) == 0 &&
                PrazoFinaciamento == terreno.PrazoFinaciamento &&
                Double.compare(terreno.TaxaJurosAnual, TaxaJurosAnual) == 0 &&
                tipoZona.equals(terreno.tipoZona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ValorImovel, PrazoFinaciamento, TaxaJurosAnual, tipoZona);
    }
}