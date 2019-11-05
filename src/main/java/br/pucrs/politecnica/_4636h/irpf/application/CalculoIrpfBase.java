package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public abstract class CalculoIrpfBase implements CalculoIrpf {

    private final CalculoBaseCalculo calculoBaseCalculo;
    private final CalculoDesconto calculoDesconto;
    private final CalculoImposto calculoImposto;

    public CalculoIrpfBase(CalculoDesconto calculoDesconto) {
        this(calculoBaseCalculoPadrao(), calculoDesconto, calculoImpostoPorFaixa());
    }

    public CalculoIrpfBase(CalculoBaseCalculo calculoBaseCalculo,
                           CalculoDesconto calculoDesconto,
                           CalculoImposto calculoImposto) {
        this.calculoBaseCalculo = calculoBaseCalculo;
        this.calculoDesconto = calculoDesconto;
        this.calculoImposto = calculoImposto;
    }

    @Override
    public Currency calcular(Contribuinte contribuinte) {
        Currency baseCalculo = calculoBaseCalculo.calcular(contribuinte);
        Currency desconto = calculoDesconto.calcular(contribuinte, baseCalculo);
        Currency baseCalculoLiquida = baseCalculo.subtract(desconto);
        return calculoImposto.calcular(baseCalculoLiquida);
    }

    private static CalculoBaseCalculo calculoBaseCalculoPadrao() {
        return new CalculoBaseCalculoPadrao();
    }

    private static CalculoImposto calculoImpostoPorFaixa() {
        return new CalculoImpostoPorFaixa();
    }
}
