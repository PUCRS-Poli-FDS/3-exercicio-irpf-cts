package br.pucrs.politecnica._4636h.irpf.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InterfaceUsuario extends Application {

	private TextField tfContribuinte, tfCpf, tfIdade, tfNumDependentes, tfContribuicaoPrev, tfTotalRendimentos,
			tfImpostoRenda;
	private Stage primaryStage;

	@Override
	public void init() {
		// c�digo de inicializa��o
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setTitle("IRPF");
		primaryStage.setScene(scene);
		primaryStage.show();
		root.setAlignment(Pos.TOP_CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 25));
		Text texto = new Text("Calcular Imposto de Renda");
		texto.setFont(Font.font("Tohama", FontWeight.NORMAL, 20));
		root.add(texto, 0, 0);
		Label lbContribuinte = new Label("Contribuinte:");
		root.add(lbContribuinte, 0, 2);
		tfContribuinte = new TextField();
		root.add(tfContribuinte, 1, 2);
		Label lbCpf = new Label("CPF:");
		root.add(lbCpf, 0, 3);
		tfCpf = new TextField();
		root.add(tfCpf, 1, 3);
		Label lbIdade = new Label("Idade:");
		root.add(lbIdade, 0, 4);
		tfIdade = new TextField();
		root.add(tfIdade, 1, 4);
		Label lbNumDependentes = new Label("Número de Dependentes:");
		root.add(lbNumDependentes, 0, 5);
		tfNumDependentes = new TextField();
		root.add(tfNumDependentes, 1, 5);
		Label lbContribuicaoPrev = new Label("Contribuição Previdenciária:");
		root.add(lbContribuicaoPrev, 0, 6);
		tfContribuicaoPrev = new TextField();
		root.add(tfContribuicaoPrev, 1, 6);
		Label lbTotalRendimentos = new Label("Total de Rendimentos:");
		root.add(lbTotalRendimentos, 0, 7);
		tfTotalRendimentos = new TextField();
		root.add(tfTotalRendimentos, 1, 7);
		Label lbImpostoRenda = new Label("Imposto de Renda:");
		root.add(lbImpostoRenda, 0, 8);
		tfImpostoRenda = new TextField();
		root.add(tfImpostoRenda, 1, 8);

		HBox hbBut = new HBox();
		hbBut.setAlignment(Pos.BOTTOM_CENTER);
		Button butCalcularSimples = new Button("Calcular Simples");
		butCalcularSimples.setOnAction(e -> trataCalcularSimples());
		Button butCalcularCompleto = new Button ("Calcular Completo");
		butCalcularCompleto.setOnContextMenuRequested(e -> trataCalcularCompleto());
		Button butCancelar = new Button("Cancelar");
		butCancelar.setOnAction(e -> trataCancelar());
		hbBut.getChildren().add(butCalcularCompleto);
		hbBut.getChildren().add(butCalcularSimples);
		hbBut.getChildren().add(butCancelar);
		root.add(hbBut, 1, 11);

	}

	private void trataCalcularCompleto() {
		System.out.println("Contribuinte: " + tfContribuinte.getText() + "\nTotal Imposto de Renda: R$9999.99");
	}

	private void trataCalcularSimples() {
		System.out.println("Contribuinte: " + tfContribuinte.getText() + "\nTotal Imposto de Renda: R$9999.99");
	}

	private void trataCancelar() {
		tfContribuinte.clear();
		tfCpf.clear();
		tfIdade.clear();
		tfNumDependentes.clear();
		tfContribuicaoPrev.clear();
		tfTotalRendimentos.clear();
		tfImpostoRenda.clear();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
