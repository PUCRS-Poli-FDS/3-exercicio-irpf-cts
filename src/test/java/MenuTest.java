
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Scanner;

import org.junit.Test;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class MenuTest {

	@Test
	public void isValidCPFTest() {

		Currency totalRendimentos = Currency.valueOf(10000.00);
		Currency contribuicao = Currency.valueOf(1000.00);
		Contribuinte contribuinte = new Contribuinte("Anna Silva", "11122233350", 40, totalRendimentos, contribuicao);

		assertEquals(true, isValidCPF(contribuinte.getCpf()));

	}
	
	@Test
	public void cpfInvalidoDeveLancarException() {
		
		Currency totalRendimentos = Currency.valueOf(10000.00);
		Currency contribuicao = Currency.valueOf(1000.00);
		Contribuinte contribuinte = new Contribuinte("Anna Silva", "1112223335", 40, totalRendimentos, contribuicao);
		
		//assertThrows(IllegalArgumentException.class, () -> );
	}

		
	private static boolean isValidCPF(String cpf) {
		return cpf.length() == 11;
	}
}
