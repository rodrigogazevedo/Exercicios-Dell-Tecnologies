package br.dell.modelos;

/**
 * Representa os dados cadastrais do hóspede que irá se hospedar no hotel 
 * @author Rodrigo Guimarães de Azevedo
 * @version 3
 *
 */
public class Hospede {

	//Variáveis private da classe Hospede
	private long CPF;
	private long RG;
	private String nome;
	private int idade;
	private String endereco;
	
	//Construtor da classe Hospede - Sem parâmetro
	public Hospede() {
		
	}
	
	//Construtor da classe Hospede - Com todos os parâmetros
	public Hospede(long CPF, long RG, String nome, int idade, String endereco) {
		this.CPF = CPF;
		this.RG = RG;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	//Métodos gets e sets da classe Hospede
	public long getCPF() {
		return CPF;
	}
	
	public void setCPF(long cPF) {
		CPF = cPF;
	}
	
	public long getRG() {
		return RG;
	}
	
	public void setRG(long rG) {
		RG = rG;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
