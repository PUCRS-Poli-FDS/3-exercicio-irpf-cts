package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculadoraBaseCalculoPadrao implements CalculadoraBaseCalculo {

    @Override
    public Currency calcular(Contribuinte contribuinte) {
        return contribuinte.getTotalRendimentos().subtract(contribuinte.getContribuicaoPrevidenciaria());
    }
}
