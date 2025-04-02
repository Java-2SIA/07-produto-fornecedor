package br.fiap.fornecedor;

public class Fornecedor {
    private String nome;
    private long cnpj;

    public Fornecedor(String nome, long cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public long getCnpj() {
        return cnpj;
    }


}
