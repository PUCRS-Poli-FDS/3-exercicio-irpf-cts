package br.pucrs.politecnica._4636h.irpf.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.ContribuinteDAO;

public class ContribuinteDaoJDBC implements ContribuinteDAO {

	private Connection conn;

	public ContribuinteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Contribuinte obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Contribuinte obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByCpf(String cpf) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contribuinte findByCPF(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM contribuintes WHERE contribuintes.cpf = ?"
					);
			st.setString(1, cpf);
			rs = st.executeQuery();
			if(rs.next()) {
				Contribuinte contribuinte = new Contribuinte();
				contribuinte.setNome(rs.getString("nome"));
				contribuinte.setCpf(rs.getString("cpf"));
				contribuinte.setIdade(rs.getInt("idade"));
			//	contribuinte.setTotalRendimentos(rs.getCurrency("total_rendimentos"));
			//	contribuinte.setContribuicaoPrevidenciaria(rs.getCurrency("contribuicao_prev"));
				contribuinte.setNumDependentes(rs.getInt("num_dependentes"));
				return contribuinte;
			}
			return null;
			
		}catch (SQLException e) {
			throw new DbException (e.getMessage());
		}
		
	}

	@Override
	public List<Contribuinte> findaAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
