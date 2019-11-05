package br.pucrs.politecnica._4636h.irpf;

import java.util.ArrayList;
import java.util.List;

import br.pucrs.politecnica._4636h.irpf.db.ContribuinteDaoJDBC;
import br.pucrs.politecnica._4636h.irpf.db.DB;
import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.ContribuinteDAO;

// método main para testes

public class App1 {
	public static void main (String [] args) {
		
		ContribuinteDAO contribuinteDAO = new ContribuinteDaoJDBC(DB.getConnection());
		/*
		System.out.println("=== Teste 1: findByCPF ===");		
		System.out.println(contribuinteDAO.findByCPF("75098814050"));
		
		System.out.println("=== Teste 2: insert ===");
		Contribuinte contribuinte1 = new Contribuinte();
		contribuinte1.setNome("Marco Polo");
		contribuinte1.setCpf("50098814040");
		contribuinte1.setIdade(45);
		contribuinte1.setNumDependentes(2);		
		contribuinteDAO.insert(contribuinte1);
		
		System.out.println("=== Teste 3: update ===");
		Contribuinte contribuinte = contribuinteDAO.findByCPF("50098814040");
		contribuinte.setIdade(70);
		contribuinteDAO.update(contribuinte);		
		
		System.out.println("=== Test 4: findAll ===");
		List<Contribuinte> lista = new ArrayList<>();
		lista = contribuinteDAO.findaAll();
		for(Contribuinte c : lista) {
			System.out.println(c);
		}
		
		*/

	}

}
