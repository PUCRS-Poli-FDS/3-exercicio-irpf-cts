package br.pucrs.politecnica._4636h.irpf.controller;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class Calculadora {

    private static final int IDADE_IDOSO = 65;

    public Currency calcular(Contribuinte contribuinte, String tipoCalculo) {
        Currency baseCalculo = calcularBaseCalculo(contribuinte);
        Currency desconto = calcularDesconto(contribuinte, baseCalculo, tipoCalculo);
        Currency baseCalculoLiquida = baseCalculo.subtract(desconto);
        return calcularImposto(baseCalculoLiquida);
    }

    private Currency calcularBaseCalculo(Contribuinte contribuinte) {
        return contribuinte.getTotalRendimentos().subtract(contribuinte.getContribuicaoPrevidenciaria());
    }

    private Currency calcularDesconto(Contribuinte contribuinte, Currency baseCalculo, String tipoCalculo) {
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

    private Currency calcularImposto(Currency baseCalculo) {
        if (baseCalculo.compareTo(Currency.valueOf(12000.00)) <= 0) { // <= 12.000,00
            return Currency.ZERO;
        } else if (baseCalculo.compareTo(Currency.valueOf(24000.00)) < 0) { // < R$24.000,00
            return baseCalculo.subtract(Currency.valueOf(12000.00)).multiply(0.15); // 15%
        } else {
            Currency imposto = Currency.valueOf(12000.00).multiply(0.15); // 15% sobre o teto da Faixa 2
            return imposto.add(baseCalculo.subtract(Currency.valueOf(24000.00)).multiply(0.275));
        }
    }

}
