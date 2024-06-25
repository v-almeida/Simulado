package br.edu.up;

public class Endereco {
    private String rua;
    private String cidade;
    private int pessoaId;

    public Endereco(String rua, String cidade, int pessoaId) {
        this.rua = rua;
        this.cidade = cidade;
        this.pessoaId = pessoaId;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

    public int getPessoaId() {
        return pessoaId;
    }
}
