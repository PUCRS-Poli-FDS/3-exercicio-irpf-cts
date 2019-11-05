package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculoDescontoCompletoIdoso implements CalculoDesconto {

    @Override
    public Currency calcular(Contribuinte contribuinte, Currency baseCalculo) {
        CalculoDesconto calculoDesconto;

        if (isContribuinteComAteDoisDependentes(contribuinte)) {
            calculoDesconto = calculoDescontoComAteDoisDependentes();
        } else {
            calculoDesconto = calculoDescontoComMaisDeCincoDependentes();
        }

        return calculoDesconto.calcular(contribuinte, baseCalculo);
    }

    private static boolean isContribuinteComAteDoisDependentes(Contribuinte contribuinte) {
        return contribuinte.getNumDependentes() <= 2;
    }

    private static CalculoDesconto calculoDescontoComAteDoisDependentes() {
        return new CalculoDescontoCompletoIdosoComAteDoisDependentes();
    }

    private static CalculoDesconto calculoDescontoComMaisDeCincoDependentes() {
        return new CalculoDescontoCompletoIdosoComMaisDeCincoDependentes();
    }
}
