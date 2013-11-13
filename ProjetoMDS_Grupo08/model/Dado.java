package model;

public class  Dado {
	
	//Atributos
	String regiao;
	String opcao;
	String tipo;
	int ano;
	int valor;
	
	//Construtor vazio
	public Dado(){
		
	}
	
	public Dado(String regiao, String opcao, String tipo, int ano, int valor){
		}
	
	//Metodos de acesso gets e sets
	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
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
	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}