package br.pucrs.politecnica._4636h.irpf.view;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

	public void exibir() {
		Scanner scanner = new Scanner(System.in);

		String nome = getNome(scanner);
		String cpf = getCPF(scanner);
		int idade = getIdade(scanner);
		Currency rendimento = Currency.valueOf(getRendimentos(scanner));
		Currency contribuicaoPrevidenciaria = Currency.valueOf(getContribuicaoPrev(scanner));
		Integer numDependentes = getDependentes(scanner);
		
		
		/*		
		Obs: Currency foi trocado pelo valor de double no metodo getRendimentos e getContribuicaoPrev.
		*/
		
		

		//-------------------------------------------------------------------------------------------------------------//

		Contribuinte contribuinte = new Contribuinte(nome, cpf, idade, rendimento, contribuicaoPrevidenciaria,numDependentes);

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

	private Integer getIdade(Scanner scanner) {
		int idade;

		try {
			System.out.println("Digite a idade do contribuinte: ");
			idade = scanner.nextInt();

			if (!isValidAge(idade)) {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Idade inválida");

			return getIdade(scanner);
		}

		return idade;
	}

	private static boolean isValidAge(int idade) {
		if (idade >= 0 || idade < 150) {
			return true;
		}
		return false;
	}

	private double getRendimentos(Scanner scanner) {
    	double rend;
    	
    	try {
    		System.out.println("Digite o total de rendimentos do contribuinte (use . para decimal): ");
    		
    		rend = scanner.nextDouble();
    		
    		if(rend <= 0) {
    			throw new IllegalArgumentException();
    		}
    	}catch (IllegalArgumentException e) {
    		System.out.println("Valor de rendimento não pode ser 0 ou valor negativo");
    		
    	return getRendimentos(scanner);	
    	}
    	return rend;
    	
    }
	
	private double getContribuicaoPrev(Scanner scanner) {
		double value;
		
		try {
			System.out.println("Digite a contribuição previdenciária do contribuinte: ");
			value = scanner.nextDouble();
			
			if(value <= 0) {
				throw new IllegalArgumentException();
			}
		}catch(IllegalArgumentException e) {
			System.out.println("Valor inválido, deve ser mais de 0");
			return getContribuicaoPrev(scanner);
		}
		return value;
	}
	private Integer getDependentes(Scanner scanner) {
		int dep;
		try {
			System.out.println("Digite o número de dependentes (opcional se o tipo de cálculo = SIMPLIFICADO): ");
			dep = scanner.nextInt();
			
			if(dep < 0) {
				throw new IllegalArgumentException();
			}	
			
		}catch(IllegalArgumentException e ) {
			System.out.println("Valor negativo é Inválido");
			return getDependentes(scanner);
		}
		return dep;
	}

	private char getTipoCalculo(Scanner scanner) {
		String type;
		
		try {
			System.out.println("Digite o tipo de cálculo ((S)imples ou (C)ompleto): ");
			type = scanner.nextLine();
			
			if(type.charAt(0) != 'C' || type.charAt(0) != 'S') {
				throw new IllegalArgumentException();
			}
			
		}catch(IllegalArgumentException e) {
			System.out.println("Tipo de cálculo inválido.");
			
			return getTipoCalculo(scanner);
		}
		return type.charAt(0);
	}
	
}
