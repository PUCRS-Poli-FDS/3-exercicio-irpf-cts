package br.pucrs.politecnica._4636h.irpf.view;

import br.pucrs.politecnica._4636h.irpf.infrastructure.repository.PessoaFisicaRepository;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WelcomeScene extends Scene {

    public WelcomeScene(Stage stage, PessoaFisicaRepository repository) {
        super(new WelcomeGridPane(stage, repository));
    }
}
