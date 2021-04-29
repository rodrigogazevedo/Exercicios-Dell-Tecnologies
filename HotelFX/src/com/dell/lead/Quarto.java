package com.dell.lead;

/**
 * Representa os dados do quarto que ser� oferecido ao h�spede
 * @author Rodrigo Guimar�es de Azevedo
 * @version 3
 *
 */
public class Quarto {
	
	//Vari�veis private da classe Quarto
	private int numero;
	private Hospede hospede;
	
	//Construtor da classe Quarto com os parametros n�meros do quarto e um objeto da classe Hospede
	public Quarto(int numero, Hospede hospede) {
		this.numero = numero;
		this.hospede = hospede;
	}

	//M�todos gets e sets da classe Quarto
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
