package com.mycompany.impostos;

import java.util.ArrayList;
import java.util.List;

public class Pagamentos {
    private String nomeEmpresa;
    private List<Imposto> impostos;

    public Pagamentos(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        this.impostos = new ArrayList<>();
    }

    public String getNomeEmpresa() { return nomeEmpresa; }
    public void setNomeEmpresa(String nomeEmpresa) { this.nomeEmpresa = nomeEmpresa; }

    public void adicionarImposto(Imposto imposto) {
        impostos.add(imposto);
    }

    public void mostrarPagamentos() {
        System.out.println("=== Pagamentos da empresa: " + nomeEmpresa + " ===");
        for (Imposto imp : impostos) {
            System.out.println(imp.getDescricao() + ": R$ " + String.format("%.2f", imp.calcular()));
        }
    }
}
