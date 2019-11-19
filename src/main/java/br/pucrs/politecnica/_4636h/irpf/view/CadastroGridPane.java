package br.pucrs.politecnica._4636h.irpf.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CadastroGridPane extends GridPane {

    private TextField nome;
    private TextField cpf;
    private TextField idade;

    public CadastroGridPane() {
        this.setAlignment(Pos.TOP_CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Label lbNome = new Label("Nome:");
        this.add(lbNome, 0, 0);

        nome = new TextField();
        this.add(nome, 0, 0);

        Label lbCPF = new Label("CPF:");
        this.add(lbCPF, 1, 1);

        nome = new TextField();
        this.add(nome, 1, 1);
    }
}
