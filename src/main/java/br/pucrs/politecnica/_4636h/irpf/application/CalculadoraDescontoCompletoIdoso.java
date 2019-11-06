package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculadoraDescontoCompletoIdoso implements CalculadoraDesconto {

    @Override
    public Currency calcular(Contribuinte contribuinte, Currency baseCalculo) {
        CalculadoraDesconto calculadoraDesconto;

        if (isContribuinteComAteDoisDependentes(contribuinte)) {
            calculadoraDesconto = calculoDescontoComAteDoisDependentes();
        } else {
            calculadoraDesconto = calculoDescontoComMaisDeCincoDependentes();
        }

        return calculadoraDesconto.calcular(contribuinte, baseCalculo);
    }

    private static boolean isContribuinteComAteDoisDependentes(Contribuinte contribuinte) {
        return contribuinte.getNumDependentes() <= 2;
    }

    private static CalculadoraDesconto calculoDescontoComAteDoisDependentes() {
        return new CalculadoraDescontoCompletoIdosoComAteDoisDependentes();
    }

    private static CalculadoraDesconto calculoDescontoComMaisDeCincoDependentes() {
        return new CalculadoraDescontoCompletoIdosoComMaisDeCincoDependentes();
    }
}
