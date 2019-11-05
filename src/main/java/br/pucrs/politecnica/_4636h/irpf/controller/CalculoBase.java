package br.pucrs.politecnica._4636h.irpf.controller;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculoBase {

    public Currency calcularBaseCalculo(Contribuinte contribuinte) {
        return contribuinte.getTotalRendimentos().subtract(contribuinte.getContribuicaoPrevidenciaria());
    }
}
