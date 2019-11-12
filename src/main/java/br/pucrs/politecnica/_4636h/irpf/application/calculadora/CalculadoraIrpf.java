package br.pucrs.politecnica._4636h.irpf.application.calculadora;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public interface CalculadoraIrpf {

    Currency calcular(Contribuinte contribuinte);

}
