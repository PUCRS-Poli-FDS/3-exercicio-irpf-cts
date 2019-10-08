package br.pucrs.politecnica._4636h.irpf.view;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

import java.util.Scanner;

public class Menu {

    public void exibir() {
        Scanner scanner = new Scanner(System.in);

        String nome = getNome(scanner);

        S

        System.out.println("Digite a idade do contribuinte: ");
        Integer idade = scanner.nextInt();

        System.out.println("Digite o total de rendimentos do contribuinte (use . para decimal): ");
        Currency totalRendimentos = Currency.valueOf(scanner.nextDouble());

        System.out.println("Digite a contribuição previdenciária do contribuinte: ");
        Currency contribuicaoPrevidenciaria = Currency.valueOf(scanner.nextDouble());

        System.out.println("Digite o número de dependentes (opcional se o tipo de cálculo = SIMPLIFICADO): ");
        Integer numDependentes = scanner.nextInt();

        System.out.println("Digite o tipo de cálculo ((S)imples ou (C)ompleto): ");

        Contribuinte contribuinte = new Contribuinte(nome, cpf, idade, totalRendimentos, contribuicaoPrevidenciaria,
                numDependentes);

        System.out.println(contribuinte);
    }

    private String getNome(Scanner scanner) {
        String nome;

        try {
            System.out.println("Digite o nome do contribuinte: ");
            nome = scanner.nextLine();

            if (nome.length() < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Nome inválido!");
            return getNome(scanner);
        }

        return nome;
    }

    private String getCPF(Scanner scanner) {
        String cpf;

        try {
            System.out.println("Digite o CPF do contribuinte: ");
            cpf = scanner.nextLine();

            if (!isValidCPF(cpf)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("CPF inválido!");
            return getCPF(scanner);
        }

        return cpf;
    }

    private static boolean isValidCPF(String cpf) {
   
    	return cpf.length() == 11; 
    }
    
}
