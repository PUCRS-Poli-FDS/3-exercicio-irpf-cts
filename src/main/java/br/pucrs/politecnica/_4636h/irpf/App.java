package br.pucrs.politecnica._4636h.irpf;

import br.pucrs.politecnica._4636h.irpf.infrastructure.repository.JdbcPessoaFisicaRepository;
import br.pucrs.politecnica._4636h.irpf.infrastructure.repository.PessoaFisicaRepository;
import br.pucrs.politecnica._4636h.irpf.view.WelcomeScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App extends Application {

    private static final String JDBC_CONN_STRING = "jdbc:derby:derbyDB;create=true";

    private Connection conn;
    private PessoaFisicaRepository pfRepository;

    public App() {
        try {
            conn = getConnection();
            pfRepository = getPessoaFisicaRepository(conn);
            setupDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("IRPF");
        stage.setScene(getWelcomeScene(stage));
        stage.show();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_CONN_STRING);
    }

    private PessoaFisicaRepository getPessoaFisicaRepository(Connection conn) {
        return new JdbcPessoaFisicaRepository(conn);
    }

    private Scene getWelcomeScene(Stage stage) {
        return new WelcomeScene(stage, pfRepository);
    }

    private void setupDatabase() {
        try {
            final String query = "CREATE TABLE pessoa_fisica ("
                    + "nome VARCHAR(100) NOT NULL,"
                    + "cpf VARCHAR(11) NOT NULL,"
                    + "idade INTEGER NOT NULL,"
                    + "PRIMARY KEY (cpf)"
                    + ")";

            conn.prepareStatement(query).execute();
        } catch (SQLException ignore) {
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
