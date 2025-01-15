package model;

public class Instrutor {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String modalidadeInstrucao;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getModalidadeInstrucao() {
        return modalidadeInstrucao;
    }

    public void setModalidadeInstrucao(String modalidadeInstrucao) {
        this.modalidadeInstrucao = modalidadeInstrucao;
    }
}