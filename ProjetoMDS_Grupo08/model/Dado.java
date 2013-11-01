package br.com.dld.model;

public class Dado {
	//Atributos
	int id;
	int valor;
	String opcao;
	String tipo;
	
	//Construtor vazio
	public Dado(){
		
	}
	
	public Dado(int id, int valor, String opcao, String tipo){
		this.id = id;
		this.valor = valor;
		this.opcao = opcao;
		this.tipo = tipo;
	}
	
	//Métodos de acesso
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}