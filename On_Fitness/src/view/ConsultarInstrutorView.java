package view;

import controller.InstrutorController;
import model.Instrutor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class ConsultarInstrutorView extends JFrame {
    private JTable tabelaInstrutores;
    private DefaultTableModel modeloTabela;
    private InstrutorController instrutorController;

    public ConsultarInstrutorView() {
        instrutorController = new InstrutorController();

        // Configurações principais da janela
        setTitle("Consulta de Instrutores");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Adicionar imagem de fundo
        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(-12, 0, 812, 400);
        lblBackground.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\VAIIII!!!.jpg"));
        getContentPane().add(lblBackground);

        // Tabela para exibir os instrutores
        tabelaInstrutores = new JTable();
        modeloTabela = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nome", "Endereço", "Telefone", "Modalidade"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // Impede edição da coluna ID
            }
        };
        tabelaInstrutores.setModel(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaInstrutores);
        scrollPane.setBounds(20, 50, 750, 200);
        lblBackground.add(scrollPane);

        // Botão para salvar alterações
        JButton btnSalvar = new JButton("Salvar Alterações");
        btnSalvar.setBackground(new Color(0, 0, 255));
        btnSalvar.setForeground(new Color(255, 255, 255));
        btnSalvar.setBounds(200, 270, 150, 30);
        btnSalvar.addActionListener(this::salvarAlteracoes);
        lblBackground.add(btnSalvar);

        // Botão para excluir instrutor
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBackground(new Color(255, 0, 0));
        btnExcluir.setForeground(new Color(255, 255, 255));
        btnExcluir.setBounds(400, 270, 120, 30);
        btnExcluir.addActionListener(this::excluirInstrutor);
        lblBackground.add(btnExcluir);

        // Botão para voltar
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(0, 128, 128));
        btnVoltar.setForeground(new Color(255, 255, 255));
        btnVoltar.setBounds(550, 270, 120, 30);
        btnVoltar.addActionListener(e -> dispose()); // Fecha a tela atual
        lblBackground.add(btnVoltar);

        carregarInstrutores(); // Carrega os dados ao abrir a tela
    }

    private void carregarInstrutores() {
        try {
            List<Instrutor> instrutores = instrutorController.listarInstrutores();
            modeloTabela.setRowCount(0); // Limpa a tabela
            for (Instrutor instrutor : instrutores) {
                modeloTabela.addRow(new Object[]{
                        instrutor.getId(),
                        instrutor.getNome(),
                        instrutor.getEndereco(),
                        instrutor.getTelefone(),
                        instrutor.getModalidadeInstrucao()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os instrutores: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarAlteracoes(ActionEvent e) {
        int linhas = modeloTabela.getRowCount();
        boolean sucesso = true;

        for (int i = 0; i < linhas; i++) {
            try {
                Instrutor instrutor = new Instrutor();
                instrutor.setId((int) modeloTabela.getValueAt(i, 0));
                instrutor.setNome((String) modeloTabela.getValueAt(i, 1));
                instrutor.setEndereco((String) modeloTabela.getValueAt(i, 2));
                instrutor.setTelefone((String) modeloTabela.getValueAt(i, 3));
                instrutor.setModalidadeInstrucao((String) modeloTabela.getValueAt(i, 4));

                instrutorController.atualizarInstrutor(instrutor);
            } catch (SQLException ex) {
                sucesso = false;
                JOptionPane.showMessageDialog(null, "Erro ao salvar alterações: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                sucesso = false;
                JOptionPane.showMessageDialog(null, "Verifique os dados inseridos: " + ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            carregarInstrutores();
        }
    }

    private void excluirInstrutor(ActionEvent e) {
        int linhaSelecionada = tabelaInstrutores.getSelectedRow();
        if (linhaSelecionada != -1) {
            int instrutorId = (int) modeloTabela.getValueAt(linhaSelecionada, 0);
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o instrutor?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                try {
                    instrutorController.excluirInstrutor(instrutorId);
                    JOptionPane.showMessageDialog(null, "Instrutor excluído com sucesso!");
                    carregarInstrutores(); // Atualiza a tabela após a exclusão
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir o instrutor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um instrutor para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConsultarInstrutorView consultarInstrutorView = new ConsultarInstrutorView();
            consultarInstrutorView.setVisible(true);
        });
    }
}
