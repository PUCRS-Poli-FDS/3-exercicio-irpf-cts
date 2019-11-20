package br.pucrs.politecnica._4636h.irpf.view;

import br.pucrs.politecnica._4636h.irpf.infrastructure.repository.PessoaFisicaRepository;
import br.pucrs.politecnica._4636h.irpf.model.PessoaFisica;
import br.pucrs.politecnica._4636h.irpf.model.exception.PessoaFisicaNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WelcomeGridPane extends GridPane {

    private final Stage stage;
    private final PessoaFisicaRepository repository;
    private final TextField cpf;

    public WelcomeGridPane(Stage stage, PessoaFisicaRepository repository) {
        this.stage = stage;
        this.repository = repository;

        this.setAlignment(Pos.TOP_CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        HBox hbBut2 = new HBox();
        hbBut2.setAlignment(Pos.BOTTOM_CENTER);

        Label lbCpf = new Label("CPF:");
        this.add(lbCpf, 0, 0);

        cpf = new TextField();
        this.add(cpf, 1, 0);

        Button butProsseguir = new Button("Prosseguir");
        butProsseguir.setOnAction(e -> buscaCPF());
        hbBut2.getChildren().add(butProsseguir);
        this.add(hbBut2, 1, 1);
    }

    private void buscaCPF() {
        try {
            PessoaFisica pessoa = repository.findByCPF(cpf.getText());
            stage.setScene(new CalculadoraScene(stage, pessoa));
        } catch (PessoaFisicaNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Aviso");
            alert.setContentText("CPF não cadastrado. Efetue o cadastro na tela à seguir.");

            if (alert.showAndWait().isPresent()) {
                stage.setScene(new CadastroScene(stage, cpf.getText(), repository));
            }
        }
    }
}
