package br.pucrs.politecnica._4636h.irpf.controller;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculoDesconto {


    private static final int IDADE_IDOSO = 65;

    public Currency calcularDesconto(Contribuinte contribuinte, Currency baseCalculo, String tipoCalculo) {
        double percentualDesconto;

        if (tipoCalculo.equalsIgnoreCase("completo")) {
            int dependentes = contribuinte.getNumDependentes();
            boolean idoso = contribuinte.getIdade() >= IDADE_IDOSO;

            if (dependentes <= 2) {
                percentualDesconto = idoso ? 0.03 : 0.02;
            } else if (dependentes <= 5) {
                percentualDesconto = idoso ? 0.045 : 0.035;
            } else {
                percentualDesconto = idoso ? 0.06 : 0.05;
            }
        } else if (tipoCalculo.equalsIgnoreCase("simplificado")) {
            percentualDesconto = 0.05;
        } else {
            throw new IllegalArgumentException("Tipo de cálculo inválido");
        }
        return baseCalculo.multiply(percentualDesconto);
    }
}
