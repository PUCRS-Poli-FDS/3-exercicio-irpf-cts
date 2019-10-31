package br.pucrs.politecnica._4636h.irpf.controller;

import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalcularImposto {

    public Currency calcularImposto(Currency baseCalculo) {
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
