package br.pucrs.politecnica._4636h.irpf;

import br.pucrs.politecnica._4636h.irpf.view.CalculadoraScene;
import br.pucrs.politecnica._4636h.irpf.view.WelcomeScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("IRPF");
        stage.setScene(getCalculadoraScene());
        stage.show();
    }

    private Scene getWelcomeScene() {
        return new WelcomeScene();
    }

    private Scene getCalculadoraScene() {
        return new CalculadoraScene();
    }
}
