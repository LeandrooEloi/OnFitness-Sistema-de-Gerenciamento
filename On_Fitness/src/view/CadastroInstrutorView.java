package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.InstrutorController;
import model.Instrutor;

public class CadastroInstrutorView extends JFrame {
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JTextField txtModalidadeInstrucao;
    private JButton btnSalvar, btnCancelar, btnVoltar;
    private JLabel lblNewLabel;

    public CadastroInstrutorView() {
        // Configurações principais da janela
        setTitle("Cadastro de Instrutor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Título
        JLabel lblTitulo = new JLabel("Cadastro de Instrutores");
        lblTitulo.setBackground(new Color(0, 0, 0));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBounds(97, 11, 300, 30);
        lblTitulo.setForeground(new Color(0, 0, 0));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitulo);

        // Campo Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(new Color(0, 0, 0));
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNome.setBounds(50, 80, 100, 25);
        getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
        txtNome.setBounds(200, 80, 250, 25);
        getContentPane().add(txtNome);

        // Campo Endereço
        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setForeground(new Color(0, 0, 0));
        lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEndereco.setBounds(50, 120, 100, 25);
        getContentPane().add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setFont(new Font("Arial", Font.PLAIN, 14));
        txtEndereco.setBounds(200, 120, 250, 25);
        getContentPane().add(txtEndereco);

        // Campo Telefone
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setForeground(new Color(0, 0, 0));
        lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTelefone.setBounds(50, 160, 100, 25);
        getContentPane().add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTelefone.setBounds(200, 160, 250, 25);
        getContentPane().add(txtTelefone);

        // Campo Modalidade de Instrução
        JLabel lblModalidadeInstrucao = new JLabel("Modalidade:");
        lblModalidadeInstrucao.setForeground(new Color(0, 0, 0));
        lblModalidadeInstrucao.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblModalidadeInstrucao.setBounds(50, 200, 150, 25);
        getContentPane().add(lblModalidadeInstrucao);

        txtModalidadeInstrucao = new JTextField();
        txtModalidadeInstrucao.setFont(new Font("Arial", Font.PLAIN, 14));
        txtModalidadeInstrucao.setBounds(200, 200, 250, 25);
        getContentPane().add(txtModalidadeInstrucao);

        // Botão Salvar
        btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 14));
        btnSalvar.setBackground(new Color(0, 102, 204));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setBounds(50, 280, 120, 30);
        btnSalvar.setFocusPainted(false);
        btnSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarInstrutor();
            }
        });
        getContentPane().add(btnSalvar);

        // Botão Cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCancelar.setBackground(new Color(204, 0, 0));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setBounds(190, 280, 120, 30);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparFormulario();
            }
        });
        getContentPane().add(btnCancelar);

        // Botão Voltar
        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setBackground(new Color(0, 128, 128));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setBounds(330, 280, 120, 30);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarTelaPrincipal();
            }
        });
        getContentPane().add(btnVoltar);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\VAIVAI.jpg"));
        lblNewLabel.setBounds(0, 41, 484, 288);
        getContentPane().add(lblNewLabel);
    }

    private void salvarInstrutor() {
        try {
            Instrutor instrutor = new Instrutor();
            instrutor.setNome(txtNome.getText());
            instrutor.setEndereco(txtEndereco.getText());
            instrutor.setTelefone(txtTelefone.getText());
            instrutor.setModalidadeInstrucao(txtModalidadeInstrucao.getText());

            InstrutorController instrutorController = new InstrutorController();
            instrutorController.salvarInstrutor(instrutor);

            JOptionPane.showMessageDialog(this, "Instrutor Cadastrado Com Sucesso!");
            limparFormulario();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar instrutor: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparFormulario() {
        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtModalidadeInstrucao.setText("");
    }

    private void voltarTelaPrincipal() {
        TelaPrincipalView telaPrincipal = new TelaPrincipalView();
        telaPrincipal.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroInstrutorView cadastroInstrutorView = new CadastroInstrutorView();
            cadastroInstrutorView.setVisible(true);
        });
    }
}
