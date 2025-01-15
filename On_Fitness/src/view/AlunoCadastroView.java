package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.AlunoController;
import model.Aluno;

public class AlunoCadastroView extends JFrame {
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtModalidade;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JTextField txtMensalidade;
    private JTextField txtTelefone; // Novo campo Telefone

    public AlunoCadastroView() {
        setTitle("Cadastro de Aluno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 450); // Altura ajustada para acomodar o campo Telefone
        setLocationRelativeTo(null); // Centraliza a janela na tela
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Cadastro de Alunos");
        lblTitulo.setBackground(new Color(0, 0, 0));
        lblTitulo.setForeground(new Color(0, 0, 0));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(27, 10, 397, 30);
        getContentPane().add(lblTitulo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(new Color(0, 0, 0));
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNome.setBounds(30, 60, 100, 20);
        getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(150, 60, 200, 20);
        getContentPane().add(txtNome);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEndereco.setForeground(new Color(0, 0, 0));
        lblEndereco.setBounds(30, 100, 100, 20);
        getContentPane().add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(150, 100, 200, 20);
        getContentPane().add(txtEndereco);

        JLabel lblModalidade = new JLabel("Modalidade:");
        lblModalidade.setForeground(new Color(0, 0, 0));
        lblModalidade.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblModalidade.setBounds(30, 140, 100, 20);
        getContentPane().add(lblModalidade);

        txtModalidade = new JTextField();
        txtModalidade.setBounds(150, 140, 200, 20);
        getContentPane().add(txtModalidade);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setForeground(new Color(0, 0, 0));
        lblPeso.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPeso.setBounds(30, 180, 100, 20);
        getContentPane().add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(150, 180, 200, 20);
        getContentPane().add(txtPeso);

        JLabel lblAltura = new JLabel("Altura (m):");
        lblAltura.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAltura.setForeground(new Color(0, 0, 0));
        lblAltura.setBounds(30, 220, 100, 20);
        getContentPane().add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(150, 220, 200, 20);
        getContentPane().add(txtAltura);

        JLabel lblMensalidade = new JLabel("Mensalidade:");
        lblMensalidade.setForeground(new Color(0, 0, 0));
        lblMensalidade.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMensalidade.setBounds(30, 260, 100, 20);
        getContentPane().add(lblMensalidade);

        txtMensalidade = new JTextField();
        txtMensalidade.setBounds(150, 260, 200, 20);
        getContentPane().add(txtMensalidade);

        // Novo campo: Telefone
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setForeground(new Color(0, 0, 0));
        lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTelefone.setBounds(30, 300, 100, 20);
        getContentPane().add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(150, 300, 200, 20);
        getContentPane().add(txtTelefone);

        // Botão Salvar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setForeground(new Color(255, 255, 255));
        btnSalvar.setBackground(new Color(0, 0, 255));
        btnSalvar.setBounds(50, 340, 100, 30);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAluno();
            }
        });
        getContentPane().add(btnSalvar);

        // Botão Cancelar
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(new Color(255, 255, 255));
        btnCancelar.setBackground(new Color(255, 0, 0));
        btnCancelar.setBounds(170, 340, 100, 30);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        getContentPane().add(btnCancelar);

        // Botão Voltar
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(0, 128, 128));
        btnVoltar.setForeground(new Color(255, 255, 255));
        btnVoltar.setBounds(290, 340, 100, 30);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarTelaPrincipal();
            }
        });
        getContentPane().add(btnVoltar);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\vai.jpg"));
        lblNewLabel.setBounds(-44, 10, 478, 390);
        getContentPane().add(lblNewLabel);
    }

    private void salvarAluno() {
        try {
            Aluno aluno = new Aluno();
            aluno.setNome(txtNome.getText());
            aluno.setEndereco(txtEndereco.getText());
            aluno.setModalidade(txtModalidade.getText());
            aluno.setPeso(Double.parseDouble(txtPeso.getText()));
            aluno.setAltura(Double.parseDouble(txtAltura.getText()));
            aluno.setMensalidade(Double.parseDouble(txtMensalidade.getText()));
            aluno.setTelefone(txtTelefone.getText()); // Adicionando telefone ao objeto

            AlunoController controller = new AlunoController();
            controller.salvarAluno(aluno);

            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar aluno: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtEndereco.setText("");
        txtModalidade.setText("");
        txtPeso.setText("");
        txtAltura.setText("");
        txtMensalidade.setText("");
        txtTelefone.setText(""); // Limpa o campo Telefone
    }

    private void voltarTelaPrincipal() {
        dispose(); // Fecha a janela atual
        // Aqui você pode abrir a tela principal caso necessário.
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AlunoCadastroView frame = new AlunoCadastroView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
