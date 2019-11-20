package br.pucrs.politecnica._4636h.irpf.view;

import br.pucrs.politecnica._4636h.irpf.model.PessoaFisica;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraScene extends Scene {

    public CalculadoraScene(Stage stage, PessoaFisica pessoa) {
        super(new CalculadoraGridPane(stage, pessoa));
    }
}
