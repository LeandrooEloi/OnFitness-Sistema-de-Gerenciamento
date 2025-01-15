package dao;

import model.Instrutor;
import util.ConexaoDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrutorDAO {
    public void salvar(Instrutor instrutor) throws SQLException {
        String sql = "INSERT INTO instrutores (nome, endereco, telefone, modalidade_instrucao) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getEndereco());
            stmt.setString(3, instrutor.getTelefone());
            stmt.setString(4, instrutor.getModalidadeInstrucao());
            stmt.executeUpdate();
        }
    }

    public List<Instrutor> listarTodos() throws SQLException {
        List<Instrutor> instrutores = new ArrayList<>();
        String sql = "SELECT * FROM instrutores";
        try (Connection conn = ConexaoDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Instrutor instrutor = new Instrutor();
                instrutor.setId(rs.getInt("id"));
                instrutor.setNome(rs.getString("nome"));
                instrutor.setEndereco(rs.getString("endereco"));
                instrutor.setTelefone(rs.getString("telefone"));
                instrutor.setModalidadeInstrucao(rs.getString("modalidade_instrucao"));
                instrutores.add(instrutor);
            }
        }
        return instrutores;
    }

    public void atualizar(Instrutor instrutor) throws SQLException {
        String sql = "UPDATE instrutores SET nome = ?, endereco = ?, telefone = ?, modalidade_instrucao = ? WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, instrutor.getNome());
            stmt.setString(2, instrutor.getEndereco());
            stmt.setString(3, instrutor.getTelefone());
            stmt.setString(4, instrutor.getModalidadeInstrucao());
            stmt.setInt(5, instrutor.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM instrutores WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}