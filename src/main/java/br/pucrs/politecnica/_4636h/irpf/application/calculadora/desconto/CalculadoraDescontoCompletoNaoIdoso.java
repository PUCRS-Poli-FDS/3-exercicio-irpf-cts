package br.pucrs.politecnica._4636h.irpf.application.calculadora.desconto;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculadoraDescontoCompletoNaoIdoso implements CalculadoraDesconto {

    @Override
    public Currency calcular(Contribuinte contribuinte, Currency baseCalculo) {
        return getCalculadora(contribuinte).calcular(contribuinte, baseCalculo);
    }

    private CalculadoraDesconto getCalculadora(Contribuinte contribuinte) {
        CalculadoraDesconto calculadoraDesconto;

        if (isContribuinteComAteDoisDependentes(contribuinte)) {
            calculadoraDesconto = calculadoraDescontoComAteDoisDependentes();
        } else if (isContribuinteComTresACincoDependentes(contribuinte)){
            calculadoraDesconto = calculadoraDescontoComTresACincoDependentes();
        } else {
            calculadoraDesconto = calculadoraDescontoComMaisDeCincoContribuintes();
        }

        return calculadoraDesconto;
    }

    private CalculadoraDesconto calculadoraDescontoComAteDoisDependentes() {
        final double PERCENTUAL_DESCONTO = 0.02;
        return (contribuinte, baseCalculo) -> baseCalculo.multiply(PERCENTUAL_DESCONTO);
    }

    private CalculadoraDesconto calculadoraDescontoComTresACincoDependentes() {
        final double PERCENTUAL_DESCONTO = 0.035;
        return (contribuinte, baseCalculo) -> baseCalculo.multiply(PERCENTUAL_DESCONTO);
    }

    private CalculadoraDesconto calculadoraDescontoComMaisDeCincoContribuintes() {
        final double PERCENTUAL_DESCONTO = 0.05;
        return (contribuinte, baseCalculo) -> baseCalculo.multiply(PERCENTUAL_DESCONTO);
    }

    private static boolean isContribuinteComAteDoisDependentes(Contribuinte contribuinte) {
        return contribuinte.getNumDependentes() <= 2;
    }

    private static boolean isContribuinteComTresACincoDependentes(Contribuinte contribuinte) {
        return contribuinte.getNumDependentes() >= 3 && contribuinte.getNumDependentes() <= 5;
    }
}
