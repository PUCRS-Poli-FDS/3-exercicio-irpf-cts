package br.pucrs.politecnica._4636h.irpf.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class WelcomeGridPane extends GridPane {

    private TextField cpf;

    public WelcomeGridPane() {
        this.setAlignment(Pos.TOP_CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));



        HBox hbBut2 = new HBox();
        hbBut2.setAlignment(Pos.BOTTOM_CENTER);

        Button butCadastrar = new Button("Cadastrar");
        hbBut2.getChildren().add(butCadastrar);
        this.add(hbBut2, 0, 0);
    }
}
