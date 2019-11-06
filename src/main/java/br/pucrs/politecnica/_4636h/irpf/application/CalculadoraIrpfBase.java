package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;
import br.pucrs.politecnica._4636h.irpf.model.FaixaImposto;

public abstract class CalculadoraIrpfBase implements CalculadoraIrpf {

    private final CalculadoraBaseCalculo calculadoraBaseCalculo;
    private final CalculadoraDesconto calculadoraDesconto;
    private final CalculadoraImpostoFactory calculadoraImpostoFactory;

    public CalculadoraIrpfBase(CalculadoraDesconto calculadoraDesconto) {
        this(calculoBaseCalculoPadrao(), calculadoraDesconto, calculoImpostoPorFaixa());
    }

    public CalculadoraIrpfBase(CalculadoraBaseCalculo calculadoraBaseCalculo,
                               CalculadoraDesconto calculadoraDesconto,
                               CalculadoraImposto calculadoraImposto) {
        this.calculadoraBaseCalculo = calculadoraBaseCalculo;
        this.calculadoraDesconto = calculadoraDesconto;
        this.calculadoraImposto = calculadoraImposto;
    }

    @Override
    public Currency calcular(Contribuinte contribuinte) {
        Currency baseCalculo = calculadoraBaseCalculo.calcular(contribuinte);
        Currency desconto = calculadoraDesconto.calcular(contribuinte, baseCalculo);
        Currency baseCalculoLiquida = baseCalculo.subtract(desconto);
        return FaixaImposto.getFaixa(baseCalculoLiquida).getCalculadora().calcular()

        return calculadoraImpostoFactory.getCalculadora(baseCalculoLiquida).calcular()
    }

    private static CalculadoraBaseCalculo calculoBaseCalculoPadrao() {
        return new CalculadoraBaseCalculoPadrao();
    }

    private static CalculadoraImposto calculoImpostoPorFaixa() {
        return new CalculadoraImpostoPorFaixa();
    }
}
