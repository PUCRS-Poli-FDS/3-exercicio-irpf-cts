package br.pucrs.politecnica._4636h.irpf.view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InterfaceUsuario extends Application {

	@Override
	public void init() {
		// código de inicialização
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
				Group root = new Group();
				Scene scene = new Scene(root, 600, 250);
				primaryStage.setTitle("Calcular Imposto de Renda");
				primaryStage.setScene(scene);
				primaryStage.show();
	}
	
	public static void main (String[] args) {
		launch(args);
	}

}
