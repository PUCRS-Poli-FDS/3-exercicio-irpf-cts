package br.pucrs.politecnica._4636h.irpf.controller;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class Calculadora {

    private CalculoBase calculoBase;
    private CalculoDesconto calculoDesconto;
    private CalcularImposto calculoImposto;

    public Calculadora(CalculoBase calculoBase, CalculoDesconto calculoDesconto, CalcularImposto calculoImposto) {
        this.calculoBase = calculoBase;
        this.calculoDesconto = calculoDesconto;
        this.calculoImposto = calculoImposto;
    }

    public Currency calcular(Contribuinte contribuinte, String tipoCalculo) {
        Currency baseCalculo = calculoBase.calcularBaseCalculo(contribuinte);
        Currency desconto = calculoDesconto.calcularDesconto(contribuinte, baseCalculo, tipoCalculo);
        Currency baseCalculoLiquida = baseCalculo.subtract(desconto);
        return calculoImposto.calcularImposto(baseCalculoLiquida);
    }
}
