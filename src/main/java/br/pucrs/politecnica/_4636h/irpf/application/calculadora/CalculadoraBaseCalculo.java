package br.pucrs.politecnica._4636h.irpf.application.calculadora;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public interface CalculadoraBaseCalculo {

    Currency calcular(Contribuinte contribuinte);

}
