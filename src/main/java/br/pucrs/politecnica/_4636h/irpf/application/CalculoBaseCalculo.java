package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public interface CalculoBaseCalculo {

    Currency calcular(Contribuinte contribuinte);

}
