package Modelo;
import java.io.Serializable;
import java.util.Objects;

public class Apartamento extends Financiamento implements Serializable {
    private int numeroVagasGaragem;
    private int numeroAndar;

    //Construtor vazio
    public Apartamento() {

    }

    //Construtor
    public Apartamento(double valorDesejadoImovel, int PrazoFinaciamentoemAnos, double TaxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorDesejadoImovel, PrazoFinaciamentoemAnos, TaxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    // Método para converter um objeto Terreno em uma string para salvar no arquivo
    @Override
    public String toFileString() {
        return String.format("%s,%f,%f", super.toFileString(),numeroVagasGaragem, numeroAndar );
    }

    public static Apartamento fromFileString(String line) {
        String[] parts = line.split(",");
        double valorImovel = Double.parseDouble(parts[0]);
        int prazoFinanciamento = Integer.parseInt(parts[1]);
        double taxaJurosAnual = Double.parseDouble(parts[2]);
        int numeroVagasGaragem = Integer.parseInt(parts[3]);
        int numeroAndar = Integer.parseInt(parts[4]);
        return new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem, numeroAndar);
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Apartamento apartamento = (Apartamento) obj;
        return Double.compare(apartamento.ValorImovel, ValorImovel) == 0 &&
                PrazoFinaciamento == apartamento.PrazoFinaciamento &&
                Double.compare(apartamento.TaxaJurosAnual, TaxaJurosAnual) == 0 &&
                numeroAndar == apartamento.numeroAndar &&
                numeroVagasGaragem == apartamento.numeroVagasGaragem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ValorImovel, PrazoFinaciamento, TaxaJurosAnual, numeroAndar, numeroVagasGaragem);
    }

}
