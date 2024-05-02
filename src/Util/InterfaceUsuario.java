package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

class ValorInvalidoException extends Exception {
    public ValorInvalidoException(String msg) {
        super(msg);
    }
}

public class InterfaceUsuario {
    private Scanner scanner = new Scanner(System.in);

    private double solicitarDouble(String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.next();
            }
        }
    }

    private int solicitarInt(String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um valor válido.");
                scanner.next();
            }
        }
    }

    public double solicitarValorImovel() {
        while (true) {
            try {
                double valorImovel = solicitarDouble("Digite o valor do Imóvel:");
                if (valorImovel <= 0) {
                    throw new ValorInvalidoException("Valor do imóvel inválido. Digite um valor válido.");
                }
                return valorImovel;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int solicitarPrazoFinanciamento() {
        while (true) {
            try {
                int prazoFinanciamento = solicitarInt("Digite o prazo do financiamento:");
                if (prazoFinanciamento <= 0) {
                    throw new ValorInvalidoException("Prazo do financiamento inválido. Digite um valor válido.");
                }
                return prazoFinanciamento;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public double solicitarTaxaAnual() {
        while (true) {
            try {
                double taxaAnual = solicitarDouble("Digite a taxa de juros anual:");
                if (taxaAnual <= 0) {
                    throw new ValorInvalidoException("Taxa de juros inválida. Digite um valor válido.");
                }
                return taxaAnual;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public double solicitarAreaConstruida() {
        return solicitarDouble("Digite a área construída (em metros quadrados):");
    }

    public double solicitarAreaTerreno() {
        return solicitarDouble("Digite a área do terreno (em metros quadrados):");
    }
}