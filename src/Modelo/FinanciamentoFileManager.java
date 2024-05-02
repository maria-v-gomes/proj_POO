package Modelo;

import Modelo.Financiamento;
import Modelo.Casa;
import Modelo.Apartamento;
import Modelo.Terreno;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FinanciamentoFileManager {

    public static void salvarFinanciamentos(ArrayList<Financiamento> financiamentos, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Financiamento financiamento : financiamentos) {
                String prefix;
                if (financiamento instanceof Casa) {
                    prefix = "Casa";
                } else if (financiamento instanceof Apartamento) {
                    prefix = "Apartamento";
                } else if (financiamento instanceof Terreno) {
                    prefix = "Terreno";
                } else {
                    throw new IllegalArgumentException("Tipo de financiamento desconhecido");
                }
                writer.println(prefix + "," + financiamento.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Financiamento> carregarFinanciamentos(String filename) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                String data = String.join(",", Arrays.copyOfRange(parts, 1, parts.length));
                if (type.equals("Casa")) {
                    financiamentos.add(Casa.fromFileString(data));
                } else if (type.equals("Apartamento")) {
                    financiamentos.add(Apartamento.fromFileString(data));
                } else if (type.equals("Terreno")) {
                    financiamentos.add(Terreno.fromFileString(data));
                } else {
                    throw new IllegalArgumentException("Tipo de financiamento desconhecido: " + type);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return financiamentos;
    }

    public static void salvarArrayList(ArrayList<Financiamento> financiamentos, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(financiamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Financiamento> carregarArrayList(String filename) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            financiamentos = (ArrayList<Financiamento>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return financiamentos;
    }
}