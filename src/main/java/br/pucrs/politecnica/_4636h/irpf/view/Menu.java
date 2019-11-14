package br.pucrs.politecnica._4636h.irpf.view;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

import java.util.Scanner;

public class Menu {

    public void exibir() {
        Scanner scanner = new Scanner(System.in);

        String nome = getNome(scanner);
        
        String cpf = getCPF(scanner);

        System.out.println("Digite a idade do contribuinte: ");
        Integer idade = scanner.nextInt();

        System.out.println("Digite o total de rendimentos do contribuinte (use . para decimal): ");
        Currency totalRendimentos = Currency.valueOf(scanner.nextDouble());

        System.out.println("Digite a contribuiÃ§Ã£o previdenciÃ¡ria do contribuinte: ");
        Currency contribuicaoPrevidenciaria = Currency.valueOf(scanner.nextDouble());

        System.out.println("Digite o nÃºmero de dependentes (opcional se o tipo de cÃ¡lculo = SIMPLIFICADO): ");
        Integer numDependentes = scanner.nextInt();

        System.out.println("Digite o tipo de cÃ¡lculo ((S)imples ou (C)ompleto): ");

        Contribuinte contribuinte = new Contribuinte(nome, cpf, idade, totalRendimentos, contribuicaoPrevidenciaria,
                numDependentes);

        System.out.println(contribuinte);
    }

    public String getNome(Scanner scanner) {
        String nome;

        try {
            System.out.println("Digite o nome do contribuinte: ");
            nome = scanner.nextLine();

            if (nome.length() < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Nome invÃ¡lido!");
            return getNome(scanner);
        }

        return nome;
    }

    public String getCPF(Scanner scanner) {
        String cpf;

        try {
            System.out.println("Digite o CPF do contribuinte: ");
            cpf = scanner.nextLine();

            if (!isValidCPF(cpf)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("CPF invÃ¡lido!");
            return getCPF(scanner);
        }

        return cpf;
    }

    private static boolean isValidCPF(String cpf) {
    	return cpf.length() == 11; 
    }
    
}
