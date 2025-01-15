package controller;

import dao.InstrutorDAO;
import model.Instrutor;
import java.sql.SQLException;
import java.util.List;

public class InstrutorController {
    private InstrutorDAO instrutorDAO;

    public InstrutorController() {
        this.instrutorDAO = new InstrutorDAO();
    }

    public void salvarInstrutor(Instrutor instrutor) throws SQLException {
        instrutorDAO.salvar(instrutor);
    }

    public List<Instrutor> listarInstrutores() throws SQLException {
        return instrutorDAO.listarTodos();
    }

    public void atualizarInstrutor(Instrutor instrutor) throws SQLException {
        instrutorDAO.atualizar(instrutor);
    }

    public void excluirInstrutor(int id) throws SQLException {
        instrutorDAO.excluir(id);
    }
}
