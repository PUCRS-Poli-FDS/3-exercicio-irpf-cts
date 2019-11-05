package br.pucrs.politecnica._4636h.irpf.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		try {
			String insert = "INSERT INTO contribuintes " + "(nome, cpf, idade, num_dependentes) " + "VALUES "
					+ "(?, ?, ?, ?) ";

			conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(insert);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setInt(3, obj.getIdade());
			st.setInt(4, obj.getNumDependentes());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void update(Contribuinte obj) {
		String sql = "UPDATE contribuintes SET " + "nome = ?, cpf = ?, idade = ?, num_dependentes = ? "
				+ "WHERE cpf = ? ";
		try {
			conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setInt(3, obj.getIdade());
			st.setInt(4, obj.getNumDependentes());
			st.setString(5, obj.getCpf());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void deleteByCpf(String cpf) {

		
	}

	@Override
	public Contribuinte findByCPF(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM contribuintes WHERE contribuintes.cpf = ?");
			st.setString(1, cpf);
			rs = st.executeQuery();
			if (rs.next()) {
				Contribuinte contribuinte = new Contribuinte();
				contribuinte.setNome(rs.getString("nome"));
				contribuinte.setCpf(rs.getString("cpf"));
				contribuinte.setIdade(rs.getInt("idade"));
				// contribuinte.setTotalRendimentos(rs.getCurrency("total_rendimentos"));
				// contribuinte.setContribuicaoPrevidenciaria(rs.getCurrency("contribuicao_prev"));
				contribuinte.setNumDependentes(rs.getInt("num_dependentes"));
				return contribuinte;
			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public List<Contribuinte> findaAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM contribuintes ");
			rs = st.executeQuery();
			List<Contribuinte> contribuintes = new ArrayList<>();
			while(rs.next()) {
				Contribuinte contribuinte = new Contribuinte();
				contribuinte.setNome(rs.getString("nome"));
				contribuinte.setCpf(rs.getString("cpf"));
				contribuinte.setIdade(rs.getInt("idade"));
				contribuinte.setNumDependentes(rs.getInt("num_dependentes"));
				contribuintes.add(contribuinte);
			}
			return contribuintes;
			
		}catch (SQLException e) {
			throw new DbException (e.getMessage());
		}
	}

}
