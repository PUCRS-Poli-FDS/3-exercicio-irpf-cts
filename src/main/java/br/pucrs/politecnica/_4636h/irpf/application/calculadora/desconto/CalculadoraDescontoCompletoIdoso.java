package br.pucrs.politecnica._4636h.irpf.application.calculadora.desconto;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculadoraDescontoCompletoIdoso implements CalculadoraDesconto {

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
            calculadoraDesconto = calculadoraDescontoComMaisDeCincoDependentes();
        }

        return calculadoraDesconto;
    }

    private CalculadoraDesconto calculadoraDescontoComAteDoisDependentes() {
        final double PERCENTUAL_DESCONTO = 0.03;
        return (contribuinte, baseCalculo) -> baseCalculo.multiply(PERCENTUAL_DESCONTO);
    }

    private CalculadoraDesconto calculadoraDescontoComTresACincoDependentes() {
        final double PERCENTUAL_DESCONTO = 0.045;
        return (contribuinte, baseCalculo) -> baseCalculo.multiply(PERCENTUAL_DESCONTO);
    }

    private CalculadoraDesconto calculadoraDescontoComMaisDeCincoDependentes() {
        final double PERCENTUAL_DESCONTO = 0.06;
        return (contribuinte, baseCalculo) -> baseCalculo.multiply(PERCENTUAL_DESCONTO);
    }

    private static boolean isContribuinteComAteDoisDependentes(Contribuinte contribuinte) {
        return contribuinte.getNumDependentes() <= 2;
    }

    private static boolean isContribuinteComTresACincoDependentes(Contribuinte contribuinte) {
        return contribuinte.getNumDependentes() >= 3 && contribuinte.getNumDependentes() <= 5;
    }
}
