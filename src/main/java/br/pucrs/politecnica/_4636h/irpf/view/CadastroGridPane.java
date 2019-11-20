package br.pucrs.politecnica._4636h.irpf.view;

import br.pucrs.politecnica._4636h.irpf.infrastructure.repository.PessoaFisicaRepository;
import br.pucrs.politecnica._4636h.irpf.model.PessoaFisica;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CadastroGridPane extends GridPane {

    private final Stage stage;
    private final PessoaFisicaRepository repository;
    private TextField tfNome;
    private TextField tfCpf;
    private TextField tfIdade;

    public CadastroGridPane(Stage stage, PessoaFisicaRepository repository) {
        this.stage = stage;
        this.repository = repository;

        this.setAlignment(Pos.TOP_CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Label lbNome = new Label("Nome:");
        this.add(lbNome, 0, 0);

        tfNome = new TextField();
        this.add(tfNome, 1, 0);

        Label lbCPF = new Label("CPF:");
        this.add(lbCPF, 0, 1);

        tfCpf = new TextField();
        this.add(tfCpf, 1, 1);

        Label lbIdade = new Label("Idade:");
        this.add(lbIdade, 0, 2);

        tfIdade = new TextField();
        this.add(tfIdade, 1, 2);

        HBox hbBut2 = new HBox();
        hbBut2.setAlignment(Pos.BOTTOM_CENTER);
        Button butProsseguir = new Button("Cadastrar");
        butProsseguir.setOnAction(e -> cadastrar());
        hbBut2.getChildren().add(butProsseguir);
        this.add(hbBut2, 1, 3);
    }

    private void cadastrar() {
        String nome = tfNome.getText();
        String cpf = tfCpf.getText();
        Integer idade = Integer.parseInt(tfIdade.getText());
        PessoaFisica pessoa = new PessoaFisica(nome, cpf, idade);
        repository.insert(pessoa);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Cadastro realizado com sucesso, prossiga para a calculadora.");
        if (alert.showAndWait().isPresent()) {
            stage.setScene(new CalculadoraScene(stage, pessoa));
        }
    }
}
