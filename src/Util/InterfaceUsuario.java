package Util;

import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    //Métodos
    public double SolicitarValorImovel() {
        double ValorImovel;
        do {
            System.out.println("Digite o valor do imóvel: ");
            ValorImovel = scanner.nextDouble();
            if (ValorImovel <= 0) {
                System.out.println("Valor do Imóvel inválido. Por favor ");
            }
        } while (ValorImovel <= 0);
        return ValorImovel;
    }

    public int SolicitarPrazoFinanciamento() {
        int PrazoFinanciamento;
        do {
            System.out.println("Digite o prazo do financiamento em ANOS: ");
            PrazoFinanciamento = scanner.nextInt();
            if (PrazoFinanciamento <= 0) {
                System.out.println("Prazo do Financimento inválido. Por favor digite um valor positivo");
            }
        }while (PrazoFinanciamento <= 0);
        return PrazoFinanciamento;
    }

    public double SolicitarTaxaAnual() {
        double TaxaAnual;
        do {
            System.out.println("Digite a taxa de juros anual");
            TaxaAnual = scanner.nextDouble();
            if (TaxaAnual <= 0) {
                System.out.println("Taxa de juros anual inválida. Por favor digite um valor positivo");
            }
        } while (TaxaAnual <= 0);
        return TaxaAnual;
    }

    public double SolicitarAreaConstruida() {
        System.out.println("Digite a área construída (em metros quadrados): ");
        return scanner.nextDouble();
    }

    public double SolicitarAreaTerreno() {
        System.out.println("Digite a área do terreno (em metros quadrados): ");
        return scanner.nextDouble();
    }
}
