package br.pucrs.politecnica._4636h.irpf;

import br.pucrs.politecnica._4636h.irpf.application.CalculoIrpf;
import br.pucrs.politecnica._4636h.irpf.application.CalculoIrpfFactory;
import br.pucrs.politecnica._4636h.irpf.model.TipoCalculo;
import br.pucrs.politecnica._4636h.irpf.view.Menu;

public class App {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibir();

        CalculoIrpf calculo = new CalculoIrpfFactory().getCalculo(TipoCalculo.COMPLETO);
    }

}
