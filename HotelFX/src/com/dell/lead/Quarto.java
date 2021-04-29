package com.dell.lead;

/**
 * Representa os dados do quarto que será oferecido ao hóspede
 * @author Rodrigo Guimarães de Azevedo
 * @version 3
 *
 */
public class Quarto {
	
	//Variáveis private da classe Quarto
	private int numero;
	private Hospede hospede;
	
	//Construtor da classe Quarto com os parametros números do quarto e um objeto da classe Hospede
	public Quarto(int numero, Hospede hospede) {
		this.numero = numero;
		this.hospede = hospede;
	}

	//Métodos gets e sets da classe Quarto
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	
}
