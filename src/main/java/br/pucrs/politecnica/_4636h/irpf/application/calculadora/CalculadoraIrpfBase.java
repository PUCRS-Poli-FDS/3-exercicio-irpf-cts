package br.pucrs.politecnica._4636h.irpf.application.calculadora;

import br.pucrs.politecnica._4636h.irpf.application.calculadora.desconto.CalculadoraDesconto;
import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public abstract class CalculadoraIrpfBase implements CalculadoraIrpf {

    private final CalculadoraBaseCalculo calculadoraBaseCalculo;
    private final CalculadoraDesconto calculadoraDesconto;
    private final CalculadoraImposto calculadoraImposto;

    public CalculadoraIrpfBase(CalculadoraDesconto calculadoraDesconto) {
        this(calculadoraBaseCalculo(), calculadoraDesconto, calculadoraImposto());
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
        return calculadoraImposto.calcular(baseCalculoLiquida);
    }

    private static CalculadoraBaseCalculo calculadoraBaseCalculo() {
        return contribuinte -> contribuinte.getTotalRendimentos().subtract(contribuinte.getContribuicaoPrevidenciaria());
    }

    private static CalculadoraImposto calculadoraImposto() {
        return new CalculadoraImpostoPorFaixa();
    }
}
