package model;

public class Tipo {

	public int id;
	public String nome;
	public String descricao;

	public Tipo(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public int getid() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "ID: " + id + " | Nome: " + nome + " | Descrição: " + descricao;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}