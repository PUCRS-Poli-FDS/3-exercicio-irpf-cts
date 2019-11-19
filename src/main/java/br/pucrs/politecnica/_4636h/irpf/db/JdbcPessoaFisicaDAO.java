package br.pucrs.politecnica._4636h.irpf.db;

import br.pucrs.politecnica._4636h.irpf.model.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPessoaFisicaDAO implements PessoaFisicaDAO {

    private final Connection connection;

    public JdbcPessoaFisicaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public PessoaFisica findByCPF(String cpf) {
        final String query = "SELECT * FROM pessoa_fisica WHERE cpf = ?";
        PessoaFisica pf = null;

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cpf);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pf = carregaPessoaFisica(rs);
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return pf;
    }

    private PessoaFisica carregaPessoaFisica(ResultSet rs) throws SQLException {
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        Integer idade = rs.getInt("idade");
        return new PessoaFisica(nome, cpf, idade);
    }

    @Override
    public void insert(PessoaFisica pessoa) {

    }
}
