package com.mycompany.impostos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome da empresa: ");
        String nomeEmpresa = sc.nextLine();
        Pagamentos pagamentos = new Pagamentos(nomeEmpresa);

        while (true) {
            System.out.print("Digite o tipo de imposto (1-PIS, 2-IPI) ou 'pare' para encerrar: ");
            String entrada = sc.nextLine();
            if (entrada.equalsIgnoreCase("pare")) break;

            if (entrada.equals("1")) { // PIS
                System.out.print("Valor do débito: ");
                double debito = sc.nextDouble();
                System.out.print("Valor do crédito: ");
                double credito = sc.nextDouble();
                sc.nextLine(); // consumir enter
                pagamentos.adicionarImposto(new PIS(debito, credito));
            } else if (entrada.equals("2")) { // IPI
                System.out.print("Valor do produto: ");
                double valor = sc.nextDouble();
                System.out.print("Frete: ");
                double frete = sc.nextDouble();
                System.out.print("Seguro: ");
                double seguro = sc.nextDouble();
                System.out.print("Outras despesas: ");
                double outras = sc.nextDouble();
                System.out.print("Alíquota (%): ");
                double aliquota = sc.nextDouble();
                sc.nextLine(); // consumir enter
                pagamentos.adicionarImposto(new IPI(valor, frete, seguro, outras, aliquota));
            } else {
                System.out.println("Tipo de imposto inválido!");
            }
        }

        pagamentos.mostrarPagamentos();
    }
}
