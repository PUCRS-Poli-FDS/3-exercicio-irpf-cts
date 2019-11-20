package br.pucrs.politecnica._4636h.irpf.view;

import br.pucrs.politecnica._4636h.irpf.application.calculadora.CalculadoraIrpf;
import br.pucrs.politecnica._4636h.irpf.application.calculadora.CalculadoraIrpfFactory;
import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;
import br.pucrs.politecnica._4636h.irpf.model.PessoaFisica;
import br.pucrs.politecnica._4636h.irpf.model.TipoCalculo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalculadoraGridPane extends GridPane {

    private final Stage stage;
    private final PessoaFisica pessoa;
    private TextField tfContribuinte, tfCpf, tfIdade, tfNumDependentes, tfContribuicaoPrev, tfTotalRendimentos,
            tfImpostoRenda;
    private TipoCalculo tipoCalculo = TipoCalculo.COMPLETO;

    public CalculadoraGridPane(Stage stage, PessoaFisica pessoa) {
        this.stage = stage;
        this.pessoa = pessoa;

        this.setAlignment(Pos.TOP_CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        Text texto = new Text("Calcular Imposto de Renda");
        texto.setFont(Font.font("Tohama", FontWeight.NORMAL, 20));
        this.add(texto, 0, 0);

        Label lbContribuinte = new Label("Nome:");
        this.add(lbContribuinte, 0, 2);

        tfContribuinte = new TextField();
        tfContribuinte.setText(pessoa.getNome());
        tfContribuinte.setDisable(true);
        this.add(tfContribuinte, 1, 2);

        Label lbCpf = new Label("CPF:");
        this.add(lbCpf, 0, 3);

        tfCpf = new TextField();
        tfCpf.setText(pessoa.getCpf());
        tfCpf.setDisable(true);
        this.add(tfCpf, 1, 3);

        Label lbIdade = new Label("Idade:");
        this.add(lbIdade, 0, 4);

        tfIdade = new TextField();
        tfIdade.setText(pessoa.getIdade().toString());
        tfIdade.setDisable(true);
        this.add(tfIdade, 1, 4);

        Label lbNumDependentes = new Label("Número de Dependentes:");
        this.add(lbNumDependentes, 0, 5);

        tfNumDependentes = new TextField();
        this.add(tfNumDependentes, 1, 5);

        Label lbContribuicaoPrev = new Label("Contribuição Previdenciária:");
        this.add(lbContribuicaoPrev, 0, 6);

        tfContribuicaoPrev = new TextField();
        this.add(tfContribuicaoPrev, 1, 6);

        Label lbTotalRendimentos = new Label("Total de Rendimentos:");
        this.add(lbTotalRendimentos, 0, 7);

        tfTotalRendimentos = new TextField();
        this.add(tfTotalRendimentos, 1, 7);

        Label lbImpostoRenda = new Label("Imposto de Renda:");
        this.add(lbImpostoRenda, 0, 8);

        tfImpostoRenda = new TextField();
        tfImpostoRenda.setEditable(false);
        this.add(tfImpostoRenda, 1, 8);

        HBox hbBut = new HBox();
        hbBut.setAlignment(Pos.BOTTOM_CENTER);

        ToggleGroup tipoCalculoGroup = new ToggleGroup();

        RadioButton rbCompleto = new RadioButton("Cálculo Completo");
        rbCompleto.setToggleGroup(tipoCalculoGroup);
        rbCompleto.setSelected(true);
        hbBut.getChildren().add(rbCompleto);

        RadioButton rbSimplificado = new RadioButton("Simplificado");
        rbSimplificado.setToggleGroup(tipoCalculoGroup);
        hbBut.getChildren().add(rbSimplificado);

        tipoCalculoGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(rbCompleto)) {
                tipoCalculo = TipoCalculo.COMPLETO;
            } else if(newValue.equals(rbSimplificado)) {
                tipoCalculo = TipoCalculo.SIMPLIFICADO;
            }
        });

        Button butCalcular = new Button("Calcular");
        butCalcular.setOnAction(e -> trataCalcular());

        Button butCancelar = new Button("Cancelar");
        butCancelar.setOnAction(e -> trataCancelar());

        hbBut.getChildren().add(butCalcular);
        hbBut.getChildren().add(butCancelar);
        this.add(hbBut, 1, 11);
    }

    private void trataCalcular() {
        CalculadoraIrpf calculadora = new CalculadoraIrpfFactory().getCalculadora(tipoCalculo);
        Currency imposto = calculadora.calcular(getContribuinte());
        tfImpostoRenda.setText(imposto.getValue().toString());
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

    private Contribuinte getContribuinte() {
        PessoaFisica pf = new PessoaFisica("a", "a", 10);

        String nome = tfContribuinte.getText();
        String cpf = tfCpf.getText();
        Integer idade = Integer.parseInt(tfIdade.getText());
        Currency totalRendimentos = Currency.valueOf(Double.parseDouble(tfTotalRendimentos.getText()));
        Currency contribuicao = Currency.valueOf(Double.parseDouble(tfContribuicaoPrev.getText()));
        Integer numDependentes = Integer.parseInt(tfNumDependentes.getText());
        return new Contribuinte(pf, totalRendimentos, contribuicao, numDependentes);
    }
}
