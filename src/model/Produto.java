package model;

public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private double valor;
    private String unidade;
    private int refTipo;

    public Produto(int id, String nome, String descricao, double valor, String unidade, int refTipo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
        this.refTipo = refTipo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public int getRefTipo() {
        return refTipo;
    }
}
